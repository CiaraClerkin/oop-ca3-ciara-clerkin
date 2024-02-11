import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class FloodFill {
    //Stack<>
    //Pair<Integer, Integer> rowColumn = new Pair();

    // tried to make it universal, but it only works when rows and columns are the same number
    public static int rows = 10;
    public static int columns = 10;

    public static void main(String[] args) {
        ArrayList<Integer> rowColumn = new ArrayList<>();
        Stack<Pair> filled = new Stack<>();
        //Pair<Integer, Integer> coord = new Pair<>();
        Scanner keyboard = new Scanner(System.in);

        // the 10x10 array is filled with 0's
        // added an extra row, to avoid problems with starting from 10th row.
        for (int i = 0; i < rows+1; i++) {
            for (int j = 0; j < columns; j++) {
                rowColumn.add(0);
            }
        }

        // user inputs row and column and it is put into the stack
        System.out.printf("Row: ");
        int row = keyboard.nextInt();
        //if (row == columns) row--; // This fixes the 10th row not working. I'm not entirely sure why.

        System.out.printf("Column: ");
        int column = keyboard.nextInt()-1; // offset for the for loop

        filled.push(new Pair(row, column));


        // we loop until the stack is empty and i our count that shows the order the pixels are filled
        //System.out.println(9*columns + 10);
        int i = 0;
        while (!filled.empty()) {
            Pair pair = filled.pop();
            int x = pair.row;
            int y = pair.column;
            //System.out.println(x + "\t" + y);
            //System.out.println("Index Total: " + (rowColumn.size() - 1));
            //System.out.println("Current Index: " + x*(columns) + y);

            if (rowColumn.get(x*columns + y) == 0) {
                rowColumn.set(x*columns + y, i);
                filled.push(new Pair(x, y));

                // N, S, E and W coords and not pushing them when they don't exist
                if (y > 0) filled.push(new Pair(x, y - 1));
                if (x < columns-1) filled.push(new Pair(x + 1, y));
                if (y < rows-1) filled.push(new Pair(x, y + 1));
                if (x > 0) filled.push(new Pair(x - 1, y));
                //if (filled.empty()) {//}

                i++;
            }

            //System.out.println(filled.lastElement().row + "\t" + filled.lastElement().column);
        }

        //for (int i = 0; i < rowColumn.size(); i++) {

        // extra row is removed
        for (int j = ((rows+1)*columns) - 1; j > (rows*columns) - 1; j--) {
            rowColumn.remove(j);
        }
        System.out.println("\n"+rowColumn.toString() + "\n");
        outputRC(rowColumn);
    }

    public static void outputRC(ArrayList<Integer> al) {
        for (int i = 0; i < al.size(); i++) {
            System.out.printf(al.get(i) + "\t");
            if ((i+1) % columns == 0 && i+1 >= columns) {
                System.out.println();
            }
        }
    }
}

//https://stackoverflow.com/questions/63216981/implementing-stack-with-key-value
//wasn't sure what was meant by "simple Pair class"
class Pair {
    int row;
    int column;
    public Pair(int row, int column) {
        this.row = row;
        this.column = column;
    }
}

//https://www.youtube.com/watch?v=tZgR3_N1JD8
/*class Pair<row, column> {
    public row element1;
    public column element2;
}*/

