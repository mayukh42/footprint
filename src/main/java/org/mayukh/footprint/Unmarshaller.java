package org.mayukh.footprint;

import org.mayukh.jparse.parser.Parser;
import org.mayukh.jparse.types.Json;
import org.mayukh.jparse.types.ListV;
import org.mayukh.jparse.types.StringV;
import org.mayukh.jparse.types.Value;

import java.lang.reflect.Method;

/**
 * Created by mayukh42 on 7/12/2017.
 *
 * Unmarshaller for marshalled objects
 */
public class Unmarshaller {

    /**
     * apply(): read json from given file and unmarshall into object
     */
    public static Object apply(String location, String jsonFile) {
        Parser jsonParser = new Parser();
        Json root;
        if (location != null && location.length() > 1)
            root = (Json) jsonParser.parseJsonFile(location, jsonFile);
        else
            root = (Json) jsonParser.parseJsonFile("src/main/resources/footprint/", jsonFile);
        return consume(root);
    }

    /**
     * Unmarshall from Value graph (JSON root object) recursively. See Value type in jparse
     */
    private static Object consume(Json root) {
        String className = ((StringV) root.get("class")).getValue();
        ListV fieldList = (ListV) root.get("fields");
        Object o = null;

        try {
            Class oClass = Class.forName(className);
            o = oClass.newInstance();

            for (Value field : fieldList.getValues()) {
                Json details = (Json) field;
                String variable = ((StringV) details.get("variable")).getValue();
                String type = ((StringV) details.get("type")).getValue();

                // create setter method
                String setter = "set" + variable.substring(0, 1).toUpperCase() + variable.substring(1);
                Method setterMethod = oClass.getMethod(setter, Class.forName(type));

                if (details.keys().contains("value") && details.keys().contains("ref"))
                    throw new UnmarshallerException("Marshalled object cannot contain both value and ref");

                if (details.keys().contains("value")) {
                    // primitive (raw) type
                    String value = ((StringV) details.get("value")).getValue();
                    Object valueObject = Primitives.create(type, value);
                    setterMethod.invoke(o, valueObject);
                }
                else if (details.keys().contains("ref")) {
                    // reference types
                    Json ref = (Json) details.get("ref");
                    Object refObject = consume(ref);
                    setterMethod.invoke(o, refObject);
                }
                else throw new UnmarshallerException("Marshalled object should contain at least one of value or ref");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return o;
    }
}
