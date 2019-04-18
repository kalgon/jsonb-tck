package com.github.kalgon.jsonb.tck.adapters;

import com.github.kalgon.jsonb.tck.JsonbTest;

import javax.json.bind.Jsonb;
import java.net.URI;

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
}
