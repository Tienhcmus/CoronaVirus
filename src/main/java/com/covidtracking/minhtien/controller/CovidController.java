package com.covidtracking.minhtien.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;

import com.covidtracking.minhtien.model.CountryInfo;
import com.covidtracking.minhtien.service.CovidAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CovidController {

    @Autowired
    CovidAPI covidAPI;

    @RequestMapping({ "/", "/index" })
    public String CovidSummary(HttpServletRequest request,Model model) {

        int page = 0; //default page number is 0 (yes it is weird)
        int size = 10; //default page size is 10
        
        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }

        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
            size = Integer.parseInt(request.getParameter("size"));
        }
        List<CountryInfo> listCountry = new ArrayList<>();
        List<CountryInfo> Countries = new ArrayList<>();
        listCountry = covidAPI.getAllCountries();
        int totalPage = listCountry.size() % 10;
        if(totalPage * 10 < listCountry.size()){
            totalPage += 1;
        }
        if (totalPage > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("totalPage", totalPage);
        CountryInfo item = new CountryInfo();
        int start = page * 10;
        int length = start + size;
        for(int i = start; i < length; i++ ){
            if(i < listCountry.size()){
                item = listCountry.get(i);
                Countries.add(item);
            }
        }
        model.addAttribute("currentpage", page);
        model.addAttribute("global", covidAPI.getGlobalInfo());
        model.addAttribute("allCountries", Countries);
        model.addAttribute("date", covidAPI.getDate());
        return "index";
    }

}