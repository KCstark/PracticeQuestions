package Reccursion;

import java.util.ArrayList;
public class subsetOfArray {
    
public static void main(String[] args) {

    // System.out.println();
}
public static int[][] subsetOfArray(int[] arr,int start,int end){

    if(start>end) {
        return new int[1][0];
    }
    int[][] smallAns=subsetOfArray(arr, start+1, end);
    int[][] ans=new int[smallAns.length * 2][];

    for(int i=0;i<smallAns.length;i++) {
        ans[i]=new int[smallAns[i].length];
        for(int j=0;j<smallAns[i].length;j++) {
            ans[i][j]=smallAns[i][j];
        }
    }
    for(int i=smallAns.length ; i<ans.length;i++) {
        ans[i]=new int[smallAns[i-smallAns.length].length + 1];
//            System.out.println (ans[i]);
        ans[i][0]=arr[start];
        for(int j=1;j<ans[i].length;j++) {
            ans[i][j]=smallAns[i-smallAns.length][j-1];

            // System.out.println (ans[i][j]);
        }
    }
    return ans;
}
}