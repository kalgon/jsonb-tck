package com.github.kalgon.jsonb.tck.adapters;

import javax.json.bind.annotation.JsonbTypeAdapter;

public class StringHolder {

    @JsonbTypeAdapter(StringToCharAdapter.class)
    private String string;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
