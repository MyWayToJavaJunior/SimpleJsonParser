package jsonparser;

import javax.json.JsonObjectBuilder;

public class Context {
    JsonObjectBuilder builder;
    SimpleJsonParser parser;

    public JsonObjectBuilder getBuilder() {
        return builder;
    }

    public void setBuilder(JsonObjectBuilder builder) {
        this.builder = builder;
    }

    public SimpleJsonParser getParser() {
        return parser;
    }

    public void setParser(SimpleJsonParser parser) {
        this.parser = parser;
    }
}
