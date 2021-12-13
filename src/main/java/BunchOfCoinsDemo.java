public class BunchOfCoinsDemo {
    public static void main(String[] args) {
        BunchOfCoins coins = new BunchOfCoins();
        coins.push(1);
        coins.push(1);
        coins.push(1);
        coins.push(2);
        coins.push(5);
        coins.push(5);
        coins.push(10);


        //BunchOfCoins other = new BunchOfCoins();



        System.out.println("coins.getOnes() = " + coins.getOnes());
        System.out.println("coins.getTwos() = " + coins.getTwos());
        System.out.println("coins.getFives() = " + coins.getFives());
        System.out.println("coins.getTens() = " + coins.getTens());

    }
}
