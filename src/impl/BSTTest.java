package impl;
import core.*;
import impl.*;


//(a) Using pen and paper, show the state of a binary search tree that results from each of the following operations: 
//insert(24), insert(12), insert(36), insert(5), insert(7), insert(2), insert(76), remove(24), insert(18), insert(24) 

//(b) Write a class called BSTTest that contains a main method that creates the tree outlined in (a). Print out the 
//state of the tree after each operation and confirm that it matches the answer to part (a). 


//Outcome is the same as part(a). After removal of 24, 36 becomes the root.
public class BSTTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        bst.insert(24);
        System.out.println(bst.toString());

        bst.insert(12);
        System.out.println(bst.toString());

        bst.insert(36);
        System.out.println(bst.toString());

        bst.insert(5);
        System.out.println(bst.toString());

        bst.insert(7);
        System.out.println(bst.toString());

        bst.insert(2);
        System.out.println(bst.toString());

        bst.insert(76);
        System.out.println(bst.toString());

        bst.remove(24);
        System.out.println(bst.toString());

        bst.insert(18);
        System.out.println(bst.toString());

        bst.insert(24);
        System.out.println(bst.toString());

    }
}
