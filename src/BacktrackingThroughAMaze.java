import java.util.HashMap;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
/**
 *  Name:
 *  Class Group:
 */

/*
Direction enum used to indicate direction.
 */
enum DIRECTION {NORTH, SOUTH,EAST,WEST};

public class BacktrackingThroughAMaze
{
    public static void main(String[] args) {
        int[][] maze = {{1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 0, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}};
        //char[][] maze = {{'▪'}, {}, {}, {}, {}, {}, {}, {}};
        //char[][] maze = new char[8][8];
        //Stack<HashMap<Pair, Integer>> memory = new Stack<HashMap<Pair, Integer>>();
        Stack<Pair> coords = new Stack<Pair>();
        Stack<DIRECTION> memory = new Stack<DIRECTION>();
        //Stack<HashMap<Pair, DIRECTION>> memory = new Stack<HashMap<Pair, DIRECTION>>();

        int x = 4;
        int y = 3;

        maze[y][x] = 2;

        //coords is to remember previous intersection
        coords.push(new Pair(y, x));

        if (maze[y+1][x] == 0) {
            memory.push(DIRECTION.NORTH);
            //memory.push(new HashMap<new Pair(y, x), DIRECTION.SOUTH>());
        }
        if (maze[y][x-1] == 0) {
            memory.push(DIRECTION.WEST);
        }
        if (maze[y][x+1] == 0) {
            memory.push(DIRECTION.EAST);
        }
        if (maze[y-1][x] == 0) {
            memory.push(DIRECTION.NORTH);
        }

        //memory.push(new HashMap<new Pair(3, 4), DIRECTION.NORTH>);

        display(maze);
        //these ones are to put you back to where you were before inside of the wall
        int prevX = x;
        int prevY = y;
        //DIRECTION poppedPath = memory.pop();


        DIRECTION poppedPath = memory.pop();

        while (!memory.isEmpty()) {
            //solve(x, y, )

            //int mazeNum = 0;
            maze[y][x] = 0;

            //DIRECTION poppedPath = memory.pop();

            //System.out.println("HI");

            System.out.println(poppedPath);
            System.out.println(memory);

            prevX = x;
            prevY = y;

            switch (poppedPath) {
                case NORTH -> y--;
                case EAST -> x++;
                case SOUTH -> y++;
                case WEST -> x--;
            }

            //x = prevX;
            //y = prevY;

            /*if (memory.peek() == poppedPath) {
                memory.pop();
            }*/

            if (maze[y][x] == 1) {
                x = prevX;
                y = prevY;

                poppedPath = memory.pop();

                if (maze[y-1][x] == 0) {
                    memory.push(DIRECTION.NORTH);
                }
                if (maze[y][x-1] == 0) {
                    memory.push(DIRECTION.WEST);
                }
                if (maze[y+1][x] == 0) {
                    memory.push(DIRECTION.SOUTH);
                }
                if (maze[y][x+1] == 0) {
                    memory.push(DIRECTION.EAST);
                }

                if (poppedPath != memory.peek()) {
                    coords.push(new Pair(y, x));
                }
            }

            maze[y][x] = 2;

            if (x == 7 || x == 0 || y == 0 || y == 7 ) {
                while (!memory.isEmpty()) {
                    memory.pop();
                }
            }

            display(maze);
        }
        System.out.println("\nCongratulation! You have exited the maze!!!!!");
    }

     /*if (maze[x][y-1] == 0) {
                memory.pop();
                y--;
            }
            else if (maze[x-1][y] == 0) {
                memory.pop();
                x--;
            }
            else if (maze[x][y+1] == 0) {
                memory.pop();
                y++;
            }
            else if (maze[x+1][y] == 0) {
                memory.pop();
                x++;
            }*/

    public static void display(int[][] image)
    {
        for (int x = 0; x < image.length; x++)
        {
            for (int y = 0; y < image[0].length; y++)
            {
                System.out.printf("%4d", image[x][y]);
            }
            System.out.println();
        }
    }


    public static void solve(int x, int y, DIRECTION dir)
    {

    }
}
