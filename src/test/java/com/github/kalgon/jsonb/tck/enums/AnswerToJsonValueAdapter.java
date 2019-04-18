package com.github.kalgon.jsonb.tck.enums;

import javax.json.JsonValue;
import javax.json.bind.adapter.JsonbAdapter;

public class AnswerToJsonValueAdapter implements JsonbAdapter<Answer, JsonValue> {

    @Override
    public JsonValue adaptToJson(Answer obj) {
        switch (obj) {
            case YES:
                return JsonValue.TRUE;
            case NO:
                return JsonValue.FALSE;
            case MAYBE:
                return JsonValue.NULL;
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public Answer adaptFromJson(JsonValue obj) {
        switch (obj.getValueType()) {
            case TRUE:
                return Answer.YES;
            case FALSE:
                return Answer.NO;
            case NULL:
                return Answer.MAYBE;
            default:
                throw new IllegalArgumentException();
        }
    }
}
