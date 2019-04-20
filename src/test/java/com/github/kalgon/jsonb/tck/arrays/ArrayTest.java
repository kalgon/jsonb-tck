package com.github.kalgon.jsonb.tck.arrays;

import com.github.kalgon.jsonb.tck.JsonbTest;

import javax.json.bind.Jsonb;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayTest {

    @JsonbTest
    public void writeArray(Jsonb jsonb) {
        assertEquals("[\"hello\",\"world\"]", jsonb.toJson(new String[]{"hello", "world"}));
    }

    @JsonbTest
    public void readArray(Jsonb jsonb) {
        assertArrayEquals(new String[]{"hello", "world"}, jsonb.fromJson("[\"hello\",\"world\"]", String[].class));
    }

    @JsonbTest
    public void writeMatrix(Jsonb jsonb) {
        assertEquals("[[\"hello\",\"world\"],[\"foo\",\"bar\"]]", jsonb.toJson(new String[][]{{"hello", "world"}, {"foo", "bar"}}));
    }

    @JsonbTest
    public void readMatrix(Jsonb jsonb) {
        String[][] matrix = jsonb.fromJson("[[\"hello\",\"world\"],[\"foo\",\"bar\"]]", String[][].class);
        assertArrayEquals(new String[]{"hello", "world"}, matrix[0]);
        assertArrayEquals(new String[]{"foo", "bar"}, matrix[1]);
    }
}
