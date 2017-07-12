package org.mayukh.footprint;

import org.junit.Test;
import org.mayukh.footprint.model.auto.Engine;

/**
 * Created by mayukh42 on 7/12/2017.
 */
public class UnmarshallerTest {

    @Test
    public void testSimplePojo() {
        Object tdi = Unmarshaller.apply(null, "simple.json");
        System.out.println(tdi);
    }

    @Test
    public void testOneLevelNested() {
        Object pompom = Unmarshaller.apply(null, "onelevel.json");
        System.out.println(pompom);
    }

    @Test
    public void testMultiLevelNested() {
        Object polo = Unmarshaller.apply(null, "multilevel.json");
        System.out.println(polo);
    }
}
