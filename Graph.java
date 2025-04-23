/******************************************************************
 *
 *   Mohammad Qazi / SECTION 001
 *
 *   Note, additional comments provided throughout this source code
 *   is for educational purposes
 *
 ********************************************************************/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 *  Graph traversal exercise
 *
 *  The Graph class is a representing an oversimplified Directed Graph of vertices
 *  (nodes) and edges. The graph is stored in an adjacency list
 */

public class Graph {
  int numVertices;                  // vertices in graph
  LinkedList<Integer>[] adjListArr; // Adjacency list
  List<Integer> vertexValues;       // vertex values

  // Constructor 
  public Graph(int numV) {
    numVertices = numV;
    adjListArr = new LinkedList[numVertices];
    vertexValues = new ArrayList<>(numVertices);

    for (int i = 0; i < numVertices; i++) {
      adjListArr[i] = new LinkedList<>();
      vertexValues.add(0);
    }
  }

  /*
   * method setValue
   * 
   * Sets a vertex's (node's) value.
   */ 
  
  public void setValue(int vertexIndex, int value) {
    if (vertexIndex >= 0 && vertexIndex < numVertices) {
      vertexValues.set(vertexIndex, value);
    } else {
      throw new IllegalArgumentException(
             "Invalid vertex index: " + vertexIndex);
    }
  }


  public void addEdge(int src, int dest) {
    adjListArr[src].add(dest);
  }

  /*
   * method printGraph
   * 
   * Prints the graph as an adjacency matrix
   */ 
  
  public void printGraph() {
    System.out.println(
         "\nAdjacency Matrix Representation:\n");
    int[][] matrix = new int[numVertices][numVertices];

    for (int i = 0; i < numVertices; i++) {
      for (Integer dest : adjListArr[i]) {
        matrix[i][dest] = 1;
      }
    }

    System.out.print("  ");
    for (int i = 0; i < numVertices; i++) {
      System.out.print(i + " ");
    }
    System.out.println();

    for (int i = 0; i < numVertices; i++) {
      System.out.print(i + " ");
      for (int j = 0; j < numVertices; j++) {
        if (matrix[i][j] == 1) {
          System.out.print("| ");
        } else {
          System.out.print(". ");
        }
      }
      System.out.println();
    }
  }


  /**
   * method findRoot
   *
   * This method returns the value of the root vertex, where root is defined in
   * this case as a node that has no incoming edges. If no root vertex is found
   * and/or more than one root vertex, then return -1.
   * 
   */
  
  public int findRoot() {

    // ADD YOUR CODE HERE - DO NOT FORGET TO ADD YOUR NAME/SECTION AT TOP OF FILE
    int[] edges = new int[numVertices]; //array that represents the vertecies in the graph 

    //count incoming edges for each vertex in the graph and incriment by 
    //the number of incoming edges for each vertex represented in the edges arr
    
    for (int src = 0; src < numVertices; src++) {
      for (int j = 0; j < adjListArr[src].size(); j++) {
        int dest = adjListArr[src].get(j);
        edges[dest]++;
      }
    }

    int root = -1; //stores the root of the graph based on the for loop below

    //for loop iterating through the verticies of the graph and cheking if the vertex has any edges
    //based on the value in the edges arr if it does not then the root variable is set to that vertex
    // or else -1 is returned
    for (int i = 0; i < numVertices; i++) {
      if (edges[i] == 0) {
        if (root == -1) {
          root = i; 
        } else {
          return -1; 
        }
      }
    }

    //if the root stayed -1 that means there is no root and -1 is returned
    if (root == -1) {
      return -1; //no root found
    }

    return vertexValues.get(root);
    
  } 
}
