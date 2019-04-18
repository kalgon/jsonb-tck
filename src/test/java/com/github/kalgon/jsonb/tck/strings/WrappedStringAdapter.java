package com.github.kalgon.jsonb.tck.strings;

import javax.json.bind.adapter.JsonbAdapter;

public class WrappedStringAdapter implements JsonbAdapter<WrappedString, String> {

    @Override
    public String adaptToJson(WrappedString obj) {
        return obj.getValue();
    }

    @Override
    public WrappedString adaptFromJson(String obj) {
        return new WrappedString(obj);
    }
}
