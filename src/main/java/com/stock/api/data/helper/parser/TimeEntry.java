package com.stock.api.data.helper.parser;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class TimeEntry {


    @JsonProperty("3. low")
    private String low;

    @JsonProperty("5. volume")
    private String volume;

    @JsonProperty("1. open")
    private String open;

    @JsonProperty("2. high")
    private String high;

    @JsonProperty("4. close")
    private String close;
//    private Date timeStamp;

    public String getLow() {
        return this.low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getVolume() {
        return this.volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getOpen() {
        return this.open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return this.high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getClose() {
        return this.close;
    }

    public void setClose(String close) {
        this.close = close;
    }

//    public Date getTimeStamp() {
//        return this.timeStamp;
//    }

//    public void setTimeStamp(Date timeStamp) {
//        this.timeStamp = timeStamp;
//    }
}
