package com.ap0stole.hackathon.services;

import com.ap0stole.hackathon.dao.models.Link;
import com.ap0stole.hackathon.dao.repositories.LinkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.ap0stole.hackathon.Constant.API_KEY;

@Service
@Slf4j
@RequiredArgsConstructor
public class ShortLinkService {

    private final LinkRepository linkRepository;

    public void addShortUrl(String longUrl) {
        try {
            JSONObject postData = new JSONObject();
            postData.put("long_url", longUrl);
            postData.put("domain", "https://t.ly/");
            postData.put("expire_at_datetime", "2035-01-17 15:00:00");
            postData.put("description", "Social Media Link");
            postData.put("public_stats", true);

            URL url = new URL("https://t.ly/api/v1/link/shorten");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(postData.toString());
            writer.flush();

            Link link = getLink(longUrl, connection);
            linkRepository.save(link);


            connection.disconnect();
        } catch (Exception ignored) {
            //ignore
        }
    }

    private static Link getLink(String longUrl, HttpURLConnection connection) throws IOException, JSONException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        JSONObject jsonResponse = new JSONObject(response.toString());
        String shortUrl = jsonResponse.getString("short_url");

        Link link = new Link();
        link.setShortLink(shortUrl);
        link.setLongLink(longUrl);
        return link;
    }
}
