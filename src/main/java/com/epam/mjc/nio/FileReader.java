package com.epam.mjc.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class FileReader {

    private String text = "";

    public Profile getDataFromFile(File file) {

        Path filePath = Path.of(file.getPath());


        try {
            byte[] bytes = Files.readAllBytes(filePath);
            text = new String(bytes);
            text = text.replace(System.lineSeparator(), ": ");

        } catch (IOException e) {
            e.printStackTrace();
        }


            String[] words = text.split(": ");
            Profile pf = new Profile();

            for (int i = 1; i < words.length; i++) {
                if (words[i - 1].equals("Name")) pf.setName(words[i]);
                if (words[i - 1].equals("Age")) pf.setAge(Integer.parseInt(words[i]));
                if (words[i - 1].equals("Email")) pf.setEmail(words[i]);
                if (words[i - 1].equals("Phone")) pf.setPhone((long) Integer.parseInt(words[i]));
            }

            return pf;
    }
}
