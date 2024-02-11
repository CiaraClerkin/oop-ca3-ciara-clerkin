import java.util.Stack;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class NestedHTMLTags {
    public static void main(String[] args) throws IOException {
        Scanner html = new Scanner(new File("nested.html"));
        //Stack<String> openers = new Stack<>();
        Stack<String> tags = new Stack<>();
        //Stack<String> closers = new Stack<>();
        boolean correct = false;

        while (html.hasNext()) {
            String tag = html.next();
            if (!tag.contains("/")) {
                tags.push(tag);
            }
            else {
                if (tags.peek().equals("<" + tag.substring(2))) {
                    tags.pop();
                }
            }
        }

        if (tags.isEmpty()) {
            correct = true;
        }

        //System.out.println(openers);
        //System.out.println(closers);
        System.out.println(tags);
        System.out.println("Nested Correctly?\t- " + correct);

        /*for (int i = 0; i < tags.size(); i++) {
            String tag = tags.pop();
            //System.out.println(tags.peek() + "\t" + "</" + tag.substring(2));
            if (!(tags.peek().equals("<" + tag.substring(2)))) {

            }

            // openers stack
            // once an opener is closed it is removed from stack

            /*if (tag.contains("/")) {
                closers.push(tag);
            }
            else {

            }*/

            /*if (!tags.peek().contains("/")) {
                if (!(tags.peek().equals("<" + tag.substring(2)))) {
                    correct = false;
                    i = tags.size();
                }
            }*/

            //ending tag of child should be before the parent's


            /*for (int j = 0; i < tags.size(); i++) {

            }*/
        //}

        //add them to a stack, separated by spaces
    }

}
