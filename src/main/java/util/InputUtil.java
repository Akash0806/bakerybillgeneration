package main.java.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputUtil {

    public List<String> getInputStrintsFromCSV(String inputFile) {
        List<String> inputs = new ArrayList<>();
        if (inputFile != null && !inputFile.isEmpty()) {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(inputFile);
            try {
                if (inputStream != null && inputStream.available() > 0) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String line = null;

                    while ((line = bufferedReader.readLine()) != null) {
                        String[] values = line.split(",");
                        for (String str : values) {
                            if (str != null && !str.isEmpty()) {
                                inputs.add(str.toString().trim());
                            }
                        }
                        bufferedReader.close();
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return inputs;
    }

}
