package sheet;

import renderer.Field;
import renderer.SheetRenderer;
import spec.ComputerSpec;

import java.util.List;

public final class FullSpecSheet extends SpecSheet {

    public FullSpecSheet(ComputerSpec spec, SheetRenderer renderer) {
        super(spec, renderer);
    }

    @Override
    protected String title() {
        return "Full spec";
    }

    @Override
    protected List<Field> fields() {
        return List.of(
                new Field("CPU", spec.cpu()),
                new Field("RAM", spec.ramGb() + " GB"),
                new Field("Storage", spec.storageGb() + " GB"),
                new Field("OS", spec.operatingSystem()));
    }
}
