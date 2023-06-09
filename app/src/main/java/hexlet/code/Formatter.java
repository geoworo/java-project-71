package hexlet.code;

import hexlet.code.formatters.FormatterJson;
import hexlet.code.formatters.FormatterPlain;
import hexlet.code.formatters.FormatterStylish;

import java.util.Map;
import java.util.List;

public class Formatter {
    public static String format(List<Map<String, Object>> data, String format) throws Exception {
        switch (format) {
            case "stylish":
                return FormatterStylish.formatAsStylish(data);
            case "plain":
                return FormatterPlain.formatAsPlain(data);
            case "json":
                return FormatterJson.formatAsJson(data);
            default:
                throw new Exception("Invalid output format.");
        }
    }
}
