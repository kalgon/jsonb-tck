package com.github.kalgon.jsonb.tck.strings;

import javax.json.bind.serializer.JsonbSerializer;
import javax.json.bind.serializer.SerializationContext;
import javax.json.stream.JsonGenerator;

public class WrappedStringSerializer implements JsonbSerializer<WrappedString> {

    @Override
    public void serialize(WrappedString obj, JsonGenerator generator, SerializationContext ctx) {
        generator.write(obj.getValue());
    }
}
