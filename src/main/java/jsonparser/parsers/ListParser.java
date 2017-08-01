package jsonparser.parsers;

import jsonparser.Context;
import jsonparser.abstractClasses.Parser;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonValue;
import java.util.AbstractList;
import java.util.List;

public class ListParser extends Parser {
    @Override
    public JsonValue parse(Object object, Context context) {
        if (object instanceof AbstractList){
            JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
            List list = (List) object;
            list.forEach(value-> arrayBuilder.add(context.getParser().serialize(value)));
            return arrayBuilder.build();
        }
        return getNext().parse(object, context);
    }
}
