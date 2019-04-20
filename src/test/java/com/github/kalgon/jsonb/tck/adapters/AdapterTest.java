package com.github.kalgon.jsonb.tck.adapters;

import com.github.kalgon.jsonb.tck.JsonbTest;

import javax.json.bind.Jsonb;
import java.net.URI;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdapterTest {

    @JsonbTest(adapters = URIAdapter.class)
    public void writeWithAdapterHierarchy(Jsonb jsonb) {
        assertEquals("\"http://apache.org\"", jsonb.toJson(URI.create("http://apache.org")));
    }

    @JsonbTest(adapters = URIAdapter.class)
    public void readWithAdapterHierarchy(Jsonb jsonb) {
        assertEquals(URI.create("http://apache.org"), jsonb.fromJson("\"http://apache.org\"", URI.class));
    }

    @JsonbTest(adapters = LocalDateAdapter.class)
    public void writeToJsonObjectWithAdapter(Jsonb jsonb) {
        assertEquals("{\"year\":2012,\"month\":2,\"day\":17}", jsonb.toJson(LocalDate.of(2012, 2, 17)));
    }

    @JsonbTest(adapters = LocalDateAdapter.class)
    public void readFromJsonObjectWithAdapter(Jsonb jsonb) {
        assertEquals(LocalDate.of(2012, 2, 17), jsonb.fromJson("{\"year\":2012,\"month\":2,\"day\":17}", LocalDate.class));
    }

    @JsonbTest
    public void write(Jsonb jsonb) {
        LocalDatesHolder object = new LocalDatesHolder();
        object.setAdaptedLocalDate(LocalDate.of(2003, 12, 12));
        object.setStandardLocalDate(LocalDate.of(2007, 2, 28));
        assertEquals("{\"adaptedLocalDate\":{\"year\":2003,\"month\":12,\"day\":12},\"standardLocalDate\":\"2007-02-28\"}", jsonb.toJson(object));
    }

    @JsonbTest
    public void read(Jsonb jsonb) {
        LocalDatesHolder object = jsonb.fromJson("{\"adaptedLocalDate\":{\"year\":2003,\"month\":12,\"day\":12},\"standardLocalDate\":\"2007-02-28\"}", LocalDatesHolder.class);
        assertEquals(LocalDate.of(2003, 12, 12), object.getAdaptedLocalDate());
        assertEquals(LocalDate.of(2007, 2, 28), object.getStandardLocalDate());
    }
}
