package com.github.kalgon.jsonb.tck.serializers;

import javax.json.bind.serializer.JsonbSerializer;
import javax.json.bind.serializer.SerializationContext;
import javax.json.stream.JsonGenerator;

public interface ToStringSerializer<T> extends JsonbSerializer<T> {

    @Override
    default void serialize(T obj, JsonGenerator generator, SerializationContext ctx) {
        generator.write(obj.toString());
    }
}
