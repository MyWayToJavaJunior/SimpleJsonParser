package app;

import jsonparser.SimpleJsonParser;
import jsonparser.SimpleJsonParserBuilder;

import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        Object test = new Test();

        SimpleJsonParser parser = new SimpleJsonParserBuilder()
                .setTypeAdapter(new TestClassAdapter(), TestObject.class)
                .build();
        System.out.println(parser.toJson(new Test()));
    }

    public static class Test{
        int i= 1;
        String s = "2";
        TestObject o;
        ArrayList<String> list;

        public Test(){
            list = new ArrayList<>(Arrays.asList("qwe","www"));
            o = new TestObject();
        }
    }
}
