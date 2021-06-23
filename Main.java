package com.company;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Users users = new Users("Name Surname", "Date","Work Hour");
        try(BufferedReader bt = new BufferedReader(new FileReader("acme_worksheet.csv"))) {
            String str;
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("acme.csv"))){
                while ((str = bt.readLine())!=null){
                    if(str.contains("Alva") || str.contains("Antonia")){

                        if(str.contains("Antonia")){
                            users.setName_surname(str.substring(0,16));
                        }
                        else
                            users.setName_surname(str.substring(0,14));
                        if(str.contains("Alva")){
                            users.setDate(str.substring(15,26));
                        }
                        else
                            users.setDate(str.substring(17,28));
                        if(str.contains("Alva")){
                            users.setWork_hour(str.substring(27));
                        }
                        else
                            users.setWork_hour(str.substring(29));
                        Stream<Users> usersStream = Stream.of(new Users(users.getName_surname(), users.getDate(), users.getWork_hour()));
                        Map<String, List<Users>> user = usersStream.collect(Collectors.groupingBy(Users :: getName_surname));
                        for(Map.Entry<String, List<Users>> item : user.entrySet()){
                            System.out.println("Name: " + item.getKey());
                            bw.write("Name: " + item.getKey() + "\n");
                            for (Users u : item.getValue()){
                                System.out.printf("Date: %s,Hours Work: %s %n", u.getDate(), u.getWork_hour());
                                bw.write(" Date: " + u.getDate() + " Hours Work:" + u.getWork_hour() + "\n");
                            }
                        }
                        System.out.println();
                    }
                }
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
