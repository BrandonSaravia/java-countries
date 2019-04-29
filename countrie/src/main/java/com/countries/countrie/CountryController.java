package com.countries.countrie;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class CountryController {

    @RequestMapping(value= "/all")
    public ResponseEntity<?> getAllCountries() {
        WebCountrieApplication.ourCountryList.countryList.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        return new ResponseEntity<>(WebCountrieApplication.ourCountryList.countryList, HttpStatus.OK);
    }

    @GetMapping(value = "/start/{letter}")
    public ResponseEntity<?> getCountryLetter(@PathVariable char letter) {
        ArrayList<Country> rtnCountry = WebCountrieApplication.ourCountryList.findCountries(e -> e.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        return new ResponseEntity<>(rtnCountry,HttpStatus.OK);
    }

    @GetMapping(value = "/size/{number}")
    public ResponseEntity<?> getSizeNumber(@PathVariable int number) {
        ArrayList<Country> rtnSizeNumber = WebCountrieApplication.ourCountryList.findCountries(e -> e.getLandMassSize() == number);
        return new ResponseEntity<>(rtnSizeNumber,HttpStatus.OK);
    }


}
