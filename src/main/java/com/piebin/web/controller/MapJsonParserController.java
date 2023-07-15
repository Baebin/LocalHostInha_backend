package com.piebin.web.controller;

import com.piebin.web.geomap.GeoMapJsonParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MapJsonParserController {
    @GetMapping("/api/parser")
    public String run() throws IOException {
        GeoMapJsonParser parser = new GeoMapJsonParser();

        String path = parser.run();
        return path;
    }
}
