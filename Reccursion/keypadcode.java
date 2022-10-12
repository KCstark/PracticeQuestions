import java.io.*;
import java.util.*;

//  You are given a string str. The string str will contains numbers only, where each number stands for a key pressed on a mobile phone.
// 2. The following list is the key to characters map :
//     0 -> .;
//     1 -> abc
//     2 -> def
//     3 -> ghi
//     4 -> jkl
//     5 -> mno
//     6 -> pqrs
//     7 -> tu
//     8 -> vwx
//     9 -> yz
// 3. Complete the body of getKPC function - without changing signature - to get the list of all words that could be produced by the keys in str.
// Use sample input and output to take idea about output.

public class keypadcode {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        String str = scn.next(); // 678
        
        ArrayList<String> words = getKPC(str);
        System.out.println(words);

    }
    
    // global array for the keypad codes
    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno","pqrs","tu","vwx","yz"};

    public static ArrayList < String > getKPC(String str) {
        
        //base case
        if(str.length() == 0)
        {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
            
        }
        
        // first character nikala
        char ch = str.charAt(0);
        
        // rest of the string nikali
        String ros = str.substring(1);
        
        // faith rakh kar call lagaya -> recursive result
        ArrayList<String> rres = getKPC(ros);
        
        ArrayList<String> mres = new ArrayList<>();
        
        // now attach the first character jo nikal liya tha, with the faith se aaya hua result
        String codeforch = codes[ch - '0'];  // -> '6' - '0' = 54 - 49 (ASCII values) = 6 (decimal value)
        for(int i=0; i<codeforch.length(); i++)
        {
            char chcode = codeforch.charAt(i);
            for(String rstr: rres)
            {
                mres.add(chcode + rstr);
            }
        }
        
        // and return this restult
        return mres;
        
    }

}