/* Driver class for a simple roulette wheel casino game */

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.animation.*;
import javafx.util.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.transform.*;
import javafx.scene.paint.Color;

public class Roulette2 extends Application {

    // Number of steps in one orbit of roulette wheel.
    private static final double ANGLE = 9.72972973f;
    // Sets number of rotations of wheel - must be multiple of 360.
    private static final int SPIN_LENGTH = 1800;

    private static final int MIN = 0;
    private static final int MAX = 37;

    // boolean betting means betting can take place.
    // set to false when spin.
    // private boolean betting = true;

    // Graphic objects.
    private Ball ball = new Ball();
    private Wheel wheel = new Wheel();
    private Table table = new Table();
    // Logic objects.
    private Number result = new Number();
    private NumberSet numberSet = new NumberSet();


    public void start(Stage stage) {
        stage.setTitle("Roulette");
        wheel.makeWheel();
        table.makeTable();

        Button buttonSpin = new Button("Spin");
        Group root = new Group(wheel.getWheel(), table.getTable(), ball.getShape(), buttonSpin);
        Scene scene = new Scene(root, 1600, 800, Color.DARKGREEN);
        buttonSpin.setOnAction(this::press);
        stage.setScene(scene);
        stage.show();
    }
    // Runs the logic for a wheel spin.
    private void press(ActionEvent e) {
        getRandomNum();
        System.out.println(result.getNumber());
        System.out.println(result.getColor());
        animate();
    }

    // Iterates through NumberSet, angle(for animation of ball)
    // and color of the result.
    private void getRandomNum() {
        int number = (int)(Math.random()*(MAX - MIN) + MIN);
        for (Number n : numberSet.getNumberSet()) {
            if (n.getNumber() == number) {
                result = n;
            }
        }
    }

    // Animation for spinning ball.
    private void animate() {
        Duration d = Duration.seconds(3);
        RotateTransition rt = new RotateTransition(d, ball.getShape());
        rt.setFromAngle(180);
        rt.setToAngle(SPIN_LENGTH + result.getAngle());
        rt.setAxis(Rotate.Z_AXIS);
        rt.play();
    }
}
