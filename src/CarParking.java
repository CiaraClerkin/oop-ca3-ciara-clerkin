import java.util.Stack;
import java.util.Scanner;

public class CarParking {
    public static void main(String[] args) {
        Stack<Integer> driveway = new Stack<Integer>();
        Stack<Integer> street = new Stack<Integer>();
        Scanner keyboard = new Scanner(System.in);

        System.out.printf("Enter: ");
        int choice = keyboard.nextInt();

        while (choice != 0) {
            if (choice > 0) {
                driveway.push(choice);
            }
            else {
                int lastIndexD = driveway.indexOf(driveway.lastElement());
                System.out.println(lastIndexD);

                System.out.println("\n-----------Getting the cars out----------------\n");
                // Getting the cars out
                //driveway.indexOf(-choice)
                int choiceIndex = driveway.indexOf(-choice);
                for (int i = lastIndexD; i > choiceIndex-1; i--) {
                    //driveway.pop();
                    //int pre = lastElementD+(i-lastIndexD);
                    //driveway.push(-driveway.elementAt(i));
                    //street.push(driveway.elementAt(i));
                    street.push(driveway.pop());

                    System.out.println("Driveway: " + driveway);
                    System.out.println("Street: " + street);
                    System.out.println();
                }


                System.out.println("\n----------------Going Back---------------------\n");
                // Putting the temporarily removed cars back in
                int lastIndexS = street.indexOf(street.lastElement())-1; //ignoring true last because that's not going back

                street.pop();

                for (int i = lastIndexS; i >= 0 ; i--) {

                    //street.push(-street.elementAt(i));
                    //driveway.push(street.elementAt(i));
                    //if (i == lastIndexS) {
                        //street.pop();
                    //}
                    driveway.push(street.pop());

                    System.out.println("Driveway: " + driveway);
                    System.out.println("Street: " + street);
                    System.out.println();
                }
            }
            System.out.println("Driveway: " + driveway);
            System.out.println("Street: " + street);

            System.out.printf("\nEnter: ");
            choice = keyboard.nextInt();
            System.out.println();
        }

        //tested with 1, 2, 3, 4 and 2, 4, 6 8

        // example, there are 4 cars. car 2 wants to leave, but is blocked by 3 and 4
        /*driveway.push(1);
        driveway.push(2);
        driveway.push(3);
        driveway.push(4);
        System.out.println(driveway);

        System.out.println();

        // 4 moves to street
        driveway.push(-4);
        street.push(4);
        System.out.println(driveway);
        System.out.println(street);

        // 3 moves to street
        driveway.push(-3);
        street.push(3);
        System.out.println(driveway);
        System.out.println(street);

        // 2 leaves and assuming that they stay on the street
        driveway.push(-2);
        street.push(2);
        System.out.println(driveway);
        System.out.println(street);

        // 3 drives back
        street.push(-3);
        driveway.push(3);
        System.out.println(driveway);
        System.out.println(street);

        // 4 drives back
        street.push(-4);
        driveway.push(4);
        System.out.println(driveway);
        System.out.println(street); */
    }
}
