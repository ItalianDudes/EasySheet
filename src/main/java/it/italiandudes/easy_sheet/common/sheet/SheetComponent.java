package it.italiandudes.easy_sheet.common.sheet;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface SheetComponent {
    void writeComponent(@NotNull Document dndSheet, @NotNull Element parent);
}
