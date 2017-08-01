package jsonparser;

import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.ArrayList;
import java.util.List;

public class SimpleJsonParser {

    Parser parser;

    public SimpleJsonParser() {
        addParser(new NumberParser()).setNext(new StringParser()).setNext(new ObjectParser());
    }

    SimpleJsonParser(ArrayList<Parser> parserList){
        parser = parserList.get(0);
        for (int i = 1; i < parserList.size(); i++) {
            parserList.get(i-1).setNext(parserList.get(i));
        }
        parserList.get(parserList.size()-1).setNext(new NumberParser())
                .setNext(new StringParser())
                .setNext(new NumberParser())
                .setNext(new ObjectParser());
    }

    public String toJson(Object o){

        return serialize(o).toString();
    }

    public JsonValue serialize(Object o){
        Context context = new Context();
        context.setParser(this);
        JsonValue object = parser.parse(o, context);
        return object;
    }

    Parser addParser(Parser parser){
        this.parser = parser;
        return parser;
    }
}
