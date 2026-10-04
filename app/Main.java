package app;

import renderer.HtmlSheetRenderer;
import renderer.JsonSheetRenderer;
import renderer.SheetRenderer;
import renderer.TextSheetRenderer;
import sheet.BriefSpecSheet;
import sheet.FullSpecSheet;
import sheet.SpecSheet;
import spec.ComputerSpec;

import java.util.List;

public final class Main {

    public static void main(String[] args) {
        ComputerSpec spec = new ComputerSpec("AMD Ryzen 7", 16, 512, "Windows 11");

        demoAllCombinations(spec);
        demoRuntimeSwitch(spec);
        demoValidation(spec);
    }

    private static void demoAllCombinations(ComputerSpec spec) {
        System.out.println("=== Every abstraction with every implementor ===");
        List<SheetRenderer> renderers = List.of(
                new TextSheetRenderer(), new JsonSheetRenderer(), new HtmlSheetRenderer());
        for (SheetRenderer renderer : renderers) {
            System.out.println("--- " + renderer.getClass().getSimpleName() + " ---");
            System.out.println(new BriefSpecSheet(spec, renderer).print());
            System.out.println(new FullSpecSheet(spec, renderer).print());
        }
    }

    private static void demoRuntimeSwitch(ComputerSpec spec) {
        System.out.println("\n=== Switching the implementor at runtime ===");
        SpecSheet sheet = new FullSpecSheet(spec, new TextSheetRenderer());
        System.out.println(sheet.print());
        sheet.switchRenderer(new JsonSheetRenderer());
        System.out.println(sheet.print());
    }

    private static void demoValidation(ComputerSpec spec) {
        System.out.println("\n=== Validated construction ===");
        try {
            new BriefSpecSheet(spec, null);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
        try {
            new ComputerSpec("intel i5", 0, 512, "Linux");
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}
