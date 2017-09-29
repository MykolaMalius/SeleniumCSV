package com.epam.lab.excelutils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {
    private String csvFile = "./src/main/resources/user.csv";
    private String line = "";
    private String cvsSplitBy = ",";
    public static List<String > listOfEmails = new ArrayList<>();
    public static List<String>  listOfPasswords = new ArrayList<>();

    public void parse(){
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        while ((line = br.readLine()) != null) {
            String[] users = line.split(cvsSplitBy);
            listOfEmails.add(users[0]);
            listOfPasswords.add(users[1]);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
