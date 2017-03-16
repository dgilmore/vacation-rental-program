//David Gilmore CS202 Program #4 Winter 17
//This is my driver file. It creates an instance of my controller class
//calls the start and end program methods. The start method creates the controllers tree
//fills the tree from the file. Then it runs the user menu method which controls how the user interacts with
//the program. The end program function just sets the tree's root to null and lets the garbage collection clear the data.
package com.company;

public class Main {

    public static void main(String[] args) {



        Controller my_c = new Controller();
        my_c.start_program();
        my_c.end_program();


    }
}
