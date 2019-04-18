package com.github.kalgon.jsonb.tck;

import javax.json.JsonValue;
import java.util.Objects;

public class EmbeddedJsonValue {

    private JsonValue embedded;

    public EmbeddedJsonValue() {
        this(null);
    }

    public EmbeddedJsonValue(JsonValue embedded) {
        this.embedded = embedded;
    }

    public JsonValue getEmbedded() {
        return embedded;
    }

    public void setEmbedded(JsonValue embedded) {
        this.embedded = embedded;
    }

    @Override
    public boolean equals(Object that) {
        return this == that || that instanceof EmbeddedJsonValue && Objects.equals(((EmbeddedJsonValue) that).embedded, this.embedded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(embedded);
    }
}
