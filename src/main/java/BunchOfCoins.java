/**
 * Bunch of coins with possible values of 1,2,5 and 10
 */
public class BunchOfCoins {
    // add necessary private fields and methods
    // add necessary constructor(s)
    // implement given public methods

    /**
     * Combines this BunchOfCoins with other increasing value of this.
     *
     * @param other Non-null bunch of coins
     */
    public void combineWithOther(BunchOfCoins other) {
        // place your code here.
    }

    /**
     * Withdraws desired amount from this bunch of coins into returning bunch.
     *
     * ACHTUNG!!! Proper (non-greedy) solution of this problem is hard (google for the knapsack problem).
     * Use greedy algorithm for this method.
     * Withdrawal is <b>greedy</b>, which means it tries to use the most <b>valuable</b> coin while
     * remaining amount is not less than it value.
     * E.g. if amount = 19 then solution is {10x1, 5x1, 2x2}, but not {5x3, 2x2}
     * even if first solution is not possible with current state of the bunch of coins
     *
     * @param amount Any non-negative number.
     * @return Bunch of coins with desired amount, null if withdraw is not possible with current state of bunch.
     */
    public BunchOfCoins greedyWithdrawal(int amount) {
        // place your code here.
        return null;
    }

    /**
     * Quantity of coins with value 1 in this bunch.
     * @return Quantity of coins with value 1 in this bunch.
     */
    public int getOnes() {
        return 0;
    }

    /**
     * Quantity of coins with value 2 in this bunch.
     * @return Quantity of coins with value 2 in this bunch.
     */
    public int getTwos() {
        return 0;
    }

    /**
     * Quantity of coins with value 5 in this bunch.
     * @return Quantity of coins with value 5 in this bunch.
     */
    public int getFives() {
        return 0;
    }

    /**
     * Quantity of coins with value 10 in this bunch.
     * @return Quantity of coins with value 10 in this bunch.
     */
    public int getTens() {
        return 0;
    }

    @Override public String toString() {
        return "BunchOfCoins{" +
            "ones=" + getOnes() +
            ", twos=" + getTwos() +
            ", fives=" + getFives() +
            ", tens=" + getTens() +
            '}';
    }
}
