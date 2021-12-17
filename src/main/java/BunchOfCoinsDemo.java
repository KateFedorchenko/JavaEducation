public class BunchOfCoinsDemo {
    public static void main(String[] args) {
        BunchOfCoins coins = new BunchOfCoins(2,2,3,0);
        BunchOfCoins other = new BunchOfCoins(1,1,1,1);
        coins.combineWithOther(other);
        coins.greedyWithdrawal(5);
        coins.greedyWithdrawal(0);





    }
}
