package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String res = "";
        String[][] newArr;
        Profile profile = new Profile();
        try (FileInputStream fs = new FileInputStream(file)) {
            int c;
            while ((c = fs.read()) != -1) {
                res += (char) c;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] arr = res.split("\\r?\\n|\\r");
        for (int i = 0; i < arr.length; i++) {
            String[] str = arr[i].split(": ");
            switch (str[0]) {
                case "Name": profile.setName(str[1]); break;
                case "Age": profile.setAge(Integer.parseInt(str[1])); break;
                case "Email": profile.setEmail(str[1]); break;
                case "Phone": profile.setPhone(Long.parseLong(str[1])); break;
                default:
                    break;
            }
        }

        return profile;
    }
}
