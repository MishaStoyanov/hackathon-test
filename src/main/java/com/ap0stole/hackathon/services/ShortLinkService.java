package com.ap0stole.hackathon.services;

import com.ap0stole.hackathon.dao.models.Link;
import com.ap0stole.hackathon.dao.repositories.LinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@RequiredArgsConstructor
public class ShortLinkService {

    public final LinkRepository linkRepository;

    public String addShortenUrl(String longUrl) {
        Link link = new Link();
        if (linkRepository.findByLongLink(longUrl).orElse(null) == null) {
            try {
                URL url = new URL("https://is.gd/create.php?format=simple&url=" + longUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String response = reader.readLine();
                reader.close();
                connection.disconnect();

                link.setShortLink(response);
                link.setLongLink(longUrl);
                link.setStats(0);
                linkRepository.save(link);

                return response;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}

