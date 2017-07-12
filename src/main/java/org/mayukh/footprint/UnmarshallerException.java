package org.mayukh.footprint;

/**
 * Created by mayukh42 on 7/12/2017.
 */
public class UnmarshallerException extends RuntimeException {

    public UnmarshallerException(String message) {
        super("[Footprint] Marshalled json invalid! " + message);
    }
}
