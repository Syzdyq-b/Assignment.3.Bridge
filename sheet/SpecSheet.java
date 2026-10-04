package sheet;

import renderer.Field;
import renderer.SheetRenderer;
import spec.ComputerSpec;

import java.util.List;

public abstract class SpecSheet {
    protected final ComputerSpec spec;
    private SheetRenderer renderer;

    protected SpecSheet(ComputerSpec spec, SheetRenderer renderer) {
        if (spec == null) {
            throw new IllegalArgumentException("Spec must not be null");
        }
        this.spec = spec;
        switchRenderer(renderer);
    }

    public final void switchRenderer(SheetRenderer newRenderer) {
        if (newRenderer == null) {
            throw new IllegalArgumentException("Renderer must not be null");
        }
        this.renderer = newRenderer;
    }

    public final String print() {
        return renderer.render(title(), fields());
    }

    protected abstract String title();

    protected abstract List<Field> fields();
}
