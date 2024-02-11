import java.util.*;

public class StockSharesTaxCalculation {
    public static void main(String[] args) {
        Queue<Block> shares = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        String[] command = {""};
        int quantity;
        double price;
        double profit = 0;


        //Let's assume that we are coding only for this example?
        //buy 2 share block things, sell 1 share block thing that contains first buy block and half of second buy block?
        //price seems to be decided by program rather than user, and seemingly

        //1200/300 = 4
        //1000/4 = 250
        //ratio is 4??

        while (!command[0].equals("quit")) {
            System.out.printf("Enter command: ");
            command = in.nextLine().split(" ");


            if (command[0].equals("buy")) {
                quantity = Integer.valueOf(command[1]);
                price = Integer.valueOf(command[2]);

                shares.add(new Block(quantity, price));
            }
            else if (command[0].equals("sell")) {
                quantity = Integer.valueOf(command[1]);
                int quantityRecord = 0;
                //price = Integer.valueOf(command[2]);

                for (int i = 0; i < shares.size()+1; i++) {
                    //quantityRecord += shares.peek().getQuantity();
                    //if (quantityRecord <= quantity) {
                    Block currentShare = shares.remove();
                    profit += (currentShare.getQuantity() * currentShare.getPrice()) / 4;
                        //}
                }

                // quantities shares
                // variable quanity
                // loop through them, keep an added track record of previous quantities


                //300 for first, 250 for second
                /*if () {

                }*/

                //shares.add(new Block(quantity, price));
            }

            // show user their profits after each command
            /*double profit = 0;

            for (int i = 0; i < shares.size(); i++) {
                //profit += ;
            }*/

            //System.out.println("Profit: " + profit);
            System.out.println(profit);
        }
    }
}

/*class Block {
    private int quantity;
    private double price;

    public Block(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}*/
