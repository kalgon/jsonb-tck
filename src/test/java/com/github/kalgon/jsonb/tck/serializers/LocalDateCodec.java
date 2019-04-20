package com.github.kalgon.jsonb.tck.serializers;

import javax.json.JsonObject;
import javax.json.bind.serializer.DeserializationContext;
import javax.json.bind.serializer.SerializationContext;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;
import java.lang.reflect.Type;
import java.time.LocalDate;

public class LocalDateCodec implements Codec<LocalDate> {

    @Override
    public LocalDate deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {
        JsonObject obj = parser.getObject();
        return LocalDate.of(obj.getInt("year"), obj.getInt("month"), obj.getInt("day"));
    }

    @Override
    public void serialize(LocalDate obj, JsonGenerator generator, SerializationContext ctx) {
        generator.writeStartObject()
                .write("year", obj.getYear())
                .write("month", obj.getMonthValue())
                .write("day", obj.getDayOfMonth())
                .writeEnd();
    }
}
