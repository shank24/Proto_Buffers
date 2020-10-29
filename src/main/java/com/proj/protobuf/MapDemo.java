package com.proj.protobuf;

import com.proj.models.BodyStyle;
import com.proj.models.Car;
import com.proj.models.Dealer;

public class MapDemo {
    public static void main(String[] args) {

        Car civic  = Car.newBuilder()
                .setMake("Honda")
                .setModel("Civic")
                .setBodyStyle(BodyStyle.COUPE)
                .setYear(2005)
                .build();

        Car accord  = Car.newBuilder()
                .setMake("Honda")
                .setModel("Accord")
                .setBodyStyle(BodyStyle.SEDAN)
                .setYear(2020)
                .build();

        Dealer dealer = Dealer.newBuilder()
                .putModel(2005, civic)
                .putModel(2020, accord)
                .build();
/*
        System.out.println(
                dealer.getModelOrDefault(2019,accord) + "" +
                dealer.getModelOrThrow(2005) + "" +
                dealer.getModelMap().isEmpty()
        );*/

        System.out.println(
                dealer.getModelOrThrow(2005).getBodyStyle()
        );

    }

}
