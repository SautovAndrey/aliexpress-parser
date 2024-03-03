package com.joodjoy.aliexpressparser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class WebScrapingService {
    public String scrapeData(String url) {
        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3")
                    .get();

            // Название товара
            Element titleElement = doc.select("h1.snow-ali-kit_Typography__base__1shggo.snow-ali-kit_Typography-Primary__base__1xop0e.snow-ali-kit_Typography__strong__1shggo.snow-ali-kit_Typography__sizeHeadingL__1shggo.HazeProductDescription_HazeProductDescription__name__8s9ws.HazeProductDescription_HazeProductDescription__smallText__8s9ws").first();
            String title = titleElement != null ? titleElement.text() : "Название не найдено";

            // Дополните селекторы для цены и описания, когда их найдёте
            String price = "Цена не найдена"; // Нужен селектор
            String description = "Описание не найдено"; // Нужен селектор

            return String.format("Название: %s\nЦена: %s\nОписание: %s", title, price, description);
        } catch (IOException e) {
            return "Ошибка при соединении с " + url + ": " + e.getMessage();
        }
    }



}






