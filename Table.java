import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.transform.*;

public class Table {

    private Group table = new Group();
    private NumberSet numberSet = new NumberSet();

    // array of buttons for betting
    public void makeTable() {
        drawGrid();

    }

    public Group getTable() {
        return table;
    }

    private void drawGrid() {
        double x = 900;
        double y = 400;
        int cnt = 1;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                createRec(cnt, x, y);
                cnt++;
                y -= 100;
            }
            y = 400;
            x += 55;
        }
    }

    private void createRec(int cnt, double x, double y) {
        Rectangle r = new Rectangle(x, y, 55, 100);
        Group text = new Group();
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
                    textNode.relocate(x+20, y+45);
                }
                else {
                    textNode.relocate(x+10, y+45);
                }
                textNode.setFill(Color.YELLOW);
                textNode.setFont(Font.font ("Tahoma", 30));
                text.getChildren().add(textNode);
                table.getChildren().add(r);
                table.getChildren().add(text);
            }
        }
    }
}
