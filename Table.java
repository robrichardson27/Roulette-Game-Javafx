/* Graphic object for table */

import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.transform.*;

public class Table {

    // private List<Rectangle, Number
    // Group contains all graphical elements for the table.
    private Group table = new Group();
    // NumberSet used to draw color..
    private NumberSet numberSet = new NumberSet();

    private static final double WIDTH = 55;
    private static final double HEIGHT = 100;
    private static final double START_X = 850;
    private static final double START_Y = 400;

    public void makeTable() {
        drawGrid();
    }

    public Group getTable() {
        return table;
    }

    private void drawGrid() {
        double x = START_X;
        double y = START_Y;
        int cnt = 1;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                createNumbers(cnt, x, y);
                cnt++;
                y -= HEIGHT;
            }
            y = START_Y;
            x += WIDTH;
        }
        createTwelves();
        createZero();
        createOddEvenRedBlack();
        createTwotoOne();
    }

    private void createTwotoOne() {
        double x = START_X+(WIDTH*12);
        double y = START_Y;
        for (int i = 0; i < 3; i++) {
            Rectangle r = new Rectangle(x, y, WIDTH, HEIGHT);
            r.setStroke(Color.WHITE);
            r.setStrokeWidth(3);
            r.setFill(Color.DARKGREEN);
            table.getChildren().add(r);
            Text textNode = new Text("2 to 1");
            placeText(textNode, x+35, y+60, 20, 270);
            table.getChildren().add(textNode);
            y -= HEIGHT;
        }
    }

    private void createOddEvenRedBlack() {
        double x = START_X;
        double y = START_Y + HEIGHT+40;
        for (int i = 0; i < 6; i++) {
            Rectangle r = new Rectangle(x, y, WIDTH*2, 40);
            r.setStroke(Color.WHITE);
            r.setStrokeWidth(3);
            r.setFill(Color.DARKGREEN);
            if (i == 2) {
                r.setFill(Color.RED);
            }
            if (i == 3) {
                r.setFill(Color.BLACK);
            }
            table.getChildren().add(r);
            x += WIDTH*2;
        }
        Text textNode1 = new Text("1 to 18");
        Text textNode2 = new Text("EVEN");
        Text textNode3 = new Text("ODD");
        Text textNode4 = new Text("19 to 36");
        x = 20;
        y += 10;
        placeText(textNode1, START_X+x, y, 20, 0);
        placeText(textNode2, START_X+(WIDTH*2)+x, y, 20, 0);
        placeText(textNode3, START_X+(WIDTH*8)+x, y, 20, 0);
        placeText(textNode4, START_X+(WIDTH*10)+x, y, 20, 0);
        table.getChildren().add(textNode1);
        table.getChildren().add(textNode2);
        table.getChildren().add(textNode3);
        table.getChildren().add(textNode4);
    }


    private void createZero() {
        Rectangle r = new Rectangle(START_X-WIDTH, START_Y-(HEIGHT*2), WIDTH, HEIGHT*3);
        r.setFill(Color.GREEN);
        r.setStroke(Color.WHITE);
        r.setStrokeWidth(3);
        Text textNode = new Text("0");
        placeText(textNode, START_X-20, START_Y-68, 30, 270);
        table.getChildren().add(r);
        table.getChildren().add(textNode);
    }

    private void createNumbers(int cnt, double x, double y) {
        Rectangle r = new Rectangle(x, y, WIDTH, HEIGHT);
        for (Number n : numberSet.getNumberSet()) {
            if (n.getNumber() == cnt) {
                if (n.getColor().equals("R")) {
                    r.setFill(Color.RED);
                }
                else {
                    r.setFill(Color.BLACK);
                }
                r.setStroke(Color.WHITE);
                r.setStrokeWidth(3);
                Text textNode = new Text(""+cnt);
                if (cnt < 10) {
                    placeText(textNode, x+40, y+30, 30, 270);
                }
                else {
                    placeText(textNode, x+40, y+35, 30, 270);
                }
                table.getChildren().add(r);
                table.getChildren().add(textNode);
            }
        }
    }

    private void createTwelves() {
        double x = START_X;
        double y = START_Y + HEIGHT;
        for (int i = 0; i < 3; i++) {
            Rectangle r = new Rectangle(x, y, WIDTH*4, 40);
            r.setStroke(Color.WHITE);
            r.setStrokeWidth(3);
            r.setFill(Color.DARKGREEN);
            table.getChildren().add(r);
            x += WIDTH*4;
        }
        Text textNode1 = new Text("1st 12");
        Text textNode2 = new Text("2nd 12");
        Text textNode3 = new Text("3rd 12");
        x = START_X+WIDTH+20;
        placeText(textNode1, x, y+10, 20, 0);
        placeText(textNode2, x+(WIDTH*4), y+10, 20, 0);
        placeText(textNode3, x+(WIDTH*8), y+10, 20, 0);
        table.getChildren().add(textNode1);
        table.getChildren().add(textNode2);
        table.getChildren().add(textNode3);
    }

    private void placeText(Text t, double x, double y, int f, double r) {
        t.setFill(Color.YELLOW);
        t.setFont(Font.font ("Tahoma", f));
        t.relocate(x, y);
        t.getTransforms().add(new Rotate(r));
    }
}
