package com.subhranil.jsonhandler;

import org.junit.Test;

public class JsonArrayHolderTest {
    @Test public void test(){
        JsonArrayHolder test = new JsonArrayHolder();
        test.add(1);
        test.writeJsonToDisk("F:\\test.json");
        System.out.println(test.get(0));
    }
}
