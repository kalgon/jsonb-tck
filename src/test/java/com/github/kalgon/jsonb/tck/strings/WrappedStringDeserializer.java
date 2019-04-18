package com.github.kalgon.jsonb.tck.strings;

import javax.json.bind.serializer.DeserializationContext;
import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.stream.JsonParser;
import java.lang.reflect.Type;

public class WrappedStringDeserializer implements JsonbDeserializer<WrappedString> {

    @Override
    public WrappedString deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Type type) {
        return new WrappedString(jsonParser.getString());
    }
}
