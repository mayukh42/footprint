package org.mayukh.footprint;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mayukh42 on 7/11/2017.
 */
public class Primitives {

    private static final Set<String> rawTypes = new HashSet<>(Arrays.asList(
            "java.lang.String",
            "java.lang.Integer",
            "java.lang.Double",
            "java.time.LocalDate"
    ));

    /** isRawType(): returns true if the argument is a raw type.
     * Clients must use this method rather than a getter of the rawTypes set.
     */
    static boolean isRawType(String type) {
        return rawTypes.contains(type);
    }

    static Object create(String type, String value) {
        Object o = null;
        switch (type) {
            case "java.lang.Integer":
                o = Integer.valueOf(value);
                break;
            case "java.lang.Double":
                o = Double.valueOf(value);
                break;
            case "java.time.LocalDate":
                o = LocalDate.parse(value);
                break;
            case "java.lang.String":
                o = String.valueOf(value);
                break;
            default:
                throw new UnmarshallerException("type is not a raw type");
        }
        return o;
    }
}
