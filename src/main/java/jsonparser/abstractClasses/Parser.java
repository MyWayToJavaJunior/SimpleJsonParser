package jsonparser.abstractClasses;

import jsonparser.Context;

import javax.json.JsonValue;

public abstract class Parser {
    Parser next = null;

    public abstract JsonValue parse(Object object, Context context);

    protected Parser getNext() {
        return next;
    }

    public Parser setNext(Parser next){
        this.next = next;
        return next;
    }

    public boolean hasNext(){
        return next!=null;
    }
}
