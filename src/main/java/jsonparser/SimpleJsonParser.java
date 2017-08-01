package jsonparser;

import jsonparser.abstractClasses.Parser;
import jsonparser.parsers.ListParser;
import jsonparser.parsers.NumberParser;
import jsonparser.parsers.ObjectParser;
import jsonparser.parsers.StringParser;

import javax.json.JsonValue;
import java.util.ArrayList;

public class SimpleJsonParser {

    private Parser parser;

    public SimpleJsonParser() {
        addParser(new NumberParser())
                .setNext(new StringParser())
                .setNext(new ListParser())
                .setNext(new ObjectParser());
    }

    SimpleJsonParser(ArrayList<Parser> parserList){
        parser = parserList.get(0);
        for (int i = 1; i < parserList.size(); i++) {
            parserList.get(i-1).setNext(parserList.get(i));
        }
        parserList.get(parserList.size()-1).setNext(new NumberParser())
                .setNext(new StringParser())
                .setNext(new ListParser())
                .setNext(new NumberParser())
                .setNext(new ObjectParser());
    }

    public String toJson(Object o){

        return serialize(o).toString();
    }

    public JsonValue serialize(Object o){
        Context context = new Context();
        context.setParser(this);
        return parser.parse(o, context);
    }

    private Parser addParser(Parser parser){
        this.parser = parser;
        return parser;
    }
}
