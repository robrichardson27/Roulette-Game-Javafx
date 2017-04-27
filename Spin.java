public class Spin {

    private static final int MIN = 0;
    private static final int MAX = 37;

    private int number;
    private int angle;
    private String colour;

    public void go() {
        getRandomNum();
    }

    public int getNumber() {
        return number;
    }

    public int getAngle() {
        return angle;
    }

    public String getColour() {
        return colour;
    }

    private void getRandomNum() {
        number = (int)(Math.random()*(MAX - MIN) + MIN);
        for (Number n : Number.values()) {
            if (n.getNumber() == number) {
                colour = n.getColour();
                angle = n.getAngle();
            }
        }
    }
}
