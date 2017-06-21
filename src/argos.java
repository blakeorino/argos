/**
 * Blake Pedrini 2016
 * All rights reserved, Accepts no liability
 * If you do something really cool, let me know.
 */

import java.util.Scanner;

public class argos {
    private static map WORLD;
    public static void main (String[] args)
    {
        //building up a map that is stored for the reference to what is
        //around them.
        WORLD = new map(10);

        System.out.println(WORLD.at_loc(5,5));

        /*
        JFrame frame = new JFrame("Argos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        */


        System.out.println("Hello World");
        creature carrot = new creature();
        System.out.println(carrot.get_name());
        creature less_carrot = new creature();

        carrot.set_name("Bobby doLittle");
        System.out.println(carrot.get_name());
        System.out.println(less_carrot.get_name());

        while (true) {
            console_parse();
        }
    }
    public static void console_parse() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(input);
        if ( input.equals("display") || input.equals("d")) {
            for ( int i = 1; i >= -1; i-- ) {
                System.out.println(WORLD.build_line( 3, i ));
            }
        }
        else if ( input.equals("exit") ) {
            System.exit(0);
        }
        else {
            //this is the mapping to the logical commands in the map
            // class. W/A/S/D -> up/down/left/right
            if (input.equals("w")) {
                WORLD.move("up");
            } else if (input.equals("s")) {
                WORLD.move("down");
            } else if (input.equals("a")) {
                WORLD.move("left");
            } else if (input.equals("d")) {
                WORLD.move("right");
            }
            System.out.println(WORLD.get_x() + ", " + WORLD.get_y());
            System.out.println(WORLD.at_loc(WORLD.get_x(), WORLD.get_y()));
        }
    }
}