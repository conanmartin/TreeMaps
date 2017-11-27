package impl;

import java.util.Iterator;

/**
 * This class implements a TreeMap for a type T
 * Implements an inner class TreeEntry, which implements Comparable<T>.
 * Uses the BinarySearchTree class provided to store and access data
 *
 * @author Conan Martin
 *
 * @param <T>
 */

public class TreeMap<T>{

    public class TreeEntry<T> implements Comparable<TreeEntry<T>>{
        private T value;
        private int key;


        public TreeEntry(int key, T value){
            this.value = value;
            this.key = key;
        }

        /**
         * Overrides toString to provide necessary information
         * @return
         */

        @Override
        public String toString(){
            return "{<" + key + ">},{<" + value + ">}";
        }


        /**
         * Implementation for Comparable<T> interface. Compares TreeEntry objects using their key (int) values.
         * @param other
         * @return
         */
        @Override
        public int compareTo(TreeEntry other){
            return Integer.compare(this.key, other.key);
        }

    }


    private int size;
    private BinarySearchTree<TreeEntry<T>> bst;

    public TreeMap(){
        this.size = 0;
        this.bst = new BinarySearchTree<>();
    }

    /**
     * returns size of the TreeMap
     * @return
     */

    public int size(){
        return this.size;
    }

    /**
     * Checks if the TreeMap is empty
     * @return
     */

    public boolean isEmpty(){
        return this.size == 0;
    }

    /**
     * Uses the BST toString method to print structure of TreeMap
     * @return
     */

    @Override
    public String toString(){
        return this.bst.toString();
    }

    /**
     * Creates a TreeEntry<T> objects and puts it in the BST using the BST insert method.
     * @param key
     * @param value
     * @return
     */

    public TreeEntry<T> put(int key, T value){
        TreeEntry<T> treeEntry = new TreeEntry<>(key, value);
        this.size++;
        return bst.insert(treeEntry);
            }

    /**
     * Finds a TreeEntry object with a given key. The T provided is used only to create a comparable object.
     * Uses the BST find method.
     * @param key
     * @param t
     * @return
     */
    public TreeEntry<T> get(int key, T t){
        TreeEntry<T> search = new TreeEntry<>(key, t);
        return bst.find(search);
    }

    /**
     * Removes a TreeEntry object with a given key. The T provided is used only to create a comparable object.
     * Uses the BST remove method.
     * @param key
     * @param t
     * @return
     */
    public TreeEntry<T> remove(int key, T t){
        TreeEntry<T> search = new TreeEntry<>(key, t);
        this.size--;
        return bst.remove(search);
    }

    /**
     * Returns an array of all TreeEntry objects in the TreeMap.
     * Uses the BST iterator method and keeps all not null objects.
     * @return
     */
    public TreeEntry<T>[] entries(){
        TreeEntry<T>[] output = new TreeEntry[this.size];
        Iterator iterator = bst.iterator();
        int p = 0;
        while (iterator.hasNext()){
                TreeEntry<T> treeEntry = (TreeEntry<T>) iterator.next();
                if(treeEntry != null){
                    output[p] = treeEntry;
                    p++;
//                    System.out.println(treeEntry);
            }
        }
        return output;
    }

    /**
     * Returns an array of all TreeEntry objects' keys.
     * Uses the BST iterator method and keeps all not null objects.
     * @return
     */
    public int[] keys(){
        int[] output = new int[this.size];
        Iterator iterator = bst.iterator();
        int p = 0;
        while (iterator.hasNext()){
            TreeEntry<T> treeEntry = (TreeEntry<T>) iterator.next();
            if(treeEntry != null){
                output[p] = treeEntry.key;
                p++;
//                System.out.println(treeEntry);
            }
        }
        return output;
    }

    /**
     * Returns an array of all TreeEntry objects' values.
     * Uses the BST iterator method and keeps all not null objects.
     * @return
     */
    public Object[] values(){
        Object[] output = new Object[this.size];
        Iterator iterator = bst.iterator();
        int p = 0;
        while (iterator.hasNext()){
            TreeEntry<T> treeEntry = (TreeEntry<T>) iterator.next();
            if(treeEntry != null){
                output[p] = treeEntry.value;
                p++;
//                System.out.println(treeEntry);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        // put(24, “”), put(12,””), put(36,””), put(5,””), put(7,””), 
        // put(2,””), put(76,””), remove(24), put(18,””), put(24,””) 
        TreeMap<String> tm = new TreeMap<>();
        tm.put(24, "");
        tm.put(12, "");
        tm.put(36, "");
        tm.put(5, "");
        tm.put(7, "");
        tm.put(2, "");
        tm.put(76, "");
        tm.remove(24, "");
        tm.put(18, "");
        tm.put(24, "");
        System.out.println("Print the whole thing:");
        System.out.println(tm.toString());
        System.out.println("\nPrint the entries individually:");
        for(Object t : tm.entries()){
            System.out.println(t);
        }
        System.out.println("\nPrint just the keys:");
        for(int i : tm.keys()){
            System.out.println(i);
        }
        System.out.println("\nPrint just the values");
        for(Object v : tm.values()){
            System.out.println(v);
        }

    }
}
