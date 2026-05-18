package com.zepto.sdui.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zepto.sdui.cache.RedisCacheService;
import com.zepto.sdui.model.HomeScreenDocument;
import com.zepto.sdui.repository.HomeScreenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomeScreenService {

    private final HomeScreenRepository repository;
    private final RedisCacheService cache;
    private final ObjectMapper objectMapper;
    private static final String CACHE_KEY = "screen:home";
    private static final long CACHE_TTL = 300;

    public HomeScreenDocument getHomeScreen() throws Exception {
        // 1. Check Redis first
        var cached = cache.get(CACHE_KEY);
        if (cached.isPresent()) {
            return objectMapper.readValue(cached.get(), HomeScreenDocument.class);
        }

        // 2. Fetch from MongoDB
        HomeScreenDocument doc = repository
                .findByScreen("home")
                .orElseThrow(() -> new RuntimeException("Home screen not found"));

        // 3. Save to Redis
        cache.set(CACHE_KEY, objectMapper.writeValueAsString(doc), CACHE_TTL);

        return doc;
    }
}