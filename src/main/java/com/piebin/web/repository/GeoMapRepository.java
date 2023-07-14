package com.piebin.web.repository;

import com.piebin.web.domain.GeoMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoMapRepository extends JpaRepository<GeoMap, Long> {
}
