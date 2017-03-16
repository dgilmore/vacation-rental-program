//David Gilmore CS202 Program #4 WINTER 17
//this is the node class for the balanced tree. This node has a city and a binary search
//tree object. This also has a height field to keep track of balancing.i

package com.company;

/**
 * Created by dwg2 on 3/11/17.
 */

//b_node is the node for the balanced AVL tree
public class B_node {

    protected bst my_tree;
    protected String city;
    protected B_node right, left;
    protected int height;

    //constructor
    public B_node() {

        this.right = null;
        this.left = null;
        this.city = null;
        this.height = 0;
    }

    //constructor that takes a housing argument
    public B_node(Housing rental) {

        this.city = rental.get_city();
        this.my_tree = new bst();
        this.my_tree.insert(rental);
        right = null;
        left = null;
        height = 0;
    }
}


