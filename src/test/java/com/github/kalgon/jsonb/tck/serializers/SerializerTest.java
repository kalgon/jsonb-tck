package com.github.kalgon.jsonb.tck.serializers;

import com.github.kalgon.jsonb.tck.JsonbTest;

import javax.json.bind.Jsonb;
import java.net.URI;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SerializerTest {

    @JsonbTest(serializers = URICodec.class)
    public void writeWithAdapterHierarchy(Jsonb jsonb) {
        assertEquals("\"http://apache.org\"", jsonb.toJson(URI.create("http://apache.org")));
    }

    @JsonbTest(deserializers = URICodec.class)
    public void readWithAdapterHierarchy(Jsonb jsonb) {
        assertEquals(URI.create("http://apache.org"), jsonb.fromJson("\"http://apache.org\"", URI.class));
    }

    @JsonbTest(serializers = LocalDateCodec.class)
    public void writeToJsonObjectWithSerializer(Jsonb jsonb) {
        assertEquals("{\"year\":2012,\"month\":2,\"day\":17}", jsonb.toJson(LocalDate.of(2012, 2, 17)));
    }

    @JsonbTest(deserializers = LocalDateCodec.class)
    public void readFromJsonObjectWithDeserializer(Jsonb jsonb) {
        assertEquals(LocalDate.of(2012, 2, 17), jsonb.fromJson("{\"year\":2012,\"month\":2,\"day\":17}", LocalDate.class));
    }
}
