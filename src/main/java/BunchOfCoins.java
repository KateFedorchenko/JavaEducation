import java.util.Arrays;
/**
 * Bunch of coins with possible values of 1,2,5 and 10
 */
public class BunchOfCoins {
    private int[] coins = new int[7];
    private int[] other;
    private int start;

    public void push(int val) {
        if(start<coins.length) {
            if (val == 1 || val == 2 || val == 5 || val == 10) {
                coins[start++] = val;
            } else {
                System.err.println("Not a possible value to add");
            }
        }
    }

    /**
     * Combines this BunchOfCoins with other increasing value of this.
     *
     * @param other Non-null bunch of coins
     */
    public void combineWithOther(BunchOfCoins other) {
        if(other == null) {
            System.err.println("Bunch of coins cannot be null");
        }
        // what to do? To put together two different arrays like coins{}+other{}?
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
        Arrays.sort(coins);
        while (amount != 0) {
            for (int i=coins.length - 1 ; i>=0 ; i--) {
                if (coins[i] <= amount) {
                    amount = amount - coins[i];
                    i++;
                }
            }
        }
        return null;                             // incomplete. need more time to fulfill the method
    }

    /**
     * Quantity of coins with value 1 in this bunch.
     * @return Quantity of coins with value 1 in this bunch.
     */
    public int getOnes() {
        int counter = 0;             // why variable Counter is underlined everywhere?
        for(int i = 0; i<coins.length; i++) {
            if(coins[i] == 1) {
                counter+=1;
            }
        }
        return counter;
    }

    /**
     *  Quantity of coins with value 2 in this bunch.
     *  @return Quantity of coins with value 2 in this bunch.
     */
    public int getTwos() {
        int counter = 0;
        for(int i = 0; i<coins.length; i++) {
            if(coins[i] == 2) {
                counter+=1;
            }
        }
        return counter;
    }

    /**
     *  Quantity of coins with value 5 in this bunch.
     *  @return Quantity of coins with value 5 in this bunch.
     */
    public int getFives() {
        int counter = 0;
        for(int i = 0; i<coins.length; i++) {
            if(coins[i] == 5) {
                counter+=1;
            }
        }
        return counter;
    }

    /**
     * Quantity of coins with value 10 in this bunch.
     * @return Quantity of coins with value 10 in this bunch.
     */
    public int getTens() {
        int counter = 0;
        for(int i = 0; i<coins.length; i++) {
            if(coins[i] == 10) {
                counter+=1;
            }
        }
        return counter;
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
