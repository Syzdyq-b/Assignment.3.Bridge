# Assignment #3 — Bridge pattern (Computer Spec Sheet)

Topic: printing a computer's specification in different **levels of detail** (what) and different **formats** (how).
The two dimensions vary independently, so Bridge avoids a class for every combination.

## Structure
| Role | Class |
| --- | --- |
| Abstraction | `sheet.SpecSheet` (holds a `SheetRenderer`) |
| Refined Abstraction | `BriefSpecSheet`, `FullSpecSheet` |
| Implementor | `renderer.SheetRenderer` |
| Concrete Implementor | `TextSheetRenderer`, `JsonSheetRenderer`, `HtmlSheetRenderer` |
| Client | `app.Main` (combines them and switches the renderer at runtime) |

2 abstractions x 3 implementors = 6 combinations from only 5 classes (instead of 6 via inheritance).

## Clean Code principles
1. **Separation of concerns across the bridge** — `SpecSheet` decides which fields to show; renderers only decide how to draw them. Renderers never read `ComputerSpec`, and the client never touches formatting details.
2. **Meaningful names** — `*SpecSheet` names are abstraction-side, `*SheetRenderer` names are implementor-side, so the role is clear from the name.
3. **Small, focused classes** — every class has one reason to change (`Field` = a pair, `JsonSheetRenderer` = JSON only).
4. **No duplicated logic** — field selection exists only in the sheets; escaping/format logic exists only in its own renderer.
5. **Open/Closed, backward compatible** — adding `MarkdownSheetRenderer` or `CompactSpecSheet` requires no change to existing classes.
6. **Fail fast validation** — `ComputerSpec` and `SpecSheet` reject null/invalid input with `IllegalArgumentException`.
7. **Composition over inheritance** — the renderer is injected, not inherited, and can be swapped at runtime via `switchRenderer`.
8. **Single composition root** — only `Main` chooses concrete classes.

## Run
```
javac -d out $(find src -name "*.java")
java -cp out app.Main
```
