package com.ap0stole.hackathon.dto;

import lombok.Data;

@Data
public class LinkMetrics {
    private String shortUrl;
    private String longUrl;
    private int clicks;
    private int uniqueClicks;
    private int totalQrScans;
    private Browser[] browsers;
    private Country[] countries;
    private Referrer[] referrers;
    private Platform[] platforms;
    private DailyClick[] dailyClicks;
    private LinkData data;

    @Data
    public static class Browser {
        private String browser;
        private int total;
        private int uniqueTotal;
        private int qrTotal;
    }

    @Data
    public static class Country {
        private String countryCode;
        private int total;
        private int uniqueTotal;
        private int qrTotal;
    }

    @Data
    public static class Referrer {
        private String referrer;
        private int total;
        private int uniqueTotal;
        private int qrTotal;
    }

    @Data
    public static class Platform {
        private String platform;
        private int total;
        private int uniqueTotal;
        private int qrTotal;
    }

    @Data
    public static class DailyClick {
        private String label;
        private int total;
        private int uniqueTotal;
        private int qrTotal;
    }

    @Data
    public static class LinkData {
        private String longUrl;
        private String shortUrl;
        private String createdAt;
        private String lastClicked;
        private String totalClicksLastThirtyDays;
    }
}
