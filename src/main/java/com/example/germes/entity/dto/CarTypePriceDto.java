package com.example.germes.entity.dto;

import com.example.germes.entity.CarTypePrice;

import java.util.ArrayList;
import java.util.List;

public class CarTypePriceDto {

    private List<CarTypePrice> carTypePrices;

    public CarTypePriceDto() {
        carTypePrices = new ArrayList<>();
    }

    public CarTypePriceDto(List<CarTypePrice> carTypePrices) {
        this.carTypePrices = carTypePrices;
    }

    public void add(CarTypePrice carTypePrice) {
        carTypePrices.add(carTypePrice);
    }

    public List<CarTypePrice> getCarTypePrices() {
        return carTypePrices;
    }

}
