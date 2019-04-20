package com.github.kalgon.jsonb.tck.adapters;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.bind.adapter.JsonbAdapter;
import java.time.LocalDate;

public class LocalDateAdapter implements JsonbAdapter<LocalDate, JsonObject> {

    @Override
    public JsonObject adaptToJson(LocalDate obj) {
        return Json.createObjectBuilder()
                .add("year", obj.getYear())
                .add("month", obj.getMonthValue())
                .add("day", obj.getDayOfMonth())
                .build();
    }

    @Override
    public LocalDate adaptFromJson(JsonObject obj) {
        return LocalDate.of(obj.getInt("year"), obj.getInt("month"), obj.getInt("day"));
    }
}
