package com.piebin.web.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class GeoMap {
    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String name;
    private Double coord_x;
    private Double coord_y;

    // NoArgsConstructor
    public GeoMap() {}

    public GeoMap(String name, double coord_x, double coord_y) {
        this.name = name;
        this.coord_x = coord_x;
        this.coord_y = coord_y;
    }
}
