/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anmolpreet sandhu
 */

import java.util.Scanner;
import java.util.Random;

public class ShortestPath {
    static int NODES = 5; //Static variable to ensure more than 5 nodes.
	static int RANDOM = 300; //Just a bigger random number used in comparisons.
	static int EDGES = 3;
	static int WEIGHTS = 8;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("----Implementation of Shortest Path Algorithm----\n");
		System.out.println("Please note that for the random matix '0' denotes no edge between the nodes.");
		System.out.println("Also all other numeral values denotes the weight of that edge.");
		
		System.out.println("\nPlease enter the number of nodes: ");
		
		int matrixNodes = in.nextInt();
		int b = matrixNodes; // to make a symmetric matrix
		int c = matrixNodes; // just another copy to use later.
		
		
		////////Condition Check at least 6 nodes/////////////
		if(matrixNodes > NODES)
		{
			/*
			 * Two separate classes, StackCall and PrintPath are used to print the path. Call StackCall can be inherited
			 * into any program required stack implementation in future.
			 * 
			 * PrintPath is specific for this algorithm. We need to make lots of changes to use into any other program.
			 */
			
			
			//object of Class StackCall, to call push and pop functions
			StackCall stk = new StackCall(); 
			PrintPath pp = new PrintPath(); // to display the actual path
			int[] cost = new int[matrixNodes];
			int[] pre = new int[matrixNodes];
			int[] visited = new int[matrixNodes];
			int[][] matrix= new int[matrixNodes][b];
			Random rand = new Random();
	//		Random randRow = new Random();
	//		Random randCol = new Random();
			int minDis;
			int nextNode = 0;
			Scanner getSrc = new Scanner(System.in);
			
	
			//Printing adjacency matrix
			
			///////Printing outline/////
			System.out.println("\nAdjacency matrix of the graph with "+ matrixNodes + " nodes:\n");
			for(int i = 0; i < matrixNodes; i++) {
				System.out.print("\t" + (char)(i + 65));
			}
			////////Matrix with weights/////////
			
			for(int i = 0; i < matrixNodes; i++)
			{
				pre[i]	= 0;
				visited[i] = 0;
				System.out.println("\n");
				
				System.out.print("\n" + (char)(i + 65) + "\t");
				for(int j = 0; j < matrixNodes; j++)
				{
					matrix[i][j] = rand.nextInt(EDGES);
					if(matrix[i][j] != 0){
					/*	if(i == j){
							matrix[i][j] = 0;
						} 
						else { */
							matrix[i][j] = rand.nextInt(WEIGHTS);
							//matrix[j][i] = matrix[i][j];
						//}
					}
					
				
					//0 indicates no edge between those two nodes
					System.out.print(matrix[i][j] + "\t");
					if(matrix[i][j] == 0) {
						matrix[i][j] = RANDOM; 
					}
								
				}
			} 
			
			//INPUT CAPTIAL LETTERS ONLY
			
			//Getting user inputs:
			System.out.println("\n");
			
			 // converting any int to char using the following method, This will contributes to ease of use.
			System.out.println("Please choose a Source node from A to "+ (char)((c - 1) + 65));
			char ch1 = getSrc.next().charAt(0); //Char to int for later calculations 
		    int begin = Character.getNumericValue(ch1) - 10;
			//Begin = vertex to start from
		    
			System.out.println("\nPlease choose a Destination node from A to " + (char)((c - 1) + 65));
			Scanner getDes = new Scanner(System.in); //Char to int for later calculations 
		    char ch2 = getDes.findInLine(".").charAt(0);
		    int end = Character.getNumericValue(ch2) - 10;
		    //end = vertex to end at.
		   
		    cost  = matrix[begin];
		    visited[begin] = 1;
		    cost[begin] = 0;
		    
			
			//DIJKSTRA Algorithm
		     //Getting starting by assigning bigger number to minimum distance
			for(int i = 0; i < matrixNodes; i++) {
				minDis = RANDOM;
				for(int j = 0; j < matrixNodes; j++) {
					
						if(cost[j] < minDis && visited[j] != 1) {
							minDis = cost[j];
							nextNode = j;
						}
					
					
				} 
				visited[nextNode] = 1;
				for(int count = 0; count < matrixNodes; count++) {
					if(visited[count] != 1) {
						if( cost[count] > minDis + matrix[nextNode][count]) { //Cost function 
							cost[count] = minDis + matrix[nextNode][count];
							pre[count] = nextNode;
						} 
					}
				}
			}
			System.out.println("\n");
		  
			/*
			 * StackCall Class is being used here. A stack is used to push the nodes on shortest path
			 * and then all the nodes are popped using pop() to display in particular manner.
			 * 
			 * 
			 * //pp is object of class PrintPath.
			 */
			
			
			
			//Printing the path
			
			pp.printP(end, pre, matrixNodes, stk, begin, cost);
			
		}
		else
		{
			System.out.println("\nPlease enter atleast six nodes. Try Again!");
		}
		
	}
	
}
