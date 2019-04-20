package com.github.kalgon.jsonb.tck.adapters;

import javax.json.bind.adapter.JsonbAdapter;

public class StringToCharAdapter implements JsonbAdapter<String, String[]> {

    @Override
    public String[] adaptToJson(String obj) {
        return obj.chars().mapToObj(c -> "" + (char) c).toArray(String[]::new);
    }

    @Override
    public String adaptFromJson(String[] obj) {
        char[] result = new char[obj.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = (char) obj[i].codePointAt(0);
        }
        return new String(result);
    }
}
