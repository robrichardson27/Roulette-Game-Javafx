/* Driver class for a simple roulette wheel casino game */

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.shape.*;
import javafx.scene.transform.*;
import javafx.geometry.*;
import javafx.animation.*;
import javafx.util.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.text.Text;


public class Roulette extends Application {

    // Number of steps in one orbit of roulette wheel.
    private static final double ANGLE = 9.72972973f;
    // Sets number of rotations of wheel - must be multiple of 360.
    private static final int SPIN_LENGTH = 1800;
    // Scene size.
    private static final int SIZE = 800;

    private Ball ball = new Ball();

    public void start(Stage stage) {
        double angle = 85.135135135f;
        Group wheel = new Group();
        Group text = new Group();
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
            arc.setStartAngle(angle);
            arc.setLength(ANGLE);
            arc.setType(ArcType.ROUND);
            wheel.getChildren().add(arc);

            angle += ANGLE;

        }
        for (int i = 0; i < 37; i++) {
            Text textNode = new Text(""+i);
            int centreX = 400;
            int centreY = 390;
            int radius = 270;
            double angleText = (180+numberToAngle(i));
            textNode.setFill(Color.YELLOW);
            double x = centreX + radius * (Math.cos(numberToAngle(i) * Math.PI / 180f));
            double y = centreY + radius * (Math.sin(numberToAngle(i) * Math.PI / 180f));
            System.out.println(x);
            System.out.println(y);
            textNode.relocate(y, x);
            textNode.getTransforms().add(new Rotate(angleText));
            text.getChildren().add(textNode);
        }

        Button b = new Button("Spin");

        Group root = new Group(wheel, ball.getShape(), text, b);
        Scene scene = new Scene(root, SIZE, SIZE);
        b.setOnAction(this::press);
        stage.setScene(scene);
        stage.show();
    }

    private void press(ActionEvent e) {
        animate(ball);
    }

    private void animate(Ball ball) {
        Duration d = Duration.seconds(3);
        RotateTransition rt = new RotateTransition(d, ball.getShape());
        rt.setFromAngle(180);
        rt.setToAngle(SPIN_LENGTH + getRandomNum(0, 37));
        rt.setAxis(Rotate.Z_AXIS);
        rt.setAutoReverse(false);
        rt.play();
    }

    private int getRandomNum(int min, int max) {
        int number = (int)(Math.random()*(max - min) + min);
        System.out.println(number);
        return numberToAngle(number);
    }

    // Big ugly switch statement to convert number to angle for animation.
    private int numberToAngle(int number) {
        int angle;
        switch (number) {
            case 1: angle = 44;
                break;
            case 2: angle =  238;
                break;
            case 3: angle =  160;
                break;
            case 4: angle =  219;
                break;
            case 5: angle =  5;
                break;
            case 6: angle =  277;
                break;
            case 7: angle =  122;
                break;
            case 8: angle =  336;
                break;
            case 9: angle =  83;
                break;
            case 10: angle =  355;
                break;
            case 11: angle =  316;
                break;
            case 12: angle =  141;
                break;
            case 13: angle =  297;
                break;
            case 14: angle =  63;
                break;
            case 15: angle =  199;
                break;
            case 16: angle =  24;
                break;
            case 17: angle =  258;
                break;
            case 18: angle =  102;
                break;
            case 19: angle =  209;
                break;
            case 20: angle =  54;
                break;
            case 21: angle =  229;
                break;
            case 22: angle =  92;
                break;
            case 23: angle =  345;
                break;
            case 24: angle =  15;
                break;
            case 25: angle =  248;
                break;
            case 26: angle =  170;
                break;
            case 27: angle =  287;
                break;
            case 28: angle =  131;
                break;
            case 29: angle =  112;
                break;
            case 30: angle =  326;
                break;
            case 31: angle =  73;
                break;
            case 32: angle =  190;
                break;
            case 33: angle =  34;
                break;
            case 34: angle =  268;
                break;
            case 35: angle =  151;
                break;
            case 36: angle =  306;
                break;
            default: angle =  180;
                break;
        }
        return angle;
    }

}
