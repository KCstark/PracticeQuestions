package Reccursion;

import java.util.*;

public class crossword 
{

	public static void solution(char[][] arr, String[] words, int vidx){
		//write your code here
		//base case : when all the words are placed  in the crossword
		if(vidx == words.length)
		{
		    print(arr);
		    return;
		}
		
		String word = words[vidx]; // get the word from the string array
		
		// we will move to every cell and check if we can place the word there or not
		for(int i =0; i<arr.length; i++)
		{
		    for(int j =0; j<arr[0].length; j++)
		    {
		        if(arr[i][j] == '-' || arr[i][j] == word.charAt(0))
		        {
		            if(canPlaceWordHorizontally(arr,word,i,j))
		            {
		                boolean[] wePlaced = placeWordHorizontally(arr,word,i,j);  // it will record the place where we are putting the characters of the word
		                solution(arr,words,vidx + 1);                              // recursive call
		                unplaceWordHorizontally(arr,wePlaced,i,j);                 // unplace the characters of the word only which are recorded in the wePlaced
		            }
		            
		            if(canPlaceWordVertically(arr,word,i,j))
		            {
		                boolean[] wePlaced = placeWordVertically(arr,word,i,j);  // it will record the place where we are putting the characters of the word
		                solution(arr,words,vidx + 1);                            // recursive call
		                unplaceWordVertically(arr,wePlaced,i,j);                 // unplace the characters of the word only which are recorded in the wePlaced
		            }
		        }
		    }
		}
	}
	
	public static boolean canPlaceWordHorizontally (char[][] arr, String word, int i, int j)
	{
	    // check if it's left side exists -> if yes then -> check if it is + -> if NOt -> FALSE
	    if(j-1 >= 0 && arr[i][j-1] != '+')
	    {
	        return false;
	    }
	    else if(j+word.length() < arr[0].length && arr[i][j+word.length()] != '+' ) // check for the right side 
	    {
	        return false;
	    }
	    
	    for(int jj = 0; jj < word.length(); jj++ )
	    {
	        // check if the word is not exiting the board  ->  if yes -> then return false
	        if(j + jj >= arr[0].length)
	        {
	            return false;
	        }
	        // check if blank is there || word's character is already present there 
	        if(arr[i][j + jj] == '-' || arr[i][j + jj] == word.charAt(jj))
	        {
	            continue;
	        }
	        else
	        {
	            return false;
	        }
	    }
	    return true;
	}
	
	public static boolean [] placeWordHorizontally (char[][] arr, String word, int i, int j)
	{
	    boolean[] wePlaced = new boolean[word.length()];
	    
	    for(int jj=0; jj < word.length(); jj++)
	    {
	        if(arr[i][j + jj]  == '-')
	        {
	            arr[i][j + jj] = word.charAt(jj);
	            wePlaced[jj] = true;
	        }
	    }
	    return wePlaced;
	}
	
	public static void unplaceWordHorizontally (char[][] arr, boolean[] wePlaced, int i, int j )
	{
	    for(int jj =0; jj< wePlaced.length; jj++)
	    {
	        if(wePlaced[jj] == true)
	        {
	            arr[i][j + jj] = '-';
	        }
	    }
	}
	
	
	
	public static boolean canPlaceWordVertically (char[][] arr, String word, int i, int j)
	{
	    // check if it's left side exists -> if yes then -> check if it is + -> if NOt -> FALSE
	    if(i-1 >= 0 && arr[i-1][j] != '+')
	    {
	        return false;
	    }
	    else if(i+word.length() < arr.length && arr[i+word.length()][j] != '+' ) // check for the right side 
	    {
	        return false;
	    }
	    
	    for(int ii = 0; ii < word.length(); ii++ )
	    {
	        // check if the word is not exiting the board  ->  if yes -> then return false
	        if(i + ii >= arr.length)
	        {
	            return false;
	        }
	        // check if blank is there || word's character is already present there 
	        if(arr[i + ii][j] == '-' || arr[i + ii][j] == word.charAt(ii))
	        {
	            continue;
	        }
	        else
	        {
	            return false;
	        }
	    }
	    return true;
	}
	
	public static boolean [] placeWordVertically (char[][] arr, String word, int i, int j)
	{
	    boolean[] wePlaced = new boolean[word.length()];
	    
	    for(int ii=0; ii < word.length(); ii++)
	    {
	        if(arr[i + ii][j]  == '-')
	        {
	            arr[i + ii][j] = word.charAt(ii);
	            wePlaced[ii] = true;
	        }
	    }
	    return wePlaced;
	}
	
	public static void unplaceWordVertically (char[][] arr, boolean[] wePlaced, int i, int j )
	{
	    for(int ii =0; ii< wePlaced.length; ii++)
	    {
	        if(wePlaced[ii] == true)
	        {
	            arr[i + ii][j] = '-';
	        }
	    }
	}

	
	public static void print(char[][] arr){
		for(int i = 0 ; i < arr.length; i++){
			for(int j = 0 ; j < arr.length; j++){
				System.out.print(arr[i][j]);
			}
                  System.out.println();
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char[][] arr = new char[10][10];
		for(int i = 0 ; i < arr.length; i++){
			String str = scn.next();
			arr[i] = str.toCharArray();
		}
		int n = scn.nextInt();
		String[] words = new String[n];
		for(int i = 0 ; i  < words.length; i++){
			words[i] = scn.next();
		}
        solution(arr, words, 0);
	}
}
