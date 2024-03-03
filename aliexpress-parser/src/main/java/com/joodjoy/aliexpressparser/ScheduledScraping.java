package com.joodjoy.aliexpressparser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ScheduledScraping {

    private final WebScrapingService scrapingService;

    @Autowired
    public ScheduledScraping(WebScrapingService scrapingService) {
        this.scrapingService = scrapingService;
    }

    @Scheduled(fixedRate = 600000) // Запуск каждые 10 минут
    public void scheduledScrape() {
        String[] urls = {/* Список URL для скрапинга */};
        for (String url : urls) {
            String result = scrapingService.scrapeData(url);
            System.out.println("Результат скрапинга для " + url + ": " + result);
        }
    }
}