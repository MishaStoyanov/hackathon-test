package com.ap0stole.hackathon.dao.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "links")
@Getter
@Setter
public class Link extends BaseEntity {

    @Column(name = "long_link")
    private String longLink;

    @Column(name = "short_link")
    private String shortLink;
}