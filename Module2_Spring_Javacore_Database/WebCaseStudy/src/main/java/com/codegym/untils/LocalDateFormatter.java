package com.codegym.untils;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

@Service
public class LocalDateFormatter implements Formatter<LocalDate> {
    private DateTimeFormatter formatter;
    private String datePattern;

    public LocalDateFormatter() {
    }

    public LocalDateFormatter(DateTimeFormatter formatter, String datePattern) {
        this.formatter = formatter;
        this.datePattern = datePattern;
    }

    @Override
    public LocalDate parse(String s, Locale locale) throws ParseException {
        try {
            return LocalDate.parse(s,DateTimeFormatter.ofPattern(datePattern));
        }catch (DateTimeParseException d){
        throw new IllegalArgumentException("invalid date format.Please use this pattern\"" + datePattern +"\"");
        }
    }

    @Override
    public String print(LocalDate date, Locale locale) {
        return date.format(formatter);
    }
}
