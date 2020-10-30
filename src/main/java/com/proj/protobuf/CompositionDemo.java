package com.proj.protobuf;

import com.google.protobuf.Int32Value;
import com.proj.models.Address;
import com.proj.models.Car;
import com.proj.models.Person;

import java.util.ArrayList;
import java.util.List;

public class CompositionDemo {

    public static void main(String[] args) {

        Address address = Address.newBuilder()
                .setPostBox(123)
                .setStreet("Main Street")
                .setCity("Atlanta")
                .build();

        Car civic  = Car.newBuilder()
                .setMake("Honda")
                .setModel("Civic")
                .setYear(2005)
                .build();

        Car accord  = Car.newBuilder()
                .setMake("Honda")
                .setModel("Accord")
                .setYear(2020)
                .build();

        List<Car> cars = new ArrayList<Car>();
        cars.add(accord);
        cars.add(civic);


        Person sam = Person.newBuilder()
                .setName("Sam")
                .setAge(Int32Value.newBuilder().setValue(25).build())
                .addAllCar(cars)
                .setAddress(address)
                .build();

        System.out.println(sam);
        System.out.println(sam.hasAge());
    }
}
