package com.kashuba.onlinestore.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateConverter {

    private DateConverter() {
    }

    public static Long convertToLong(LocalDate date) {
        ZonedDateTime zonedDateTime = date.atStartOfDay().atZone(ZoneId.systemDefault());

        return zonedDateTime.toInstant().toEpochMilli();
    }

    public static LocalDate convertToDate(Long milliseconds) {
        return Instant.ofEpochMilli(milliseconds).atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
