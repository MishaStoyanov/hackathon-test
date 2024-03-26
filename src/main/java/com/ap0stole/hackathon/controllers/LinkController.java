package com.ap0stole.hackathon.controllers;

import com.ap0stole.hackathon.dao.models.Link;
import com.ap0stole.hackathon.dao.repositories.LinkRepository;
import com.ap0stole.hackathon.dto.LinkMetrics;
import com.ap0stole.hackathon.dto.UrlDto;
import com.ap0stole.hackathon.services.LinkMetricsService;
import com.ap0stole.hackathon.services.ShortLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/links")
public class LinkController {
    public final LinkRepository linkRepository;
    public final ShortLinkService shortLinkService;
    private final LinkMetricsService linkMetricsService;

    @PutMapping
    public void createLinkFromLongLink(@RequestBody UrlDto url) { //create short link from a long link
        shortLinkService.addShortUrl(url.getUrl());
    }

    @PostMapping
    public List<Link> list() { //list all links, long and short values
        return linkRepository.findAll();
    }

    @PostMapping("/stats")
    public LinkMetrics getStats(@RequestBody UrlDto urlDto) { //get clicks stat per 1 link (works only with correct API key)
        return linkMetricsService.getLinkMetrics(urlDto.getUrl());
    }

    @PostMapping("/stats-all")
    public List<LinkMetrics> getStats() { //get clicks stat for all short links in db
        return linkMetricsService.getAllLinksMetrics();
    }
}
