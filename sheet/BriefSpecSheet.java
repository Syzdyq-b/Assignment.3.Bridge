package sheet;

import renderer.Field;
import renderer.SheetRenderer;
import spec.ComputerSpec;

import java.util.List;

public final class BriefSpecSheet extends SpecSheet {

    public BriefSpecSheet(ComputerSpec spec, SheetRenderer renderer) {
        super(spec, renderer);
    }

    @Override
    protected String title() {
        return "Brief spec";
    }

    @Override
    protected List<Field> fields() {
        return List.of(
                new Field("CPU", spec.cpu()),
                new Field("RAM", spec.ramGb() + " GB"));
    }
}
