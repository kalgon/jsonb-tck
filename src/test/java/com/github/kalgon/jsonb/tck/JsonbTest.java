package com.github.kalgon.jsonb.tck;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.bind.serializer.JsonbSerializer;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@ExtendWith(JsonbParameterResolver.class)
@Test
public @interface JsonbTest {

    boolean strict() default false;

    boolean nulls() default false;

    boolean formatting() default false;

    Class<? extends JsonbAdapter>[] adapters() default {};

    Class<? extends JsonbSerializer>[] serializers() default {};

    Class<? extends JsonbDeserializer>[] deserializers() default {};
}
