import javafx.scene.shape.*;

public class BetSquare {

    Rectangle r;

    public BetSquare(double x, double y, double h, double w) {
        this.r = new Rectangle(x, y, h, w);
    }

    public boolean getPosition(double x, double y) {
        double xMin = r.getX();
        double yMin = r.getY();
        double xMax = xMin + r.getWidth();
        double yMax = yMin + r.getHeight();
        if (x > xMin && x < xMax && y > yMin && y < yMax) {
            return true;
        }
        return false;
    }
}
