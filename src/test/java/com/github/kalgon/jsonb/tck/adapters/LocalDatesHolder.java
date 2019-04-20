package com.github.kalgon.jsonb.tck.adapters;

import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.annotation.JsonbTypeAdapter;
import java.time.LocalDate;

@JsonbPropertyOrder({"adaptedLocalDate", "standardLocalDate"})
public class LocalDatesHolder {

    @JsonbTypeAdapter(LocalDateAdapter.class)
    private LocalDate adaptedLocalDate;

    private LocalDate standardLocalDate;

    public LocalDate getAdaptedLocalDate() {
        return adaptedLocalDate;
    }

    public void setAdaptedLocalDate(LocalDate adaptedLocalDate) {
        this.adaptedLocalDate = adaptedLocalDate;
    }

    public LocalDate getStandardLocalDate() {
        return standardLocalDate;
    }

    public void setStandardLocalDate(LocalDate standardLocalDate) {
        this.standardLocalDate = standardLocalDate;
    }
}
