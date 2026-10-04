package renderer;

import java.util.List;

public final class TextSheetRenderer implements SheetRenderer {
    @Override
    public String render(String title, List<Field> fields) {
        StringBuilder out = new StringBuilder("== ").append(title).append(" ==");
        for (Field field : fields) {
            out.append(System.lineSeparator())
                    .append("  ").append(field.label()).append(": ").append(field.value());
        }
        return out.toString();
    }
}
