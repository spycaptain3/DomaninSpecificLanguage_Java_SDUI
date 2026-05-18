package com.zepto.sdui.controller;

import com.zepto.sdui.model.HomeScreenDocument;
import com.zepto.sdui.service.HomeScreenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/screen")
@RequiredArgsConstructor
public class HomeScreenController {

    private final HomeScreenService service;

    @GetMapping("/home")
    public ResponseEntity<HomeScreenDocument> getHomeScreen() {
        try {
            return ResponseEntity.ok(service.getHomeScreen());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}