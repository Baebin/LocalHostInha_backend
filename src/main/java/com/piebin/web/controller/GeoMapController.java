package com.piebin.web.controller;

import com.piebin.web.dto.GeoMapRequestDto;
import com.piebin.web.repository.GeoMapRepository;
import com.piebin.web.service.GeoMapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class GeoMapController {
    private final GeoMapService service;
    private final GeoMapRepository repository;

    @PostMapping("/api/geomap/save")
    public String save(
            @RequestBody GeoMapRequestDto dto) {
        service.save(dto);

        String log = "name: " + dto.getName() + "\n"
                + "coord_x: " + dto.getCoord_x() + "\n"
                + "coord_y: " + dto.getCoord_y();
        return log;
    }

    //
    // Test API
    //

    @GetMapping("/api/test/geomap/save")
    public String save(
            @RequestParam("name") String name,
            @RequestParam("coord_x") double coord_x,
            @RequestParam("coord_y") double coord_y) {
        GeoMapRequestDto dto = new GeoMapRequestDto();
        dto.setName(name);
        dto.setCoord_x(coord_x);
        dto.setCoord_y(coord_y);
        service.save(dto);

        String log = "name: " + dto.getName() + "\n"
                + "coord_x: " + dto.getCoord_x() + "\n"
                + "coord_y: " + dto.getCoord_y();
        return log;
    }
}
