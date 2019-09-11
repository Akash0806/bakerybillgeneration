package main.java.io;

import java.util.List;
import java.util.Map;

public interface Parser<T> {
    String CSV_SEPARATOR = ",";
    String USER_INPUT_SEPARATOR = " ";

    Map<String, T> parseList(List<String> lines);
}
