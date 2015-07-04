/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anmolpreet sandhu
 */
public class StackCall {
    	private static final int stkSize = 30;  
	 int arr[] = new int[stkSize];    
	 int top = -1;  
	  
	 public void push(int pushE)
	 {  
	  if (top < (stkSize - 1)) {  
		  top++;  
		  arr[top] = pushE;  
	  } 
	  else {  
	   System.out.println("Overflow !");  
	  }  
	  
	 }  
	  
	 public void pop() {  
		 for(int i = 0; i <= top; i++) {
			 if (top >= 0) {  
				  int popE = arr[top];
				  System.out.print((char)(popE + 65) + " -> ");
				  top--;  
			 }  
		 }
	 }  
}
