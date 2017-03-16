//David Gilmore CS202 Program #4 WINTER 17
//This is one of the derived class for housing, HOUSE. This class has everything
//housing does but has a few more specific fields for a house, such as if it has a pool,
//a bbq and it's tvcode. The constructors for this class must invoke the base classes constructor
//using the super keyword. Theses information classes become stored in bst nodes and but in a tree
//based on which city they are located. The out b-tree is organized by city and can search for a city
//very quickly and now find a particular listing by id very fast.
package com.company;

/**
 * Created by dwg2 on 3/9/17.
 */
public class House extends Housing {

    protected boolean hasPool;
    protected boolean hasBbq;
    protected int tvCode;
    protected int h_type;

    //argument constructor. The list got pretty long
    public House(int id, String city, String streetAddress, String zip, String ownerFirst, String ownerLast,
                 int pricePerNight, int bedsAvailable, int guestsAllowed, boolean hasPool, boolean hasBbq,
                 int tvCode, int h_type) {
         //call to the base class constructor
        super(id, city, streetAddress, zip, ownerFirst, ownerLast, pricePerNight, bedsAvailable, guestsAllowed);
        this.hasPool = hasPool;
        this.hasBbq = hasBbq;
        this.tvCode = tvCode;
        this.h_type = h_type;
    }
    //the default constructor
    public House() {

        hasPool = false;
        hasBbq = false;
        tvCode = 0;
        h_type = 0;
    }
    //copy constructor
    public House(House rental){

        super(rental.id, rental.city, rental.streetAddress, rental.zip, rental.ownerFirst,
                rental.ownerLast, rental.pricePerNight, rental.bedsAvailable, rental.guestsAllowed);
        this.hasPool = rental.hasPool;
        this.hasBbq = rental.hasBbq;
        this.tvCode = rental.tvCode;
        this.h_type = rental.h_type;
    }
   //displays a single housing object, calls the super class to display their own data.
    void display() {
        super.display();
        if (hasPool) {
            System.out.println("Pool: YES");
        } else {
            System.out.println("Pool:  NO");
        }
        if (hasBbq) {
            System.out.println("BBQ:  YES");
        } else {
            System.out.println("BBQ:  NO");
        }
        System.out.println("TV Code: " + tvCode);

    }
// returns the housing type. 0 for apartment 1 for house
    int getH_type() {
        return h_type;
    }
}
