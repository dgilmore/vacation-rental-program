//David Gilmore CS202 Program #4 WINTER 17
// This is my controller class. It contains an b_tree object
//which will holds trees in each of it's node organized by city. The controller
//create the tree and calls the trees function to read from file to fill the list. Then the controller
//has the user interface where the user can decide to search for a city and get all the listings in that city
//a user can add their listing to a city and a user can see all of the listings in the database.
package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dwg2 on 3/11/17.
 */
//the controller class has a btree object and
    //calls the functions to load from file, user interface and dstroy list
public class Controller {
    //btree object
    protected B_tree controller_tree;
    protected Dll_adt controller_dll;

    //constructor
    public Controller(){
        controller_tree = null;
    }
    //creates the instances that are needed
    public void start_program(){

        controller_tree = new B_tree();
        controller_dll = new Dll_adt();
        controller_tree.readFromFile();
        run_menu();

    }
    //kills list and sends a end program message
    public void end_program()
    {
        System.out.println("Program Terminated Succesfully");
        controller_tree.nowEmpty();
        controller_dll.destroyList();
    }
    // this is the user interface
    public void run_menu(){
        //all the variables needs to read in from user and
        //store the correct type of housing listing
        String response = "Y";
        String answer;
        String city;
        String first;
        String last;
        String address;
        String zip;
        int price;
        int beds;
        int guests;
        int floor;
        int elevator;
        String notes;
        boolean pool;
        boolean bbq;
        int tvCode;
        int h_type;
        int id;

        System.out.println("WELCOME TO THE TRAVEL AND STAY NIGHTLY OVERSTAY LISTING SYSTEM: ");
        BufferedReader inData;
        inData = new BufferedReader(new InputStreamReader(System.in));
          //loop to keep displaying and letting user do things until they are done
        while(response.equals("Y")){

            System.out.println("MENU: ENTER THE OPTIONS YOU'D LIKE TO VIEW");
            System.out.println("Press S: Search for a city and it's listings");
            System.out.println("Press A: To add your listing our Database");
            System.out.println("Press D: To see all of our Listings in all cities");
            System.out.println("Press L: to add a listing to your schedule");
            System.out.println("Press R: to remove a listing from your schedule");
            System.out.println("Press C: to display your current schedule");
            System.out.println("Press M: to see your schedule by city");

            try {
                answer = inData.readLine();
                answer = answer.toUpperCase();
                 //search by city
                if(answer.equals("S")){

                    System.out.println("You've chosen to search our listing by city:");
                    System.out.println("Please Enter the name a of city you'd like to see listings for: ");
                    city = inData.readLine();
                    bst city_search = controller_tree.retrieve_all(city);
                    //city_search.display();
                }//add a listing
                if(answer.equals("A")){

                    System.out.println("You've chosen to add a new listing, We are gonna need some info:");
                    System.out.println("What city is your listing?");
                    city = inData.readLine();
                    System.out.println("What is your first name?");
                    first = inData.readLine();
                    System.out.println("Last name?");
                    last = inData.readLine();
                    System.out.println("What is the listing's address:");
                    address = inData.readLine();
                    System.out.println("What is the zip for the listing");
                    zip = inData.readLine();
                    System.out.println("What is the price per night for this listing?");
                    price = Integer.parseInt(inData.readLine());
                    System.out.println("How many beds are available at this listing?");
                    beds = Integer.parseInt(inData.readLine());
                    System.out.println("Maximum number of guests allow over night?");
                    guests = Integer.parseInt(inData.readLine());
                    System.out.println("Press 0 if this is an apartment or 1 for a entire house: ");
                    h_type = Integer.parseInt(inData.readLine());
                     // if type is apartment
                    if(h_type == 0){

                        System.out.println("What floor is the apartment on?");
                        floor = Integer.parseInt(inData.readLine());
                        System.out.println("What is the elevator code?");
                        elevator = Integer.parseInt(inData.readLine());
                        System.out.println("Any additional notes?");
                        notes = inData.readLine();
                        System.out.println("Finally, please choose an id number. 5 digits, start with 1 for Apartment" +
                                "or 2 for an entire house");
                        id = Integer.parseInt(inData.readLine());
                        Apartment my_a = new Apartment(id, city, address, zip, first, last, price, beds, guests, floor,
                                elevator, notes, h_type);
                        controller_tree.insert(my_a);
                    }//if type is house
                    else {

                        System.out.println("Does this listing have a pool? Enter true or false");
                        pool = Boolean.parseBoolean(inData.readLine());
                        System.out.println("Does this listing have a bbq? Enter true or false");
                        bbq = Boolean.parseBoolean(inData.readLine());
                        System.out.println("What is the TV code for this listing");
                        tvCode = Integer.parseInt(inData.readLine());
                        System.out.println("Finally, please choose an id number. 5 digits, start with 1 for Apartment" +
                                "or 2 for an entire house");
                        id = Integer.parseInt(inData.readLine());

                        House my_h = new House(id, city, address, zip, first, last, price, beds, guests, pool, bbq, tvCode, h_type);
                        controller_tree.insert(my_h);
                    }



                }
                 //see all
                if(answer.equals("D")){

                    controller_tree.display();
                }
                //add a listing from tree database to dll of user schedule
                if(answer.equals("L")){
                    bst_node my_node = new bst_node();
                    System.out.println("Enter the city you want to add to your stay");
                    city = inData.readLine();
                    System.out.println("Enter the id of the listing you want to add");
                    id = Integer.parseInt(inData.readLine());
                    my_node = controller_tree.search(city,id);
                     //checking for null return type to avoid nullpointerexception
                    if(my_node.myRental == null){
                        System.out.print("ERROR: That ID or CITY was not found in our Database!");
                    }
                    else {
                        //if found insert into dll
                        controller_dll.insert(my_node);
                        System.out.println("New Stay added! This is your updated schedule");
                        controller_dll.display(); // display current schedule
                    }
                }
                 //if a user wants to remove a listing from their schedule
                if(answer.equals("R")){

                    System.out.println("Please enter the city that you want to update your schedule");
                    city = inData.readLine();
                    System.out.println("Please enter the id of the listing you want to remove");
                    id = Integer.parseInt(inData.readLine());
                    controller_dll.remove(city,id);
                    System.out.println("Your schedule has been updated! This is your new schedule:");
                    controller_dll.display();
                }
                 //if user wants to display their entire schedule
                if(answer.equals("C")){

                    controller_dll.display();
                }
                //if user wants to see their schedule by city
                if(answer.equals("M")){

                    System.out.println("Enter the city that you would like to see your schedule for");
                    city = inData.readLine();
                    controller_dll.search(city);
                }

                System.out.println("Would you like to see the menu again?");
                response = inData.readLine();
                response = response.toUpperCase();


            }catch (IOException e){}
        }
    }
}
