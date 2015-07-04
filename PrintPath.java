/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anmolpreet sandhu
 */
public class PrintPath {
    //Object of StackCall Class.
	StackCall stkDemo = new StackCall();
	public void printP(int e, int[] pDis, int total, StackCall stkDemo, int b, int[] distance) {
		
		  for(int i = e; i >= e; i--) { //looping for all the nodes on the path
				int print;
				print = e; 
				do{
					stkDemo.push(print);  //Pushing elements onto stack
					print = pDis[print];
				}while(print != 0); 
				System.out.print("Shortest Path:\t");
				stkDemo.push(b);  
				stkDemo.pop(); //Popping each element one by one
				System.out.print((char)(e + 65));
				System.out.println();
				
			////Total cost of traversal/////
				System.out.println("\nTotal Cost from "+ (char)(b + 65)+" to "+(char)(e + 65) +" is:  "+ distance[i]);
				//if(i == e)
					//break;

		  }
	}

}
