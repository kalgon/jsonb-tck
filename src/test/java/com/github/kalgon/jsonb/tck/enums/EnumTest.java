package com.github.kalgon.jsonb.tck.enums;

import com.github.kalgon.jsonb.tck.JsonbTest;

import javax.json.bind.Jsonb;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnumTest {

    @JsonbTest
    public void writeEnum(Jsonb jsonb) {
        assertEquals("\"MAYBE\"", jsonb.toJson(Answer.MAYBE));
    }

    @JsonbTest(adapters = AnswerToIntegerAdapter.class)
    public void writeEnumWithAdapter(Jsonb jsonb) {
        assertEquals("2", jsonb.toJson(Answer.MAYBE));
    }

    @JsonbTest(adapters = AnswerToJsonValueAdapter.class)
    public void writeEnumWithAdapter2(Jsonb jsonb) {
        assertEquals("null", jsonb.toJson(Answer.MAYBE));
    }

    @JsonbTest(adapters = AnswerToBooleanAdapter.class)
    public void writeEnumWithAdapter3(Jsonb jsonb) {
        assertEquals("null", jsonb.toJson(Answer.MAYBE));
    }

    @JsonbTest
    public void readEnum(Jsonb jsonb) {
        assertEquals(Answer.MAYBE, jsonb.fromJson("\"MAYBE\"", Answer.class));
    }

    @JsonbTest(adapters = AnswerToIntegerAdapter.class)
    public void readEnumWithAdapter(Jsonb jsonb) {
        assertEquals(Answer.MAYBE, jsonb.fromJson("2", Answer.class));
    }

    @JsonbTest(adapters = AnswerToJsonValueAdapter.class)
    public void readEnumWithAdapter2(Jsonb jsonb) {
        assertEquals(Answer.MAYBE, jsonb.fromJson("null", Answer.class));
    }

    @JsonbTest(adapters = AnswerToBooleanAdapter.class)
    public void readEnumWithAdapter3(Jsonb jsonb) {
        assertEquals(Answer.MAYBE, jsonb.fromJson("null", Answer.class));
    }
}
