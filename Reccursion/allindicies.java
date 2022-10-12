import java.io.*;
import java.util.*;

public class allindices {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int x = Integer.parseInt(br.readLine());
        int[] iarr = allIndices(arr, x, 0, 0);

        if (iarr.length == 0) {
            System.out.println();
            return;
        }

        for (int i = 0; i < iarr.length; i++) {
            System.out.println(iarr[i]);
        }
    }

    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        // write ur code here
        
        // base case
        if(idx == arr.length)
        {
            return new int[fsf];
        }
        
        // call lagayi toh saare elements upar chadh gaye 
        // aiisa = all indices in smaller array
        
        if(arr[idx] == x)
        {
            //fsf and comparision uppar jaate hue kiya
            int[] newarr = allIndices(arr, x, idx+1, fsf+1);
            //neeche aate hue we ran our base case and these line
            newarr[fsf] = idx;
            return newarr;
        }
        else
        {
            // agar hume x element nhi mila on comparision
            int[] newarr = allIndices(arr, x, idx+1, fsf);
            return newarr;
        }
    }

}
