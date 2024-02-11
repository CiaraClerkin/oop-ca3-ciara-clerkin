import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class AirportFlights {
    public static void main(String[] args) {
        Queue<String> takeoff = new LinkedList<>();
        Queue<String> land = new LinkedList<>();
        Scanner keyboard = new Scanner(System.in);
        String command = "";
        //String current = "";
        String prevCommand = "";

        while (!command.equals("quit")) {
            System.out.printf("Enter command: ");
            command = keyboard.nextLine();
            prevCommand = command;
            //System.out.println(command);

            if (command.contains("takeoff")) {
                takeoff.add(command.substring(8));
                System.out.println("Flight added to takeoff");
                prevCommand = command;
                //current = "takeoff";
            } else if (command.contains("land")) {
                land.add(command.substring(5));
                System.out.println("Flight added to land");
                prevCommand = command;
                //current = "land";
            } else if (command.contains("next")) {
                //current equals not working

                if (!land.isEmpty()) {
                    System.out.println("Land: " + land.remove());
                } else {
                    System.out.println("Takeoff: " + takeoff.remove());
                }

                /*if (prevCommand == "next") {
                    if (!land.isEmpty()) {
                        System.out.println("Land: " + land.remove());
                    } else {
                        System.out.println("Takeoff: " + takeoff.remove());
                    }
                }*/
                // WHAT THE HELL DOES CURRENT FLIGHT MEAN??????
                //else {
                    /*if (current.equals("takeoff")) {
                        System.out.println("Takeoff: " + takeoff.remove());
                    } else if (current.equals("land")) {
                        System.out.println("Land: " + land.remove());
                    }*/
                }

                //prevCommand = "next";
            }

            System.out.println(takeoff);
            System.out.println(land);
            //System.out.println(current);
        }

        /*switch(command) {
            case "takeoff":
                break;
            case "flightSymbol":
                break;
            case "land":
                break;
            case "next":
                break;
            case "quit":
                break;
        }*/
    }
