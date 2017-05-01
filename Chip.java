/* Graphic object for chips */

import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Chip extends Circle {

    public Chip(double x, double y) {
        super(x, y, 15, Color.BLUE);
        setStroke(Color.WHITE);
        setStrokeWidth(3);
        getStrokeDashArray().addAll(5d);
        setStrokeDashOffset(3d);
    }
}
