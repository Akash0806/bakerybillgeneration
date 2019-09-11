package main.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TextFileReader implements Reader {
    private static TextFileReader textFileReader;
    private static String inputFile = "";
    private TextFileReader(){

    }

    public static TextFileReader getInstance(String filePath){
        inputFile = filePath;
        if(textFileReader==null) {
            textFileReader = new TextFileReader();
        }
        return  textFileReader;
    }

    public List<String> readValue() {

        List<String> inputs = new ArrayList<>();
        if (inputFile != null && !inputFile.isEmpty()) {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(inputFile);
            try {
                if (inputStream != null && inputStream.available() > 0) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String line = null;
                    while ((line = bufferedReader.readLine()) != null) {
                                inputs.add(line);
                    }
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return inputs;
    }

}
