
public enum Number {

    ZERO (0, 180, "G"),
    ONE (1, 44, "R"),
    TWO (2, 238, "B"),
    THREE (3, 160, "R"),
    FOUR (4, 219, "B"),
    FIVE (5, 5, "R"),
    SIX (6, 277, "B"),
    SEVEN (7, 122, "R"),
    EIGHT (8, 336, "B"),
    NINE (9, 83, "R"),
    TEN (10, 355, "B"),
    ELEVEN (11, 316, "B"),
    TWELVE (12, 141, "R"),
    THIRTEEN (13, 297, "B"),
    FOURTEEN (14, 63, "R"),
    FIFTEEN (15, 199, "B"),
    SIXTEEN (16, 24, "R"),
    SEVENTEEN (17, 258, "B"),
    EIGHTEEN (18, 102, "R"),
    NINETEEN (19, 209, "R"),
    TWENTY (20, 54, "B"),
    TWENTY_ONE (21, 229, "R"),
    TWENTY_TWO (22, 92, "B"),
    TWENTY_THREE (23, 345, "R"),
    TWENTY_FOUR (24, 15, "B"),
    TWENTY_FIVE (25, 248, "R"),
    TWENTY_SIX (26, 170, "B"),
    TWNETY_SEVEN (27, 287, "R"),
    TWENT_EIGHT (28, 131, "B"),
    TWENTY_NINE (29, 112, "B"),
    THIRTY (30, 326, "R"),
    THIRTY_ONE (31, 73, "B"),
    THIRTY_TWO (32, 190, "R"),
    THIRTY_THREE (33, 34, "B"),
    THIRTY_FOUR (34, 268, "R"),
    THIRTY_FIVE (35, 151, "B"),
    THIRTY_SIX (36, 306, "R");

    int number;
    int angle;
    String colour;

    Number(int n, int a, String c) {
        this.number = n;
        this.angle = a;
        this.colour = c;
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
}
