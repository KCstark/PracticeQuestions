package Stack;

import java.io.*;
import java.util.*;

/*
    we're given an array and we need to find the next greater element of every element present in the array in the form of array
    Arr = []; -> given
    NGETR = [] -> need to find this
    1. introduce NGETR[] => return this as an answer
    2. last element of NGETR[] = -1
    3. we'll run the loop backwards on arr
    4. now divide the problem in 3 parts:
        1. pop :
            - agar stack size > 0 and peek <= current element hai toh
            - pop it
            - #pop will always be less then #push
        2. (answers) add to the NGETR[]:
            - check if stack size is 0 => empty
            - if yes => then make NGETR[i] = -1
            - if no=> then NGETR[i] = st.peek  
        3. push:
            - every element on the array will be pushed once only 
            - st.push(arr[i])

*/
public class NextGreaterElementToRight{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
 }

 public static int[] solve(int[] arr){
   // solve
   
   int[] NGETR = new int[arr.length];
   Stack<Integer> st = new Stack<>();
   
   st.push(arr[arr.length - 1]);
   NGETR[arr.length -1] = -1;
   
   for(int i = arr.length-2 ; i>= 0; i--)
   {
       // pop
       while(st.size() > 0 && st.peek() <= arr[i])
       {
           st.pop();
       }
       // answers
       if(st.size() == 0)
       {
           NGETR[i] = -1; 
       }
       else
       {
           NGETR[i] = st.peek();
       }
       // push
       st.push(arr[i]);
   }
   return NGETR;
 }

}

