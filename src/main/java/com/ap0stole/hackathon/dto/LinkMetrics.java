package com.ap0stole.hackathon.dto;

import lombok.Data;

@Data
public class LinkMetrics {
    private String shortUrl;
    private String longUrl;
    private int clicks;
    private int uniqueClicks;
}
