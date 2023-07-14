package com.piebin.web.controller;

import com.piebin.web.domain.GeoMap;
import com.piebin.web.dto.GeoMapGetRequestDto;
import com.piebin.web.dto.GeoMapRequestDto;
import com.piebin.web.geomap.GeoMapCalculator;
import com.piebin.web.repository.GeoMapRepository;
import com.piebin.web.service.GeoMapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/api/geomap/get")
    public String get(
            @RequestBody GeoMapGetRequestDto dto) {
        List<GeoMap> list = service.get(dto);
        return service.getJson(list);
    }

    @GetMapping("/api/geomap/distance")
    public double getDistance(
            @RequestParam("x1") double x1,
            @RequestParam("y1") double y1,
            @RequestParam("x2") double x2,
            @RequestParam("y2") double y2) {
        GeoMapGetRequestDto dtoA = new GeoMapGetRequestDto();
        GeoMapGetRequestDto dtoB = new GeoMapGetRequestDto();
        dtoA.setCoord_x(x1);
        dtoA.setCoord_y(y1);
        dtoB.setCoord_x(x2);
        dtoB.setCoord_y(y2);
        return GeoMapCalculator.get(dtoA, dtoB);
    }

    //
    // Test API
    //

    @GetMapping("/api/test/geomap/save")
    public String testSave(
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

    @GetMapping("/api/geomap/get")
    public String testGet(
            @RequestParam("coord_x") double coord_x,
            @RequestParam("coord_y") double coord_y) {
        GeoMapGetRequestDto dto = new GeoMapGetRequestDto();
        dto.setCoord_x(coord_x);
        dto.setCoord_y(coord_y);

        List<GeoMap> list = service.get(dto);
        return service.getJson(list);
    }
}
