package hexlet.code.formatters;

import java.util.Map;
import java.util.List;

public class FormatterStylish {
    public static String formatAsStylish(List<Map<String, Object>> data) throws Exception {
        StringBuilder sb = new StringBuilder("{\n");

        for (var map : data) {
            String type = map.get("type").toString();
            switch (type) {
                case "changed":
                    String value1 = stringify(map.get("value1"));
                    String value2 = stringify(map.get("value2"));
                    sb.append("  - " + map.get("key") + ": " + value1);
                    sb.append("\n");
                    sb.append("  + " + map.get("key") + ": " + value2);
                    sb.append("\n");
                    break;
                case "removed":
                    sb.append("  - " + map.get("key") + ": " + map.get("value"));
                    sb.append("\n");
                    break;
                case "added":
                    sb.append("  + " + map.get("key") + ": " + map.get("value"));
                    sb.append("\n");
                    break;
                case "unchanged":
                    sb.append("    " + map.get("key") + ": " + map.get("value"));
                    sb.append("\n");
                    break;
                default:
                    throw new Exception("Unknown status");
            }
        }

        sb.append("}");
        return sb.toString();
    }

    private static String stringify(Object obj) {
        if (obj == null) {
            return "null";
        } else {
            return obj.toString();
        }
    }
}
