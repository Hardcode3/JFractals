package org.jfractals.ui;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public final class ViewOptions {
    private final BooleanProperty showScale = new SimpleBooleanProperty(this, "showScale", true);

    public boolean getShowScale() {
        return showScale.get();
    }
    public void setShowScale(boolean showScale) {
        this.showScale.set(showScale);
    }
    public BooleanProperty getShowScaleProperty() {
        return showScale;
    }
}
