/* Ball class sets the rotate transform */

import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.transform.*;

public class Ball {

    private Circle ball = new Circle(400, 140, 20);

    Ball() {
        ball.setFill(Color.GOLD);
        ball.setTranslateY(260);
        ball.getTransforms().add(new Translate(0, 260));
    }

    public Circle getShape() {
        return ball;
    }
}
