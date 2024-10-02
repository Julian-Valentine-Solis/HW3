/*
 * *** Julian Solis / 001 ***
 *
 * This java file contains several simple tree problems that need to be
 * codified. These routines  must use the TreeMap and TreeSet library
 * classes from the Java Collection Framework.
 *
 */

import java.util.*;

public class TreeProblems {

  /**
   * Method different()
   *
   * Given two TreeSets of integers, return a TreeSet containing all elements
   * that are NOT in both sets. In other words, return a TreeSet of all the
   * elements that are in one set but not the other.
   */

  public static Set<Integer> different(Set<Integer> setA, Set<Integer> setB) {

    // INSERT CODE HERE - DO NOT FORGET TO PLACE YOUR NAME ABOVE
    //
    // This can be done numerous ways, but once such will only that
    // *several* lines of code. Hint: create two temporary TreeSets and utilize the
    // methods retainAll(), addAll(), and removeAll(). But in the end, get something
    // to work.
    // Create two temp TreeSets
    TreeSet<Integer> temp1 = new TreeSet<Integer>(setA);
    TreeSet<Integer> temp2 = new TreeSet<Integer>(setB);

    // Use removeAll() to distiguish unique elements
    temp1.removeAll(setB);// Any element in setA that are also in setB removed
    temp2.removeAll(setA);// Any elements in setB that are also in setA removed

    // At this point our two temp Sets contain elements that are unique to each set,
    // so we can take the union to
    // get the set of all unique values
    temp1.addAll(temp2);// temp1 now contains all unique values

    return temp1;// Return unique elements
  }

  /**
   * Method removeEven()
   *
   * Given a treeMap with the key as an integer, and the value as a String,
   * remove all <key, value> pairs where the key is even.
   */

  public static void removeEven(Map<Integer, String> treeMap) {

    // INSERT CODE HERE.
    // Give the parameter treeMap, our first objective is to identify how we will be
    // traversing the treeMap
    // so, I think a good approach would be to create an iterator for the keys in
    // the map, allowing us to traverse the keys for verificatio that they are even.

    Iterator<Integer> itr = treeMap.keySet().iterator();// Create an iterator for the keys

    // so next I think we should check the base case(I think that's what's this is
    // called), meaning if the treeMap is an empty tree, then there's no even keys
    // to remove, so just return.
    if (treeMap.isEmpty()) {
      return;
    }
    // so next I believe we would use a loop to travere the keys in the treeMap to
    // check if they are even
    // and then we can use the iterator's remove method to remove the even keys
    while (itr.hasNext()) {
      int number = itr.next();
      if (number % 2 == 0) {
        itr.remove();
      }
    }

    return;
  }

  /**
   * Method treesEqual()
   *
   * Given two treeMaps, each with the key as an integer, and the value as a
   * String,
   * return a boolean value indicating if the two trees are equal or not.
   */

  public boolean treesEqual(Map<Integer, String> tree1, Map<Integer, String> tree2) {

    // INSERT CODE HERE
    // Handle base case
    if (tree1 == null || tree2 == null) {
      return false;
    }

    // if they're not the same size, there is no way for them to be equal
    if (tree1.size() != tree2.size()) {
      return false;
    }

    // Utilize Map interface .equals() to compare keys and values
    return tree1.equals(tree2);

  }

} // end treeProblems class
