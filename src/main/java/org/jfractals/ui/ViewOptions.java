package org.jfractals.ui;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public final class ViewOptions {
    private final BooleanProperty showScale = new SimpleBooleanProperty(this, "showScale", true);

    private final BooleanProperty showInfoLabel = new SimpleBooleanProperty(this, "showInfoLabel", true);
    private final BooleanProperty showCenterCoordinates = new SimpleBooleanProperty(this, "showInfoLabel", true);
    private final BooleanProperty showZoom = new SimpleBooleanProperty(this, "showZoom", true);

    private final BooleanProperty showAxes = new SimpleBooleanProperty(this, "showAxes", true);

    public BooleanProperty getShowScaleProperty() {
        return showScale;
    }
    public BooleanProperty getShowInfoLabelProperty() {
        return showInfoLabel;
    }
    public BooleanProperty getShowCenterCoordinatesProperty() {
        return showCenterCoordinates;
    }
    public BooleanProperty getShowZoomProperty() {
        return showZoom;
    }
    public BooleanProperty getShowAxesProperty () {
        return showAxes;
    }
}
