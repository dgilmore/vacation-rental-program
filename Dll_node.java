//David Gilmore CS202 Program #5 WINTER 17
//Dll node contains an array of bst_node objects, bst node objects contain housing objects. I choose to
//store bst_nodes because that is what my b_tree returns when an object is searched for. The dll_node class has also
//a string field for city, so that all listings from a city are stored in the same array. This class contains all of
//the functions needed to work on the nodes array including displaying, removing, adding and checking index, incrementing
//and decrementing

package com.company;

/**
 * Created by dwg2 on 3/13/17.
 */

//dll node class stores an array of bst_nodes which contain housing listings
public class Dll_node {

    private bst_node arr[];
    private String city;
    private Dll_node next;
    private Dll_node prev;
    private int index;

    //default constructor
    public Dll_node(){

        this.arr = null;
        this.city = null;
        this.next = null;
        this.prev = null;
        this.index = 0;
    }

    //argument constructor with a listing and the next and prev nodes sent as arguments
    public Dll_node(bst_node listing, Dll_node n, Dll_node p){

        this.city = listing.myRental.get_city();
        this.arr = new bst_node[20];
        this.arr[index] = listing;
        ++this.index;
        this.next = n;
        this.prev = p;

    }

    //returns the nodes city field for comparisons
    public String getCity(){

        return this.city;
    }

    //returns the nodes next
    public Dll_node getNext(){

        return this.next;
    }

    //returns the nodes prev
    public Dll_node getPrev(){

        return this.prev;
    }

    //sets the current nodes next
    public void setNext(Dll_node n){

        this.next = n;
    }

     //sets the current nodes prev
    public void setPrev(Dll_node p){

        this.prev = p;
    }

    //inserts a bst obj into the array at correct position
    public void insertArray(bst_node ins){

        this.arr[index] = ins;
        ++this.index;
    }

    //returns the current nodes arrays current index
    public int getIndex(){

        return this.index;
    }

    //incements he current nodes current index
    private void incrementIndex(){

        ++this.index;
    }

    private void decrementIndex(){

        --this.index;
    }

    //displays current nodes array's contents, wrapper
    public void arr_display(){

        int i = 0;
        arr_display(arr, i);
    }
     //private recursive call
    private void arr_display(bst_node arr[], int i){

        if(i >= getIndex()){
            return;
        }

        arr[i].displayHousing();
        System.out.println("");

        arr_display(arr, ++i);


    }
    // returns boolean for if the id and the index sent as an argument are equal
    public boolean getArrIndex(int id, int i){

        if(arr[i].getId() == id){
            return true;
        }
        else
            return false;
    }

    //remove function copies the arr without the object seached for
    protected bst_node[] removeIndex(int i){

        bst_node[] copy = new bst_node[arr.length-1];
        System.arraycopy(arr, 0, copy, 0, i);
        System.arraycopy(arr, i+1, copy, i, arr.length-i-1);
        decrementIndex();
        return copy;

    }

    protected void setArr(bst_node[] arr1){

        arr = arr1;
    }

}
