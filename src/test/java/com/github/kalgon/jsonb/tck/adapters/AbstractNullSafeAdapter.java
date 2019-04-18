package com.github.kalgon.jsonb.tck.adapters;

import javax.json.bind.adapter.JsonbAdapter;

public abstract class AbstractNullSafeAdapter<Original, Adapted> implements JsonbAdapter<Original, Adapted> {

    @Override
    public final Adapted adaptToJson(Original obj) throws Exception {
        return obj == null ? null : nullSafeAdaptToJson(obj);
    }

    @Override
    public final Original adaptFromJson(Adapted obj) throws Exception {
        return obj == null ? null : nullSafeAdaptFromJson(obj);
    }

    protected abstract Adapted nullSafeAdaptToJson(Original obj) throws Exception;

    protected abstract Original nullSafeAdaptFromJson(Adapted obj) throws Exception;
}
