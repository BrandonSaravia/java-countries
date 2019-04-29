package com.countries.countrie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebCountrieApplication {

    public static CountryList ourCountryList;

    public static void main(String[] args) {
        ourCountryList = new CountryList();
        SpringApplication.run(WebCountrieApplication.class, args);
    }

}
