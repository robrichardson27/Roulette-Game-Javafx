import java.util.*;

public class Betting {

    private static final int MIN = 0;
    private static final int MAX = 37;
    private static final double WIDTH = 55;
    private static final double HEIGHT = 100;
    private static final double START_X = 850;
    private static final double START_Y = 400;

    private int betRed = 0;
    private int betBlack = 0;
    private int betEven = 0;
    private int betOdd = 0;
    private int betFirst18 = 0;
    private int betLast18 = 0;
    private int betFirst12 = 0;
    private int betSecond12 = 0;
    private int betLast12 = 0;
    private int betZero = 0;
    private int betCol1 = 0;
    private int betCol2 = 0;
    private int betCol3 = 0;
    private List<Integer> betNumber = new ArrayList<Integer>();

    private Number result = new Number();
    private NumberSet numberSet = new NumberSet();
    private Player player;
    // BetSquare check for where the bet was placed on the table.
    private BetSquare red = new BetSquare(1070, 540, 110, 40);
    private BetSquare black = new BetSquare(1180, 540, 110, 40);
    private BetSquare even = new BetSquare(960, 540, 110, 40);
    private BetSquare odd = new BetSquare(1290, 540, 110, 40);
    private BetSquare first18 = new BetSquare(850, 540, 110, 40);
    private BetSquare last18 = new BetSquare(1400, 540, 110, 40);
    private BetSquare first12 = new BetSquare(850, 500, 220, 40);
    private BetSquare second12 = new BetSquare(1070, 500, 220, 40);
    private BetSquare last12 = new BetSquare(1290, 500, 220, 40);
    private BetSquare zero = new BetSquare(START_X-WIDTH, START_Y-(HEIGHT*2), WIDTH, HEIGHT*3);
    private BetSquare col1 = new BetSquare(START_X+(WIDTH*12), START_Y, WIDTH, HEIGHT);
    private BetSquare col2 = new BetSquare(START_X+(WIDTH*12), START_Y-HEIGHT, WIDTH, HEIGHT);
    private BetSquare col3 = new BetSquare(START_X+(WIDTH*12), START_Y-(HEIGHT*2), WIDTH, HEIGHT);

    private List<BetSquare> numbers = new ArrayList<BetSquare>();

    public Betting() {
        double x = START_X;
        double y = START_Y;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                BetSquare b = new BetSquare(x, y, WIDTH, HEIGHT);
                numbers.add(b);
                y -= HEIGHT;
            }
            y = START_Y;
            x += WIDTH;
        }
        for (int i = 0; i < 37; i++) {
            Integer n = 0;
            betNumber.add(i, n);
        }
    }

    public void setPlayer(Player p) {
        this.player = p;
    }

    public int getAngle() {
        return result.getAngle();
    }

    public void resetBets() {
        betRed = 0;
        betBlack = 0;
        betEven = 0;
        betOdd = 0;
        betFirst18 = 0;
        betLast18 = 0;
        betFirst12 = 0;
        betSecond12 = 0;
        betLast12 = 0;
        betZero = 0;
        betCol1 = 0;
        betCol2 = 0;
        betCol3 = 0;
        for (int i = 0; i < betNumber.size(); i++) {
            betNumber.set(i, 0);
        }
    }

    public void setRandomNum() {
        int number = (int)(Math.random()*(MAX - MIN) + MIN);
        for (Number n : numberSet.getNumberSet()) {
            if (n.getNumber() == number) {
                result = n;
            }
        }
    }

    public void setBets(double x, double y) {
        if (red.getPosition(x, y)) {
            betRed++;
        }
        if (black.getPosition(x, y)) {
            betBlack++;
        }
        if (even.getPosition(x, y)) {
            betEven++;
        }
        if (odd.getPosition(x, y)) {
            betOdd++;
        }
        if (first18.getPosition(x, y)) {
            betFirst18++;
        }
        if (last18.getPosition(x, y)) {
            betLast18++;
        }
        if (first12.getPosition(x, y)) {
            betFirst12++;
        }
        if (second12.getPosition(x, y)) {
            betSecond12++;
        }
        if (last12.getPosition(x, y)) {
            betLast12++;
        }
        if (zero.getPosition(x, y)) {
            betZero++;
        }
        if (col1.getPosition(x, y)) {
            betCol1++;
        }
        if (col2.getPosition(x, y)) {
            betCol2++;
        }
        if (col3.getPosition(x, y)) {
            betCol3++;
        }
        betOnNumber(x, y);
        player.subCredit(1);
        System.out.println("Before bet: £ "+player.getCredit());
    }

    private void betOnNumber(double x, double y) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).getPosition(x, y)) {
                int n = betNumber.get(i);
                n++;
                betNumber.set(i, n);
                System.out.println("bet on: "+(i+1));
            }
        }
    }

    public void calculateWin() {
        System.out.println("bets on red: "+betRed);
        System.out.println("bets on black: "+betBlack);
        System.out.println("Number is: "+result.getNumber());
        System.out.println("Colour is: "+result.getColor());
        if (result.getNumber() == 0) {
            player.addCredit(betZero*35);
            return;
        }
        if (result.getColor() == "R") {
            player.addCredit(betRed*2);
        }
        if (result.getColor() == "B") {
            player.addCredit(betBlack*2);
        }
        if (result.getOdd() == false) {
            player.addCredit(betEven*2);
        }
        if (result.getOdd() == true) {
            player.addCredit(betOdd*2);
        }
        if (result.getfirstEighteen() == true) {
            player.addCredit(betFirst18*2);
        }
        if (result.getfirstEighteen() == false) {
            player.addCredit(betLast18*2);
        }
        if (result.getSection() == 1) {
            player.addCredit(betFirst12*3);
        }
        if (result.getSection() == 2) {
            player.addCredit(betSecond12*3);
        }
        if (result.getSection() == 3) {
            player.addCredit(betLast12*3);
        }
        if (result.getColumn() == 1) {
            player.addCredit(betCol1*3);
        }
        if (result.getColumn() == 2) {
            player.addCredit(betCol2*3);
        }
        if (result.getColumn() == 3) {
            player.addCredit(betCol3*3);
        }
        // Minus 1 to i as betNumber array is indexed from 0.
        int i = result.getNumber();
        if (betNumber.get(i-1) > 0) {
            int n = betNumber.get(i-1);
            player.addCredit(n*35);
            System.out.println("winning number bet: "+i);
            System.out.println("winning amount bet: "+n);

        }

        System.out.println("After bet: £ "+player.getCredit());
    }

/******************************* Unit Testing *******************************/

    public static void main(String[] args) {
        Betting test = new Betting();
        Player player = new Player();
        test.setPlayer(player);
        test.testSingleNumberWin();
        System.out.println("All tests passed.");
    }

    // Test for winning with a bet on a single number.
    private void testSingleNumberWin() {
        // number sets the winning number.
        int number = 20;
        int creditBet = 1;
        player.setCredit(1);
        player.subCredit(1);
        for (Number n : numberSet.getNumberSet()) {
            if (n.getNumber() == number) {
                result = n;
            }
        }
        betNumber.set(number-1, creditBet);
        calculateWin();
        System.out.println(player.getCredit());
        assert(player.getCredit() == 35);
    }


}
