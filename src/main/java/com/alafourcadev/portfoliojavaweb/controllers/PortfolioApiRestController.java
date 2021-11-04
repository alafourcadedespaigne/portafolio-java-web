package com.alafourcadev.portfoliojavaweb.controllers;

import com.alafourcadev.portfoliojavaweb.entities.Portfolio;
import com.alafourcadev.portfoliojavaweb.services.PortFolioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portfolio/api")
public class PortfolioApiRestController {

    private final PortFolioService portFolioService;

    public PortfolioApiRestController(PortFolioService portFolioService) {
        this.portFolioService = portFolioService;
    }

    @GetMapping("/profile/{twitter_user}")
    public ResponseEntity<?> getInformation(@PathVariable("twitter_user") String user) {
        Portfolio portfolio = portFolioService.getPortfolioByTwitterUser(user);
        return ResponseEntity.status(HttpStatus.OK)
                .body(portfolio);

    }

    @PutMapping("/profile/{twitter_user}")
    public Portfolio updatePortFolio(@PathVariable(value = "twitter_user") String twitter_user, @RequestBody Portfolio portfolioDetails) {

        return portFolioService.updatePortFolio(twitter_user, portfolioDetails);
    }


}
