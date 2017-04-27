/* Spin class gets random number for each spin of the roulette wheel */

public class Spin {
    // Range for numbers on roulette wheel.
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
    // Iterates through enum class to set number, angle(for animation of ball)
    // and colour of the result.
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
