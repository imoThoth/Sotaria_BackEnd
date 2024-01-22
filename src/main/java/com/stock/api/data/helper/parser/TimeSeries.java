package com.stock.api.data.helper.parser;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TimeSeries {


    @JsonProperty("Time Series (5min)")
    private Map<String, TimeEntry> entries;

    // Default constructor (no-argument constructor) required by Jackson
    public TimeSeries() {
    }

    // Constructor with entries parameter
    @JsonCreator
    public TimeSeries(@JsonProperty("Time Series (5min)")Map<String, TimeEntry> entries) {
        this.entries = entries;
    }

    /**
     * method called for any unrecognized JSON property
     * adds data using unrecognized JSON as the key
     * in this case the date
     * @param key
     * @param entry
     */
    @JsonAnySetter
    public void addEntry(String key, TimeEntry entry) {
        if (entries == null) {
            entries = new HashMap<>();
        }

        // Use the key as a date if it's not recognized
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = dateFormat.parse(key);
            DateTime dateTime =new DateTime(date, DateTimeZone.UTC);
            entries.put(String.valueOf(dateTime), entry);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // Getter and setter methods
    public Map<String, TimeEntry> getEntries() {
        return entries;
    }

    public void setEntries(Map<String, TimeEntry> entries) {
        this.entries = entries;
    }
}
