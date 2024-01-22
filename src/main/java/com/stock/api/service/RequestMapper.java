package com.stock.api.service;

import com.stock.api.data.AlphaVantageDataCaller;
import com.stock.api.data.helper.parser.TimeEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RequestMapper {

    private final AlphaVantageDataCaller alphaVantageDataCaller;

    @Autowired
    public RequestMapper(AlphaVantageDataCaller alphaVantageDataCaller){
        this.alphaVantageDataCaller = alphaVantageDataCaller;
    }

    public Map<String, TimeEntry> callAlphaVantage(String symbol) {

        Map<String, TimeEntry> alphaVantageResponse = alphaVantageDataCaller.callAlphaVantageApi(symbol);
        return alphaVantageResponse;
    }
}
