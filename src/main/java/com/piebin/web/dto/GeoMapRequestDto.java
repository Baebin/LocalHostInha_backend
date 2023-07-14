package com.piebin.web.dto;

import lombok.Data;

@Data
public class GeoMapRequestDto {

    private String name;
    private double coord_x;
    private double coord_y;
}
