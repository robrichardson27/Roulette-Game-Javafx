/* Wheel class draws the roulette wheel */

import javafx.scene.text.*;
import javafx.scene.paint.Color;
import javafx.geometry.*;
import javafx.scene.transform.*;
import javafx.scene.shape.*;
import javafx.scene.*;

public class Wheel {

    // Angle per segment of roulette wheel.
    private static final double ANGLE = 9.72972973f;
    // Sets the start angle for drawing the wheel segments.
    private static final double START_ANGLE = 85.135135135f;

    private Group wheel = new Group();
    private Group text = new Group();

    public void makeWheel() {
        drawSegments();
        drawNumbers();
    }

    public Group getWheel() {
        return wheel;
    }

    public Group getText() {
        return text;
    }
    // Draws each segment as an arc, 0 is set to North.
    private void drawSegments() {
        double startAngle = START_ANGLE;
        for (int i = 0; i < 37; i++) {
            Arc arc = new Arc();
            if (i == 0) {
                arc.setFill(Color.GREEN);
            }
            else if (i % 2 == 0) {
                arc.setFill(Color.RED);
            }
            else {
                arc.setFill(Color.BLACK);
            }
            arc.setCenterX(400.0f);
            arc.setCenterY(400.0f);
            arc.setRadiusX(300.0f);
            arc.setRadiusY(300.0f);
            arc.setStartAngle(startAngle);
            arc.setLength(ANGLE);
            arc.setType(ArcType.ROUND);
            wheel.getChildren().add(arc);
            startAngle += ANGLE;
        }
    }
    // Draws the numbers on top of the segments.
    private void drawNumbers() {
        // Iterates through enum class of numbers.
        for (Number n : Number.values()) {
            Text textNode = new Text(""+n.getNumber());
            int centreX = 400;
            int centreY = 380;
            int radius = 270;
            double angleText = (180+n.getAngle());
            textNode.setFill(Color.WHITE);
            textNode.setFont(Font.font ("Tahoma", 20));
            double x = centreX + radius * (Math.cos((n.getAngle()+88) * Math.PI / 180f));
            double y = centreY + radius * (Math.sin((n.getAngle()+88) * Math.PI / 180f));
            textNode.relocate(x, y);
            textNode.getTransforms().add(new Rotate(angleText));
            text.getChildren().add(textNode);
        }
    }
}
