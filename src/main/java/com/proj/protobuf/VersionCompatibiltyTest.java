package com.proj.protobuf;

import com.proj.models.Television;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VersionCompatibiltyTest {
    public static void main(String[] args) throws IOException {

        Path pathV1 = Paths.get("tv-v1");
        Path pathV2 = Paths.get("tv-v2");

/*
       Television television = Television.newBuilder()
                .setBrand("Sony")
                .setModel(2016)
                .setType(Type.OLED)
                .build();

        // Serializing
        Files.write(pathV2, television.toByteArray());*/



        //De-Serializing
        byte[] bytes = Files.readAllBytes(pathV1);
        System.out.println(
                Television.parseFrom(bytes).getPrice()
        );

    }
}
