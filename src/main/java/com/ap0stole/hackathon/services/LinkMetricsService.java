package com.ap0stole.hackathon.services;

import com.ap0stole.hackathon.dao.repositories.LinkRepository;
import com.ap0stole.hackathon.dto.LinkMetrics;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.ap0stole.hackathon.Constant.API_KEY;


@Service
@RequiredArgsConstructor
public class LinkMetricsService {
    private final LinkRepository linkRepository;

    public LinkMetrics getLinkMetrics(String shortUrl) {
        try {
            URL url = new URL("https://t.ly/api/v1/link/stats?short_url=" + URLEncoder.encode(shortUrl, StandardCharsets.UTF_8));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer YOUR_API_TOKEN");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject jsonResponse = new JSONObject(response.toString());

            Gson gson = new Gson();
            LinkMetrics metrics = gson.fromJson(jsonResponse.toString(), LinkMetrics.class);
            metrics.setShortUrl(shortUrl);
            metrics.setLongUrl(Objects.requireNonNull(linkRepository.findByShortLink(shortUrl).orElse(null)).getLongLink());
            return metrics;
        } catch (Exception e) {
            return null;
        }
    }

    public List<LinkMetrics> getAllLinksMetrics() {
        List<LinkMetrics> resultList = new ArrayList<>();

        var list = linkRepository.findAll();
        list.forEach(it -> {
            var metrics = getLinkMetrics(it.getShortLink());
            resultList.add(metrics);
        });
        return resultList;
    }
}
