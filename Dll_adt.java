//David Gilmore CS202 Program #5 WINTER 17
//This program is combined with program #4, we use the b-tree of cities, each node having it's own tree
//of housing listings. The user can still search the listing and view the listing by city, then if they see a listing
//they like, they can add it to their schedule. The user needs to know he name of the city and the listings ID. Once
//the user has added listings to their schedule, they can remove a listing from their schedule,
// search their schedule by city and display their entire current schedule. The Dll adt uses the dll_node class to move
//information and keep it sorted.

package com.company;


/**
 * Created by dwg2 on 3/13/17.
 */

//dll class adt controls a users schedule of housing listings
public class Dll_adt {

    Dll_node head;
    Dll_node tail;

     //default constructor
    public Dll_adt(){

        head = null;
        tail = null;
    }

    //insert function takes a bst_node from the b_tree of binary search tress and stores
    //it in an array that is a field in the dll_node.
    public Dll_node insert(bst_node listing){
        //if head is null create new node and set head and tail to it.
        if(head == null){

            head = new Dll_node(listing, null, null);
            tail = head;
            return head;
        }
        else
            return head = insert(listing, head);//recurse to find position

    }

    private Dll_node insert(bst_node listing, Dll_node head){
        //if end of list
        if(head.getNext() == null){

            head.setNext(new Dll_node(listing, null, head));
            tail = head.getNext();
        }
         // if adding at city that has already been created, add to array
        else if(listing.myRental.get_city().equals(head.getCity())){

            head.insertArray(listing);
        } // adding mid list
        else if(listing.myRental.get_city().compareTo(head.getCity()) < 0){

            Dll_node temp = new Dll_node(listing,head,head.getPrev());
            head = temp;
        }
        else{ // recursive call
            head = insert(listing, head.getNext());
        }

        return head;
    }
    //display wrapper function
    public void display(){

        display(head);
    }
    //private display function
    private void display(Dll_node head){

        if(head == null){
            return;
        }

        head.arr_display();//calls a display function defined in dll_node class

        display(head.getNext());
    }
    //wrapper function for remove, arguemnts city name and listing id
    public void remove(String city, int id){

        remove(head, city, id);
    }
     // private function remove using city and id
    private void remove(Dll_node head, String city, int id){

        if(head == null){
            return;
        }
        else if(head.getCity().equals(city)){

            for(int i = 0; i < head.getIndex(); ++i){
                 //if id matches, make new copy of array without given obj
                if(head.getArrIndex(id, i)){

                   head.setArr(head.removeIndex(i));

                }
            }

        }
        else {
            remove(head.getNext(), city, id);
        }
    }
     //wrapper search function
    public void search(String city){

        search(head, city);
    }
    //private search function, finds city user request and displays all listings from that city stored in sched.
    private void search(Dll_node head, String city){

        if(head == null){
            return;
        }

        if(head.getCity().equals(city)){
            head.arr_display();
        }
        else
            search(head.getNext(), city);
    }
   // disconnects the list for garbage collection
    public void destroyList(){
        head = null;
        tail = null;
    }

}
