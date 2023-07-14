package com.piebin.web.geomap;

import com.piebin.web.dto.GeoMapRequestDto;

public class GeoMapCalculator {
    private static double EARTH_RADIUS = 40075 * 1000;
    static double get(GeoMapRequestDto dtoA, GeoMapRequestDto dtoB) {
        double aX = dtoA.getCoord_x();
        double aY = dtoA.getCoord_y();

        double bX = dtoB.getCoord_x();
        double bY = dtoB.getCoord_y();

        double mX = (1 / EARTH_RADIUS * (Math.PI / 180)) / 1000;
        double mY = (1 / EARTH_RADIUS * (Math.PI / 180)) * Math.cos(Math.toRadians(aX))/ 1000;

        return 0;
    }
}
