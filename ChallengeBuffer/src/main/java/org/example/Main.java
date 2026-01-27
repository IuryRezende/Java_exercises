package org.example;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        String path = "C:\\Users\\IURY REI DO CAPA\\Documents";

        try (BufferedReader br = new BufferedReader(new FileReader(path + "\\new-file.csv")); BufferedWriter bw = new BufferedWriter(new FileWriter(path + "\\out\\summary.csv"))){

            String line = br.readLine();

            System.out.println(line);


            while (line != null){
                String[] lines = line.split(",");

                bw.write(lines[0] + "," + Double.parseDouble(lines[1]) * Double.parseDouble(lines[2]));
                bw.newLine();

                line = br.readLine();

            }

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

    }

    private static void extracted(String[] lines) {
        for (String l : lines){
            System.out.println(l);
        }
    }
}