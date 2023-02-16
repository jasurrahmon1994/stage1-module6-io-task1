package com.epam.mjc.io;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/resources/Profile.txt");
        FileReader fr = new FileReader();
        fr.getDataFromFile(file);
    }
}
