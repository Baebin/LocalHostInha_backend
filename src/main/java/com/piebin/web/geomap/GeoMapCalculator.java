package com.piebin.web.geomap;

import com.piebin.web.dto.GeoMapRequestDto;

public class GeoMapCalculator {
    private static double EARTH_RADIUS = 40075 * 1000;

    public static double get(GeoMapRequestDto dtoA, GeoMapRequestDto dtoB) {
        double aX = dtoA.getCoord_x();
        double aY = dtoA.getCoord_y();

        double bX = dtoB.getCoord_x();
        double bY = dtoB.getCoord_y();

        double theta = aX - bX;
        double dist = Math.sin(deg2rad(aY)) * Math.sin(deg2rad(bY))
                + Math.cos(deg2rad(aY)) * Math.cos(deg2rad(bY)) * Math.cos(deg2rad(theta));

        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515 * 1609.344;

        return dist;
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180);
    }

    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }
}
