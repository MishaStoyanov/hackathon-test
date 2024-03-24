package com.ap0stole.hackathon.controllers;

import com.ap0stole.hackathon.dao.models.Link;
import com.ap0stole.hackathon.dao.repositories.LinkRepository;
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


    @PutMapping
    public void createLinkFromLongLink(String url) {
        shortLinkService.addShortenUrl(url);
    }

    @PostMapping("/counter")
    public void addStat(String url) {
        linkRepository.findByShortLink(url).ifPresent(
                link -> link.setStats(link.getStats() + 1));
    }

    @GetMapping("/stat")
    public List<Link> list() {
        return linkRepository.findAll();
    }
}
