package com.ap0stole.hackathon.dao.repositories;

import com.ap0stole.hackathon.dao.models.Link;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LinkRepository extends BaseJpaRepository<Link> {

    Optional<Link> findByShortLink(String shortLink);
    Optional<Link> findByLongLink(String longLink);
}
