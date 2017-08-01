package jsonparser.parsers;

import jsonparser.Context;
import jsonparser.ReflectionHelper;
import jsonparser.abstractClasses.Parser;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import java.lang.reflect.Field;

public class ObjectParser extends Parser {
    public JsonValue parse(Object object, Context context) {
        JsonObjectBuilder builder = Json.createObjectBuilder();

        Field[] fields = ReflectionHelper.getFields(object);

        for (Field f:fields) {
            String name = f.getName();
            Object value = ReflectionHelper.getFieldValue(object, name);
            builder.add(name, context.getParser().serialize(value));
        }

        return builder.build();
    }
}
