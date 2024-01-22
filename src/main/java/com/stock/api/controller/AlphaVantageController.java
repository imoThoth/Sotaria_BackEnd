package com.stock.api.controller;

import com.stock.api.service.RequestMapper;
import com.stock.api.data.helper.parser.TimeEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/market")
public class AlphaVantageController {

    @Autowired
    private RequestMapper requestMapper;

    @PostMapping("/stock")
    public ResponseEntity<Map<String, TimeEntry>> callAlphaVantage(@RequestBody String stockSymbol){
        System.out.println("Received String " + stockSymbol);
        Map<String, TimeEntry> responseEntity = requestMapper.callAlphaVantage(stockSymbol);
        return new ResponseEntity<>(responseEntity, HttpStatus.OK);

    }
}
