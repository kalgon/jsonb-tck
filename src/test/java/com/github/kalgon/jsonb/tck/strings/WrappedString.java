package com.github.kalgon.jsonb.tck.strings;

import java.util.Objects;

public final class WrappedString {

    private final String value;

    public WrappedString(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object that) {
        return this == that || that instanceof WrappedString && Objects.equals(((WrappedString) that).value, this.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
