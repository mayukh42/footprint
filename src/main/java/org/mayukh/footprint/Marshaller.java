package org.mayukh.footprint;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import static org.mayukh.footprint.Primitives.*;

/**
 * Created by mayukh42 on 7/10/2017.
 *
 * Marshalling utility
 */
public class Marshaller {

    public static String apply(Object object) {
        // marshall object to a JSON string
        return emit(object).toString();
    }

    /**
     * emit(): recursively create the object graph (JSON).
     * Emits RFC-4627 standard JSON.
     * Contains all information required to reconstruct the object graph from JSON graph.
     *
     * TODO: null, true, false (as of 0.17.7 jparse does not support these literals)
     */
    private static StringBuilder emit(Object object) {
        StringBuilder sb = new StringBuilder();
        if (object == null) {
            sb.append("\"null\"");
            return sb;
        }

        sb.append("{\"class\": \"").append(object.getClass().getName()).append('"');
        Field[] fields = object.getClass().getDeclaredFields();
        sb.append(", \"fields\": [");
        try {
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                if (!Modifier.isTransient(field.getModifiers())) {
                    sb.append("{\"variable\": \"").append(field.getName()).append("\",");
                    sb.append("\"type\": \"").append(field.getType().getName()).append("\",");
                    field.setAccessible(true);

                    if (isPrimitiveType(field.getType().getName()))
                        sb.append("\"value\": \"").append(field.get(object)).append('"');
                    else sb.append("\"ref\": ").append(emit(field.get(object)));
                    sb.append('}');
                }
                if (i < fields.length - 1) sb.append(',');
            }
            sb.append("]}");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb;
    }
}
