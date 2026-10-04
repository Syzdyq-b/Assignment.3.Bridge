package renderer;

import java.util.List;
import java.util.stream.Collectors;

public final class JsonSheetRenderer implements SheetRenderer {
    @Override
    public String render(String title, List<Field> fields) {
        String body = fields.stream()
                .map(f -> "  \"" + escape(f.label()) + "\": \"" + escape(f.value()) + "\"")
                .collect(Collectors.joining("," + System.lineSeparator()));
        return "{" + System.lineSeparator()
                + "  \"title\": \"" + escape(title) + "\"," + System.lineSeparator()
                + body + System.lineSeparator() + "}";
    }

    private static String escape(String text) {
        return text.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
