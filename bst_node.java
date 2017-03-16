//David Gilmore CS202 Program #4 WINTER 17
//This is my bst_node file. The bst node holds the data for
//a listing such as name, address, id, housing type etc. The bst tree is held within a bigger
//B-tree that is organized by city. This node file has a few different constructors for different
//data types for my dynamic binding.
package com.company;

/**
 * Created by dwg2 on 3/9/17.
 */

//Bst nodes class has a Housing object and left and right nodes
public class bst_node {

    protected Housing myRental;
    protected bst_node left, right;
   //default constructor
    public bst_node() {

        left = null;
        right = null;
    }
   //constructor to take in a housing object and set the node to it
    public bst_node(Housing rental){

        this.myRental = rental;
        right = null;
        left = null;

    }
    //constructor to take a house object and set the nodes to it
    public bst_node(House rental){

        myRental = rental;
        right = null;
        left = null;
    }
    //sets the nodes right pointer to value passed in
    public void setRight(bst_node r_node){

        right = r_node;
    }
    //sets the nodes left pointer to value passed in
    public void setLeft(bst_node l_node){

        left = l_node;
    }
    //returns the nodes right pointer
    public bst_node getRight(){

        return right;
    }
    //returns the nodes left pointer
    public bst_node getLeft(){

        return left;
    }

    //displays a single houssing object
    public void displayHousing(){

        myRental.display();
    }

     //returns the id stored in the housing object
    public int getId(){

        return myRental.id;
    }

    //returns the type that is stored in object
    public int getType()
    {
        return myRental.getH_type();
    }
}


