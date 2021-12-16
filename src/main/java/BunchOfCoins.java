import java.util.Arrays;
/**
 * Bunch of coins with possible values of 1,2,5 and 10
 */
public class BunchOfCoins {
    private int numOfOnes;
    private int numOfTwos;
    private int numOfFives;
    private int numOfTens;

    public BunchOfCoins(int numOfOnes, int numOfTwos, int numOfFives, int numOfTens) {
        this.numOfOnes = numOfOnes;
        this.numOfTwos = numOfTwos;
        this.numOfFives = numOfFives;
        this.numOfTens = numOfTens;
    }

    /**
     * Combines this BunchOfCoins with other increasing value of this.
     *
     * @param other Non-null bunch of coins
     */
    public void combineWithOther(BunchOfCoins other) {
        this.numOfOnes+= other.numOfOnes;
        other.numOfOnes = 0;
        this.numOfTwos+= other.numOfTwos;
        other.numOfTwos = 0;
        this.numOfFives+= other.numOfFives;
        other.numOfFives = 0;
        this.numOfTens+= other.numOfTens;
        other.numOfTens = 0;
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
    public BunchOfCoins greedyWithdrawal(int amount) {                        // help
        /*int[] desiredAmount;
        while (amount != 0) {
            for (int i=0 ; i < ???; i++) {
                if (???[i] <= amount) {
                    amount = amount - ???[i];
                    i++;
                }
            }
        }*/
        return null;
    }

    /**
     * Quantity of coins with value 1 in this bunch.
     * @return Quantity of coins with value 1 in this bunch.
     */
    public int getOnes() {
        return this.numOfOnes;
    }

    /**
     *  Quantity of coins with value 2 in this bunch.
     *  @return Quantity of coins with value 2 in this bunch.
     */
    public int getTwos() {
        return this.numOfTwos;
    }

    /**
     *  Quantity of coins with value 5 in this bunch.
     *  @return Quantity of coins with value 5 in this bunch.
     */
    public int getFives() {
        return this.numOfFives;
    }

    /**
     * Quantity of coins with value 10 in this bunch.
     * @return Quantity of coins with value 10 in this bunch.
     */
    public int getTens() {
        return this.numOfTens;
    }

    @Override public String toString() { // what does it override and in which cases?
        return "BunchOfCoins{" +
                "ones=" + getOnes() +
                ", twos=" + getTwos() +
                ", fives=" + getFives() +
                ", tens=" + getTens() +
                '}';
    }
}