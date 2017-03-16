//David Gilmore CS202 Progarm #4 WINTER 17
//this is a derived class from housing that holds an apartment type
//the apartment type has a few fields that are their own apart from the other types.
//This apartment has an htype which helps tell between the house and apartment types. O for apartment
//and 1 for house.
package com.company;

/**
 * Created by dwg2 on 3/9/17.
 */
//apartment class is derived from the houing baseclass
public class Apartment extends Housing {

    //data memebers
    protected int floorNumber;
    protected int elevatorCode;
    protected String notes;
    protected int h_type;

    //argument constructor
    public Apartment(int id, String city, String streetAddress, String zip, String ownerFirst, String ownerLast,
                     int pricePerNight, int bedsAvailable, int guestsAllowed, int floorNumber, int elevatorCode,
                     String notes, int h_type) {
         //calls to base class constructor
        super(id, city, streetAddress, zip, ownerFirst, ownerLast, pricePerNight, bedsAvailable, guestsAllowed);
        this.floorNumber = floorNumber;
        this.elevatorCode = elevatorCode;
        this.notes = notes;
        this.h_type = h_type;

    }
    //default constructor
    public Apartment() {

        floorNumber = 0;
        elevatorCode = 0;
        notes = null;
        h_type = 0;
    }
     //copy constructor
    public Apartment(Apartment rental){

        super(rental.id, rental.city, rental.streetAddress, rental.zip, rental.ownerFirst,
                rental.ownerLast, rental.pricePerNight, rental.bedsAvailable, rental.guestsAllowed);
        this.floorNumber = rental.floorNumber;
        this.elevatorCode = rental.elevatorCode;
        this.notes = rental.notes;
        this.h_type = rental.h_type;
    }
    //displays single apartment object
    void display() {

        super.display();
        System.out.println("Floor Number: " + floorNumber);
        System.out.println("Elevator Code: " + elevatorCode);
        System.out.println("Apartment Notes: " + notes);
    }
    //returns objects type
    int getH_type() {
        return h_type;
    }
}
