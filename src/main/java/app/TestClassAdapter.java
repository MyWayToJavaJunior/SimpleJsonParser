package app;

import jsonparser.Context;
import jsonparser.abstractClasses.CustomParser;

import javax.json.JsonObjectBuilder;

public class TestClassAdapter extends CustomParser {

    @Override
    public JsonObjectBuilder serialize(Object o, Context context) {
        JsonObjectBuilder objectBuilder = context.getBuilder();
        objectBuilder.add("myStr", ((TestObject)o).getStr());
        objectBuilder.add("myInt", ((TestObject)o).getInteger());

        return objectBuilder;
    }
}
