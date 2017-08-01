package app;

import jsonparser.SimpleJsonParser;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class Main {
    public static void main(String[] args) {
        SimpleJsonParser parser = new SimpleJsonParser();
        System.out.println(parser.toJson(new Test()));
    }

    public static class Test{
        int i= 1;
        String s = "2";
    }
}
