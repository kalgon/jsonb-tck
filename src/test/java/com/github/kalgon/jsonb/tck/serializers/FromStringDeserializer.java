package com.github.kalgon.jsonb.tck.serializers;

import javax.json.bind.serializer.DeserializationContext;
import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.stream.JsonParser;
import java.lang.reflect.Type;

public interface FromStringDeserializer<T> extends JsonbDeserializer<T> {

    @Override
    default T deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {
        return deserialize(parser.getString());
    }
    
    T deserialize(String obj);
}
