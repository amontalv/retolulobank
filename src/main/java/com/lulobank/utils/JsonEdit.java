package com.lulobank.utils;

import java.util.List;

public class JsonEdit {

    public static String createJson(List<String> data){
        return "{\n" +
                "\"id\":" + data.get(0) + ",\n" +
                "\"username\":\"" + data.get(1) +"\",\n" +
                "\"firstName\":\"" + data.get(2) +"\",\n" +
                "\"lastName\":\"" + data.get(3) +"\",\n" +
                "\"email\":\"" + data.get(4)+"\",\n" +
                "\"password\":\"" +data.get(5)+"\",\n" +
                "\"phone\":\"" +data.get(6)+"\",\n" +
                "\"userStatus\":" +data.get(7)+ "\n" +
                "}";
    }

    public static String updateJson(List<String> values){
        return "{\n" +
                "\"id\":25,\n" +
                "\"username\":\"" +values.get(0) +"\",\n" +
                "\"firstName\":\"albeiro\",\n" +
                "\"lastName\":\"Aguirre\",\n" +
                "\"email\":\"pruba@hola.com\",\n" +
                "\"password\":\"hola mundo\",\n" +
                "\"phone\":\"" +values.get(1)+"\",\n" +
                "\"userStatus\":2\n" +
                "}";
    }
}
