package renderer;

import java.util.List;

public final class HtmlSheetRenderer implements SheetRenderer {
    @Override
    public String render(String title, List<Field> fields) {
        String nl = System.lineSeparator();
        StringBuilder out = new StringBuilder("<h1>").append(escape(title)).append("</h1>").append(nl)
                .append("<table>");
        for (Field field : fields) {
            out.append(nl).append("  <tr><th>").append(escape(field.label()))
                    .append("</th><td>").append(escape(field.value())).append("</td></tr>");
        }
        return out.append(nl).append("</table>").toString();
    }

    private static String escape(String text) {
        return text.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }
}
