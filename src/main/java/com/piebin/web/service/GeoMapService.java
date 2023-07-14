package com.piebin.web.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.piebin.web.domain.GeoMap;
import com.piebin.web.dto.GeoMapGetRequestDto;
import com.piebin.web.dto.GeoMapRequestDto;
import com.piebin.web.geomap.GeoMapCalculator;
import com.piebin.web.repository.GeoMapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GeoMapService {
    static final double MAX_DISTANCE = 3000;

    private final GeoMapRepository repository;

    @Transactional
    public GeoMap save(GeoMapRequestDto dto) {
        GeoMap geoMap = new GeoMap(
                dto.getName(),
                dto.getCoord_x(),
                dto.getCoord_y()
        );
        return repository.save(geoMap);
    }

    public List<GeoMap> get(
            @RequestBody GeoMapGetRequestDto dto) {
        List<GeoMap> list = repository.findAll();
        List<GeoMap> maps = new ArrayList<>();
        for (GeoMap geoMap : list) {
            GeoMapGetRequestDto geoMapGetRequestDto = new GeoMapGetRequestDto();
            geoMapGetRequestDto.setCoord_x(geoMap.getCoord_x());
            geoMapGetRequestDto.setCoord_y(geoMap.getCoord_y());

            double distance = GeoMapCalculator.get(dto, geoMapGetRequestDto);
            if (distance <= MAX_DISTANCE)
                maps.add(geoMap);
        }
        return maps;
    }

    public String getJson(List<GeoMap> maps) {
        JsonObject jo = new JsonObject();
        JsonArray ja = new JsonArray();
        for (GeoMap map : maps) {
            JsonObject jo_map = new JsonObject();
            jo_map.addProperty("name", map.getName());
            jo_map.addProperty("coord_x", map.getCoord_x());
            jo_map.addProperty("coord_y", map.getCoord_y());
            ja.add(jo_map);
        }
        jo.add("data", ja);
        return jo.toString();
    }
}
