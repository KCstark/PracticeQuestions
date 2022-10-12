import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner (System.in);
        String str = scn.next();
        printEncodings(str,"");

    }

    public static void printEncodings(String ques, String asf) {
        // 3 cases are defined
        // 1. when length of ques becomes = 0
        // 2. when length of ques becomes = 1
        // 3. when length of ques becomes >1
        
        // 1st case
        if(ques.length() == 0)
        {
            System.out.println(asf);
            return;
        }
        else if(ques.length() == 1)  // 2nd case
        {
            char ch = ques.charAt(0);
            // now if this only char is = 0 then,
            if(ch == '0')
            {
                return;
            }
            else
            {
                // if this character is != 0
                // we will convert this character to INT 
                int chv = ch - '0';
                // now convert it to char we need 
                char code = (char)('a' + chv - 1); // see 'a' +1 -1 = a because we know a = 1
                System.out.println(asf + code);
            }
        }
        else
        {
            // 3rd case
            // here we can have two calls 
            // 3.1 -> when we call for val of length = 1
            // 3.2 -> when we call for val of length = 2
            
            //3.1
            char ch = ques.charAt(0);
            String roq = ques.substring(1);
            //3.1.1
            if(ch == '0')
            {
                return;
            }
            else  // 3.1.2
            {
                int chv = ch - '0';
                char code = (char)('a' + chv - 1);
                printEncodings(roq, asf + code);
            }
            
            // 3.2
            String ch12 = ques.substring(0,2);
            String roq12 = ques.substring(2);
            
            int chv12 = Integer.parseInt(ch12);
            
            if(chv12 <= 26)
            {
                char code12 = (char)('a' + chv12 - 1);
                printEncodings(roq12, asf + code12);
            }
        }
    }

}