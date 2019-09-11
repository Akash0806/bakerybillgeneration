package main.java.io;

import java.util.List;

@FunctionalInterface
public interface Reader {
    List<String> readValue();
}
