package com.example.demo.TinyURL.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.TinyURL.Entity.TinyUrl;

@Repository
public interface TinyUrlRepository extends JpaRepository<TinyUrl, Long> {
    TinyUrl findByShortUrl(String short_url);
}