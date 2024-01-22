package com.stock.api.data.helper.parser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class to return parsed json response
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseParser {
    @JsonProperty("Time Series (5min)")
    private TimeSeries timeSeries;

    @JsonProperty("Meta Data")
    private MetaData metaData;

    public TimeSeries getTimeSeries() {
        return this.timeSeries;
    }

    public void setTimeSeries(TimeSeries timeSeries) {
        this.timeSeries = timeSeries;
    }

    public MetaData getMetaData() {
        return this.metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }
}
