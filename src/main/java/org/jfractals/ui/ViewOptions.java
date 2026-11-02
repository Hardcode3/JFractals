package org.jfractals.ui;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public final class ViewOptions {
    private final BooleanProperty showScale = new SimpleBooleanProperty(this, "showScale", true);
    private final BooleanProperty showCenterCoordinates = new SimpleBooleanProperty(this, "showInfoLabel", true);
    private final BooleanProperty showAxes = new SimpleBooleanProperty(this, "showAxes", true);

    public BooleanProperty getShowScaleProperty() {
        return showScale;
    }
    public BooleanProperty getShowCenterCoordinatesProperty() {
        return showCenterCoordinates;
    }
    public BooleanProperty getShowAxesProperty () {
        return showAxes;
    }
}
