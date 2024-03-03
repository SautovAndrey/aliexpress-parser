package com.joodjoy.aliexpressparser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ScrapingController {

    private final WebScrapingService scrapingService;

    @Autowired
    public ScrapingController(WebScrapingService scrapingService) {
        this.scrapingService = scrapingService;
    }

    @GetMapping("/scrape")
    public String scrape(@RequestParam String url) {
        return scrapingService.scrapeData(url);
    }
}