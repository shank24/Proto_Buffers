package com.proj.protobuf;

import com.proj.models.Person;

public class PersonDemo {

    public static void main(String[] args) {

        Person sam1 = Person.newBuilder()
                .setName("sam")
                .setAge(10)
                .build();

        Person sam2 = Person.newBuilder()
                .setName("Sam")
                .setAge(10)
                .build();

        System.out.println(sam1.equals(sam2));


    }
}
