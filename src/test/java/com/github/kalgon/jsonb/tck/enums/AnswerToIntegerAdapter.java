package com.github.kalgon.jsonb.tck.enums;

import javax.json.bind.adapter.JsonbAdapter;

public class AnswerToIntegerAdapter implements JsonbAdapter<Answer, Integer> {

    @Override
    public Integer adaptToJson(Answer answer) {
        return answer.ordinal();
    }

    @Override
    public Answer adaptFromJson(Integer integer) {
        return Answer.values()[integer];
    }
}
