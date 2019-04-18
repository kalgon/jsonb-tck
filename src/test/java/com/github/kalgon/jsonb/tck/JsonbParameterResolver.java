package com.github.kalgon.jsonb.tck;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.platform.commons.util.ReflectionUtils;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.bind.serializer.JsonbSerializer;
import java.util.function.IntFunction;
import java.util.stream.Stream;

public final class JsonbParameterResolver implements ParameterResolver {

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return parameterContext.getParameter().getType().equals(Jsonb.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        JsonbTest test = extensionContext.getRequiredTestMethod().getAnnotation(JsonbTest.class);
        if (test == null) {
            return JsonbBuilder.create();
        }
        JsonbConfig config = new JsonbConfig()
                .withNullValues(test.nulls())
                .withStrictIJSON(test.strict())
                .withFormatting(test.formatting())
                .withAdapters(newInstances(JsonbAdapter[]::new, test.adapters()))
                .withSerializers(newInstances(JsonbSerializer[]::new, test.serializers()))
                .withDeserializers(newInstances(JsonbDeserializer[]::new, test.deserializers()));
        return JsonbBuilder.newBuilder().withConfig(config).build();
    }

    private <T> T[] newInstances(IntFunction<T[]> generator, Class<? extends T>[] classes) {
        return Stream.of(classes).map(ReflectionUtils::newInstance).toArray(generator);
    }
}
