
public class Player {

    private int credit;

    public void setCredit(int c) {
        this.credit = c;
    }

    public void addCredit(int c) {
        this.credit += c;
    }

    public void subCredit(int c) {
        this.credit -= c;
    }

    public int getCredit() {
        return credit;
    }
}
