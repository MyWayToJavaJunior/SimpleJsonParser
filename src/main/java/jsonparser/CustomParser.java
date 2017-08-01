package jsonparser;

import javax.json.JsonValue;

public abstract class CustomParser extends Parser {
    Class type;

    public void serialize(Object o, Class type){

    }

    @Override
    public JsonValue parse(Object object, Context context) {
        return null;
    }
}
