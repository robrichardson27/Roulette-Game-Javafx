/* NumberSet class wraps the data for numbers in an ArrayList and loads the data. */

import java.util.*;

public class NumberSet {

    private List<Number> numberSet = new ArrayList<Number>();

    public NumberSet() {
        // number, color, wheelAngle, tablePosX, tablePosY
        numberSet.add(new Number(0, "G", 180, 0, 0));
        numberSet.add(new Number(1, "R", 44, 0, 0));
        numberSet.add(new Number(2, "B", 238, 0, 0));
        numberSet.add(new Number(3, "R", 160, 0, 0));
        numberSet.add(new Number(4, "B", 219, 0, 0));
        numberSet.add(new Number(5, "R", 5, 0, 0));
        numberSet.add(new Number(6, "B", 277, 0, 0));
        numberSet.add(new Number(7, "R", 122, 0, 0));
        numberSet.add(new Number(8, "B", 336, 0, 0));
        numberSet.add(new Number(9, "R", 83, 0, 0));
        numberSet.add(new Number(10, "B", 355, 0, 0));
        numberSet.add(new Number(11, "B", 316, 0, 0));
        numberSet.add(new Number(12, "R", 141, 0, 0));
        numberSet.add(new Number(13, "B", 297, 0, 0));
        numberSet.add(new Number(14, "R", 63, 0, 0));
        numberSet.add(new Number(15, "B", 199, 0, 0));
        numberSet.add(new Number(16, "R", 24, 0, 0));
        numberSet.add(new Number(17, "B", 258, 0, 0));
        numberSet.add(new Number(18, "R", 102, 0, 0));
        numberSet.add(new Number(19, "R", 209, 0, 0));
        numberSet.add(new Number(20, "B", 54, 0, 0));
        numberSet.add(new Number(21, "R", 229, 0, 0));
        numberSet.add(new Number(22, "B", 92, 0, 0));
        numberSet.add(new Number(23, "R", 345, 0, 0));
        numberSet.add(new Number(24, "B", 15, 0, 0));
        numberSet.add(new Number(25, "R", 248, 0, 0));
        numberSet.add(new Number(26, "B", 170, 0, 0));
        numberSet.add(new Number(27, "R", 287, 0, 0));
        numberSet.add(new Number(28, "B", 131, 0, 0));
        numberSet.add(new Number(29, "B", 112, 0, 0));
        numberSet.add(new Number(30, "R", 326, 0, 0));
        numberSet.add(new Number(31, "B", 73, 0, 0));
        numberSet.add(new Number(32, "R", 190, 0, 0));
        numberSet.add(new Number(33, "B", 34, 0, 0));
        numberSet.add(new Number(34, "R", 268, 0, 0));
        numberSet.add(new Number(35, "B", 151, 0, 0));
        numberSet.add(new Number(36, "R", 306, 0, 0));
    }

    public List<Number> getNumberSet() {
        return numberSet;
    }
}
