//My abstract base class is the housing class. I have two other classes that derive from this class.
//The housing class stores informations for the listing. The two classes that are derived from it are the apartment
//and house classes. The housing class is abstract and has the abstract method getH_type. The larger program is a
//database for short term rentals in different cities. A user can search, add, or see all of the listings in the
//database. The data structurs are a b-tree organized by city and a inner bst that all are in the same city, organized
//by housing id. There is a h_type to tell between house and apartment.
package com.company;

/**
 * Created by dwg2 on 3/5/17.
 */
abstract class Housing {
    //base info for a rental unit
    protected int id;
    protected String city;
    protected String streetAddress;
    protected String zip;
    protected String ownerFirst;
    protected String ownerLast;
    protected int pricePerNight;
    protected int bedsAvailable;
    protected int guestsAllowed;
    //to tell between apartment and house types of housing objects
    abstract int getH_type();
    //constructor
    public Housing(int id, String city, String streetAddress, String zip, String ownerFirst, String ownerLast,
                   int pricePerNight, int bedsAvailable, int guestsAllowed)
    {
        this.id = id;
        this.city = city;
        this.streetAddress = streetAddress;
        this.zip = zip;
        this.ownerFirst = ownerFirst;
        this.ownerLast = ownerLast;
        this.pricePerNight = pricePerNight;
        this.bedsAvailable = bedsAvailable;
        this.guestsAllowed = guestsAllowed;
    }
    //default constructor
    public Housing(){

        this.id = 0;
        this.city = null;
        this.streetAddress = null;
        this.zip = null;
        this.ownerFirst = null;
        this.ownerLast = null;
        this.pricePerNight = 0;
        this.bedsAvailable = 0;
        this.guestsAllowed = 0;
    }
      //displays a single object
     void display(){

        System.out.println("Housing Id: " + id );
        System.out.println("City: " + city);
        System.out.println("Street Address: " + streetAddress);
        System.out.println("Zip Code: " + zip);
        System.out.println("Owner: " + ownerFirst + " " + ownerLast);
        System.out.println("Price Per Night: $" + pricePerNight);
        System.out.println("Beds Available: " + bedsAvailable);
        System.out.println("Guests Allowed: " + guestsAllowed);
     }
    //returns a objects city
     public String get_city() {
         return city;
     }
     //returns the objects id
     public int getId()
     {
         return id;
     }
}





