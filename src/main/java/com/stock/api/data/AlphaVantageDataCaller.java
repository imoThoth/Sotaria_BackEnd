package com.stock.api.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stock.api.data.helper.parser.ResponseParser;
import com.stock.api.data.helper.parser.TimeSeries;
import com.stock.api.data.helper.parser.TimeEntry;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


@Service
@Component
public class AlphaVantageDataCaller {

    @Value("${alphaVantageKey}")
    private String alphaVantageKey;
    private static final Logger logger = LoggerFactory.getLogger(AlphaVantageDataCaller.class);

    /**
     * Calls alpha vantage and returns parsed response
     * @param symbol
     * @return
     */
    public Map<String , TimeEntry> callAlphaVantageApi(String symbol){

        StringBuilder alphaVantageResponse = new StringBuilder();
        Map<String, TimeEntry> responseMap = new TreeMap<>();
        String urlAndSymbol = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=" + symbol + "&interval=5min&apikey=" + alphaVantageKey;

        try{

            //Creating connection to alpha vantage server
            URL url = new URL(urlAndSymbol);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();

            logger.info("Connection Established");

            if(responseCode != 200){
                logger.info("Error with response received from alphaVantage server. \n Response Message:  " + connection.getResponseMessage());
                throw new RuntimeException("HttpResponse Code " + responseCode);
            }else{

                //Receiving data from the alpha vantageServer
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()){
                    alphaVantageResponse.append(scanner.nextLine());
                }
                scanner.close();

                //call method to parse response
               responseMap = parseAlphaVantageResponse(alphaVantageResponse.toString());

            }

        }catch (IOException e){
           logger.error("Could not return response from alpha vantage. Cause: " + e.getCause());
           e.printStackTrace();
        }

        return responseMap;
    }


    /**
     * parse the string data from alpha vantage response
     * and return a map
     * @param response
     * @return
     */
    public Map<String, TimeEntry> parseAlphaVantageResponse(String response){

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, TimeEntry> entries = new TreeMap<>();

        try{

            JSONParser parser = new JSONParser();
            Object parsedObj = parser.parse(response);
            JSONArray jsonArray = new JSONArray();

            StringBuilder responseAsJsonArray = new StringBuilder();
            jsonArray.add(parsedObj);

            responseAsJsonArray.append(jsonArray);

            //Parse data
            ResponseParser[] parsedResponse = objectMapper.readValue(responseAsJsonArray.toString(), ResponseParser[].class);

            //Access parsed data
            ResponseParser arrayOfParsedData = parsedResponse[0];
            TimeSeries timeSeries = arrayOfParsedData.getTimeSeries();
            entries = timeSeries.getEntries();

        }catch (IOException | ParseException e){
            logger.info("Could not parse the data. \n Cause: " + e.getCause());
            e.printStackTrace();
        }

        return entries;
    }

}
