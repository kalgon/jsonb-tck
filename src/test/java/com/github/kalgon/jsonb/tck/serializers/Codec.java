package com.github.kalgon.jsonb.tck.serializers;

import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.bind.serializer.JsonbSerializer;

public interface Codec<T> extends JsonbSerializer<T>, JsonbDeserializer<T> {
}
