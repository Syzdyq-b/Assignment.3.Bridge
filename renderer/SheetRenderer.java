package renderer;

import java.util.List;

public interface SheetRenderer {
    String render(String title, List<Field> fields);
}
