package main.java.io;

import main.java.Exception.InvalidInputException;
import main.java.util.Constant;

import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toMap;

public class UserInputParser implements Parser<Integer> {

    @Override
    public Map<String, Integer> parseList(List<String> lines) {
        try {
            return lines.stream()
                    .map(line -> line.split(USER_INPUT_SEPARATOR))
                    .collect(toMap(o -> o[1].trim(), o -> parseInt(o[0].trim())));
        } catch (Exception ex) {
            throw new InvalidInputException(Constant.PROVIDE_VALID_INPUT);
        }
    }
}
