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
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.*;
import javafx.scene.canvas.*;
import javafx.scene.canvas.GraphicsContext;


public class Roulette2 extends Application {

    // Number of steps in one orbit of roulette wheel.
    private static final double ANGLE = 9.72972973f;
    // Sets number of rotations of wheel - must be multiple of 360.
    private static final int SPIN_LENGTH = 1800;

    private static final int MIN = 0;
    private static final int MAX = 37;

    private Group root = new Group();
    private Scene scene = new Scene(root, 1600, 800, Color.DARKGREEN);
    private Stage primaryStage = new Stage();

    // Graphic objects.
    private Ball ball = new Ball();
    private Wheel wheel = new Wheel();
    private Table table = new Table();
    private Button buttonSpin = new Button("Spin");
    // Logic objects.
    private Number result = new Number();
    private NumberSet numberSet = new NumberSet();
    private Player player = new Player();

    public void start(Stage stage) {
        primaryStage = stage;
        primaryStage.setTitle("Roulette");
        wheel.makeWheel();
        table.makeTable();
        showScene();
        buttonSpin.setOnAction(this::press);
        placeBets();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showScene() {
        Group background = new Group(wheel.getWheel(), table.getTable(), ball.getShape(), buttonSpin);
        root.getChildren().add(background);
    }

    private void placeBets() {
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                if (t.getSceneX() >= 740 && t.getSceneX() <= 1560 && t.getSceneY() >= 200 && t.getSceneY() <= 580) {
                        if (t.getSceneX() >= 200 && t.getSceneY() )
                        root.getChildren().add(new Chip(t.getSceneX(),t.getSceneY()));
                }
            }
        });
    }

    // Runs the logic for a wheel spin.
    private void press(ActionEvent e) {
        getRandomNum();
        System.out.println(result.getNumber());
        System.out.println(result.getColor());
        animate();
        root.getChildren().clear();
        showScene();
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
