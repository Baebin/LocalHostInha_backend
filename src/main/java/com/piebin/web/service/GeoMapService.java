package com.piebin.web.service;

import com.piebin.web.domain.GeoMap;
import com.piebin.web.domain.Post;
import com.piebin.web.dto.GeoMapRequestDto;
import com.piebin.web.repository.GeoMapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GeoMapService {
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
}
