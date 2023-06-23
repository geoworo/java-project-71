package hexlet.code.formatters;

import java.util.Map;
import java.util.List;

public class FormatterPlain {
    public static String formatAsPlain(List<Map<String, Object>> data) {

        StringBuilder sb = new StringBuilder();

        for (var map: data) {
            String type = map.get("status").toString();
            switch (type) {
                case "changed":
                    String value1 = transformValue(map.get("value1"));
                    String value2 = transformValue(map.get("value2"));
                    sb.append("Property '" + map.get("key") + "' was updated. From " + value1 + " to " + value2);
                    break;
                case "removed":
                    sb.append("Property '" + map.get("key") + "' was removed");
                    break;
                case "added":
                    String value = transformValue(map.get("value"));
                    sb.append("Property '" + map.get("key") + "' was added with value: " + value);
                    break;
                default:
                    break;
            }

            sb.append("\n");
        }

        return sb.toString().trim();
    }

    public static String transformValue(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        } else if (value instanceof Map<?, ?> || value instanceof Iterable<?>) {
            return "[complex value]";
        } else {
            return value.toString();
        }
    }
}
