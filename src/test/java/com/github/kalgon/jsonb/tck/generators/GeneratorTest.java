package com.github.kalgon.jsonb.tck.generators;

import org.junit.jupiter.api.Test;

import javax.json.Json;
import java.io.ByteArrayOutputStream;

public class GeneratorTest {

    @Test
    public void testWithExplicitWriteKey() {
        Json.createGenerator(new ByteArrayOutputStream()).writeStartObject()
                .writeKey("string").write("hello")
                .writeKey("int").write(42)
                .writeKey("object").writeStartObject().writeKey("foo").write("bar").writeEnd()
                .writeKey("array").writeStartArray().write(1).write(2).write(3).writeEnd()
                .writeEnd()
                .flush();
    }

    @Test
    public void testWithoutExplicitWriteKey() {
        Json.createGenerator(new ByteArrayOutputStream()).writeStartObject()
                .write("string", "hello")
                .write("int", 42)
                .writeStartObject("object").write("foo", "bar").writeEnd()
                .writeStartArray("array").write(1).write(2).write(3).writeEnd()
                .writeEnd()
                .flush();
    }
}
