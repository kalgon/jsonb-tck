package com.github.kalgon.jsonb.tck.strings;

import com.github.kalgon.jsonb.tck.EmbeddedJsonValue;
import com.github.kalgon.jsonb.tck.JsonbTest;

import javax.json.Json;
import javax.json.JsonString;
import javax.json.JsonValue;
import javax.json.bind.Jsonb;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {

    private static final String STRING = "hello";
    private static final WrappedString WRAPPED_STRING = new WrappedString(STRING);
    private static final JsonValue JSON_VALUE = Json.createValue(STRING);
    private static final EmbeddedJsonValue EMBEDDED_JSON_VALUE = new EmbeddedJsonValue(JSON_VALUE);

    private static final String JSON = "\"hello\"";
    private static final String EMBEDDED_JSON = "{\"embedded\":\"hello\"}";

    @JsonbTest
    public void writeString(Jsonb jsonb) {
        assertEquals(JSON, jsonb.toJson(STRING));
    }

    @JsonbTest
    public void writeJsonString(Jsonb jsonb) {
        assertEquals(JSON, jsonb.toJson(JSON_VALUE));
    }

    @JsonbTest
    public void writeWrappedJsonValue(Jsonb jsonb) {
        assertEquals(EMBEDDED_JSON, jsonb.toJson(EMBEDDED_JSON_VALUE));
    }

    @JsonbTest(adapters = WrappedStringAdapter.class)
    public void writeStringValueTypeWithAdapter(Jsonb jsonb) {
        assertEquals(JSON, jsonb.toJson(WRAPPED_STRING));
    }

    @JsonbTest(serializers = WrappedStringSerializer.class)
    public void writeStringValueTypeWithSerializer(Jsonb jsonb) {
        assertEquals(JSON, jsonb.toJson(WRAPPED_STRING));
    }

    @JsonbTest
    public void readStringAsString(Jsonb jsonb) {
        assertEquals(STRING, jsonb.fromJson(JSON, String.class));
    }

    @JsonbTest
    public void readStringAsObject(Jsonb jsonb) {
        assertEquals(STRING, jsonb.fromJson(JSON, Object.class));
    }

    @JsonbTest
    public void readStringAsJsonString(Jsonb jsonb) {
        assertEquals(JSON_VALUE, jsonb.fromJson(JSON, JsonString.class));
    }

    @JsonbTest
    public void readStringAsJsonValue(Jsonb jsonb) {
        assertEquals(JSON_VALUE, jsonb.fromJson(JSON, JsonValue.class));
    }

    @JsonbTest
    public void readStringAsWrappedJsonValue(Jsonb jsonb) {
        assertEquals(EMBEDDED_JSON_VALUE, jsonb.fromJson(EMBEDDED_JSON, EmbeddedJsonValue.class));
    }

    @JsonbTest(adapters = WrappedStringAdapter.class)
    public void readStringAsStringValueTypeWithAdapter(Jsonb jsonb) {
        assertEquals(WRAPPED_STRING, jsonb.fromJson(JSON, WrappedString.class));
    }

    @JsonbTest(deserializers = WrappedStringDeserializer.class)
    public void readStringAsStringValueTypeWithDeserializer(Jsonb jsonb) {
        assertEquals(WRAPPED_STRING, jsonb.fromJson(JSON, WrappedString.class));
    }
}
