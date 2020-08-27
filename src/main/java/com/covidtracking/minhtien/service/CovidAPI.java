package com.covidtracking.minhtien.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.covidtracking.minhtien.model.CountryInfo;
import com.covidtracking.minhtien.model.CovidInfo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class CovidAPI {

    private String COVID_SUM_API_URI = "https://api.covid19api.com/summary";

    private List<CountryInfo> allCountries = new ArrayList<>();

    private CovidInfo GlobalInfo = new CountryInfo();
    private String Date;

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void fetchdataAPI() throws IOException {
        // Get data from API
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(COVID_SUM_API_URI).method("GET", null).build();
        Response response = client.newCall(request).execute();

        // Convert data
        JSONObject dataAPI = new JSONObject(response.body().string());
        JSONObject globalObject = dataAPI.getJSONObject("Global");

        this.Date = dataAPI.getString("Date").substring(0, 10);

        CovidInfo info = new CovidInfo(globalObject);
        this.setGlobalInfo(info);

        JSONArray Countries = dataAPI.getJSONArray("Countries");
        List<CountryInfo> newCountry = new ArrayList<>();
        for (Object element : Countries) {
            JSONObject country = (JSONObject) element;
            CountryInfo item = new CountryInfo(country);
            newCountry.add(item);
        }
        this.setAllCountries(newCountry);
    }

    public List<CountryInfo> getAllCountries() {
        return allCountries;
    }

    public void setAllCountries(List<CountryInfo> allCountries) {
        this.allCountries = allCountries;
    }

    public CovidInfo getGlobalInfo() {
        return GlobalInfo;
    }

    public void setGlobalInfo(CovidInfo globalInfo) {
        this.GlobalInfo = globalInfo;
    }

    public String getDate(){
        return Date;
    }

}