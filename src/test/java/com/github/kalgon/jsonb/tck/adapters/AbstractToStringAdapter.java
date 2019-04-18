package com.github.kalgon.jsonb.tck.adapters;

public abstract class AbstractToStringAdapter<Original> extends AbstractNullSafeAdapter<Original, String> {

    @Override
    protected String nullSafeAdaptToJson(Original obj) {
        return obj.toString();
    }
}
