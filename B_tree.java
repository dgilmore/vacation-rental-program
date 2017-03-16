//David Gilmore CS202 Program #4 WINTER 17
//THis is the balanced tree class file. This data structure
//organizes nodes by city and each city node has it's own tree of
//housing listings. This class adt can add, search, retreive_all, and make a copy
//of the inner binary search trees.
package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by dwg2 on 3/11/17.
 */

//This is the balanced adt tree class
public class B_tree {
    //root node
    protected B_node b_root;

    //construcotr
    public B_tree(){

        b_root = null;
    }

    //check if the tree is empty
    public boolean isEmpty(){

        return b_root == null;
    }

     //kill the tree
    public void nowEmpty(){

        b_root = null;
    }

    //insert wrapper function
    public void insert(Housing rental){

        b_root = insert(b_root, rental);
    }

    //height function returns the height of a node
    public int height(B_node ht){

        if(ht == null)
            return -1;
        else
            return ht.height;
    }

    //max returns which nodes has a lower height
    public int max(int lhs, int rhs){

        if(rhs > lhs)
            return lhs;
        else
            return rhs;
    }

    //balance calculates the difference between height of two nodes
    public boolean balance(int hl, int hr){

        if((hl - hr) == 2){
            return true;
        }
        else
            return false;
    }

    //private insert function
    private B_node insert(B_node bn, Housing rental){

        if(bn == null){
            //if null add new
            bn = new B_node(rental);
            //return bn;
        }
        //if new obj city equals current root node obj city
        else if(rental.get_city().equals(bn.city)){
            bn.my_tree.insert(rental);
        }
        //directing node in correct direction
        else if(rental.get_city().compareTo(bn.city) < 0){

            bn.left = insert(bn.left, rental);
            if(balance(height(bn.left),height(bn.right))){ // checking to see if needed rotation
                if(rental.get_city().compareTo(bn.city) < 0){
                    bn = rotateLeft(bn); //calling rotate
                }
                else{
                    bn = doubleLeft(bn);
                }
            }
        }
         //directing node object to the right
        else if(rental.get_city().compareTo(bn.city) > 0)
        {
            bn.right = insert(bn.right, rental);
            if(balance(height(bn.right),height(bn.left))){
                if(rental.get_city().compareTo(bn.city) > 0){
                    bn = rotateRight(bn);
                }
                else{
                    bn = doubleRight(bn);
                }
            }
        }
        else {
            //setting the nodes heighth
            bn.height = max(height(bn.left), height(bn.right)) + 1;

        }
        return bn;
    }
    //makes the rotation with a nodes right  child
    protected B_node rotateRight(B_node br1){

        B_node br2 = br1.right;
        br1.right = br2.left;
        br2.left = br1;
        br1.height = max(height(br1.left), height(br1.right));
        br2.height = max(height(br2.left), height(br2.right));
        return br2;

    }
     //makes a rotation with a nodes left child
    protected B_node rotateLeft(B_node br1){

        B_node br2 = br1.left;
        br1.left = br2.right;
        br2.left = br1;
        br1.height = max(height(br1.left), height(br1.right));
        br2.height = max(height(br2.left), height(br2.right));
        return br2;
    }
    //makes a double rotations with a nodes right child
    protected B_node doubleRight(B_node br1){

        br1.right = rotateLeft(br1.right);
        return rotateRight(br1);
    }
     //makes a double rotation to keep node balanced with left child
    protected B_node doubleLeft(B_node br1){

        br1.left = rotateRight(br1.left);
        return rotateLeft(br1);
    }
    //reads in from file
    public void readFromFile() {

        BufferedReader read;

        try { // open a buffer stream
            read = new BufferedReader(new FileReader("/Users/dwg2/IdeaProjects/program4/src/com/company/Listings.txt"));
            String s;//string to hold line
            while ((s = read.readLine()) != null) { // while file still has things to read

                String[] a = s.split(","); // breaks entire line into elements by ,
                int type = Integer.parseInt(a[12]);//checks what h_type the listing is

                if (type == 01) {//apartment listing

                    Apartment my_a = new Apartment(Integer.parseInt(a[0]), a[1], a[2], a[3], a[4], a[5], Integer.parseInt(a[6]),
                            Integer.parseInt(a[7]), Integer.parseInt(a[8]), Integer.parseInt(a[9]),
                            Integer.parseInt(a[10]), a[11], Integer.parseInt(a[12]));

                    insert(my_a);//insert into tree
                }
                else {
                      ///house type
                    House my_h = new House(Integer.parseInt(a[0]), a[1], a[2], a[3], a[4], a[5], Integer.parseInt(a[6]),
                            Integer.parseInt(a[7]), Integer.parseInt(a[8]), Boolean.parseBoolean(a[9]),
                            Boolean.parseBoolean(a[10]), Integer.parseInt(a[11]), Integer.parseInt(a[12]));
                     //insert into tree
                    insert(my_h);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    //display wrapper function
    public void display()
    {
        display(b_root);
    }
    //private display function
    private void display(B_node br){

        if(br == null)
            return;

        br.my_tree.display();

        display(br.right);
        display(br.left);
    }
    //search wrapper function
    public bst_node search(String city, int id){


        return search(b_root, id, city);
    }
    /*priavet search function. searches by city and id
    private bst_node search(B_node bn, int id, String city, bst_node retrieve){

        if(bn == null){

            return null;
        }

        if(city.equals(bn.city)){
            retrieve = bn.my_tree.search(id);
            return retrieve;
        }
        else if(city.compareTo(bn.city) < 0){
            search(bn.left, id, city, retrieve);
        }
        else
            search(bn.right, id, city, retrieve);

        return retrieve;
    }*/

    private bst_node search(B_node B_root, int id, String city){

        B_node current = B_root;
        bst_node my_node = new bst_node();
        while(current!=null){
            if(current.city.equals(city)){
                my_node = current.my_tree.search(id);
                return my_node;
            }else if(current.city.compareTo(city) > 0){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return my_node;
    }

    //retrieve all wrapper funciton
    public bst retrieve_all(String city){

        return retrieve_all(b_root, city);
    }
    //private retrieve all function. Every node in bst that is stored in B-tree by city
    private bst retrieve_all(B_node bn, String city){

        if(bn == null){

            return null;
        }

        if(city.equals(bn.city)){

            //return bn.my_tree.make_copy();
            bn.my_tree.display();
        }
        else if(city.compareTo(bn.city) < 0) {

            retrieve_all(bn.left, city);
        }
        else {
            retrieve_all(bn.right, city);
        }

        return null;

    }
}
