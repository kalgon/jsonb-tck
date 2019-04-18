package com.github.kalgon.jsonb.tck.enums;

import javax.json.bind.adapter.JsonbAdapter;

public class AnswerToBooleanAdapter implements JsonbAdapter<Answer, Boolean> {

    @Override
    public Boolean adaptToJson(Answer obj) {
        switch (obj) {
            case YES:
                return Boolean.TRUE;
            case NO:
                return Boolean.FALSE;
            case MAYBE:
                return null;
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public Answer adaptFromJson(Boolean obj) {
        return obj == null ? Answer.MAYBE : obj ? Answer.YES : Answer.NO;
    }
}
