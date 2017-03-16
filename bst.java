//This is the bst adt class. This class controls the objects created in a hierarchy
//in a binary search tree adt. The class has funtions to add to the tree, search the tree, retreive from the
//tree, make a copy of the tree and I left the readfrom file function in even though the implementation used is in the
//b tree class.
package com.company;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Locale;

/**
 * Created by dwg2 on 3/6/17.
 */
//bst adt class
public class bst {

    //root
    protected bst_node root;

    //constructor
    public bst() {

        root = null;
    }

    //test whether the tree is empty
    public boolean isEmpty() {

        return root == null;
    }

    //kill the tree
    private void remove_all(){
        root = null;
    }

     //wrapper function for inserting into tree
    public void insert(Housing toAdd) {

        root = insert(root, toAdd);
    }

     //private function for insert, takes the root node and the obj to add
    private bst_node insert(bst_node node, Housing toAdd) {

        if (node == null) {
             //if null add a new node
            node = new bst_node(toAdd);
        } else {
            if (node.getId() >= toAdd.getId()) { // decide where in the tree it should go
                node.left = insert(node.left, toAdd);
            } else {
                node.right = insert(node.right, toAdd);
            }
        }
        return node;
    }
    //search function wrapper
    public bst_node search(int id) {

        return search_pr(id, root);
    }

    private bst_node search_pr(int id, bst_node root){

        bst_node current = root;
        while(current!=null){
            if(current.getId()== id){
                //bst_node my_node = new bst_node(current.myRental);
                return current;
            }else if(current.getId() > id){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return current;
    }
     //function to make a copy of the tree
    public bst make_copy(){

        bst copy_tree = new bst();
        return make_copy(copy_tree, root);
    }
    //function to make a copy of a tree
    private bst make_copy(bst ct, bst_node bn){

        if(bn == null){
            return ct;
        }

        ct.insert(bn.myRental);

        make_copy(ct, bn.left);
        make_copy(ct, bn.right);

        return ct;
    }

    //wrapper function to display the tree
    public void display(){

        display(root);
    }
    //function to display the tree
    private void display(bst_node root){

        if(root == null)
            return;
        System.out.println();
        root.myRental.display();

        display(root.right);
        display(root.left);
    }

    public void readFromFile() {

        BufferedReader read;

        try {
            read = new BufferedReader(new FileReader("/Users/dwg2/IdeaProjects/program4/src/com/company/Listings.txt"));
            String s;
            while ((s = read.readLine()) != null) {

                String[] a = s.split(",");
                int type = Integer.parseInt(a[12]);

                if (type == 01) {

                    Apartment my_a = new Apartment(Integer.parseInt(a[0]), a[1], a[2], a[3], a[4], a[5], Integer.parseInt(a[6]),
                            Integer.parseInt(a[7]), Integer.parseInt(a[8]), Integer.parseInt(a[9]),
                            Integer.parseInt(a[10]), a[11], Integer.parseInt(a[12]));

                    insert(my_a);
                }
                else {

                    House my_h = new House(Integer.parseInt(a[0]), a[1], a[2], a[3], a[4], a[5], Integer.parseInt(a[6]),
                            Integer.parseInt(a[7]), Integer.parseInt(a[8]), Boolean.parseBoolean(a[9]),
                            Boolean.parseBoolean(a[10]), Integer.parseInt(a[11]), Integer.parseInt(a[12]));

                    insert(my_h);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}