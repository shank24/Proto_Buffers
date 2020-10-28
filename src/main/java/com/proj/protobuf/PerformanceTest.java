package com.proj.protobuf;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.proj.json.JPerson;
import com.proj.models.Person;

public class PerformanceTest {

    public static void main(String[] args) throws JsonProcessingException {

        // Json

        JPerson person = new JPerson();
        person.setName("Sam");
        person.setAge(10);

        ObjectMapper mapper = new ObjectMapper();



        Runnable json = () -> {
            try {
                byte[] bytes = mapper.writeValueAsBytes(person);
                JPerson jPerson = mapper.readValue(bytes, JPerson.class);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        };


        // ProtoBuf


        Person sam = Person.newBuilder()
                .setAge(10)
                .setName("sam")
                .build();

        Runnable proto = () -> {
            try{
                byte[] bytes = sam.toByteArray();
                Person sam1 = Person.parseFrom(bytes);
            }
            catch (InvalidProtocolBufferException e){
                e.printStackTrace();
            }

        };

        for (int i = 0; i < 5; i++) {
            runPerformanceTest(json, "JSON");
            runPerformanceTest(proto, "PROTO");
        }

    }

    private static void runPerformanceTest(Runnable runnable, String method){

        long startTime = System.currentTimeMillis();

        for (int i = 0; i <5_000_000 ; i++) {
            runnable.run();
        }
        long endTime = System.currentTimeMillis();

        System.out.println(
                method  + " : " + (endTime - startTime) + " ms"
        );
    }
}
