// In opening bracket = push the elements
// In closing bracket = 2 options: pop karne ki koshish
// if stack size != 0 and appropriate cheez padi hai toh pop them 
// if stack size != 0 and  inappropriate element is present then return false
// if stack size = 0 then -> there are too many closing brackets -> and return false
// if stack size > 0 => return false -> too many opening brackets
// if stack size == 0 -> eturn true => stack empty hai and sab balanced hai 

import java.io.*;
import java.util.*;

public class BalancedBrackets
{

    public static boolean handleClosingBrackets(Stack<Character> st, char appropriateCh) {
        if (st.size() == 0) {
            return false; // too many closing brackets
        } else {
            if (st.peek() != appropriateCh) {
                return false; // inappropriate element present
            } else {
                st.pop(); // appropriate element present hence -> pop it
                return true;
            }
        }

    }

    public static void main(String[] args) throws Exception {
        // In opening bracket = push the elements
        // In closing bracket = 2 options: pop karne ki koshish
        // if stack size != 0 and appropriate cheez padi hai toh pop them
        // if stack size != 0 and inappropriate element is present then return false
        // if stack size = 0 then -> there are too many closing brackets -> and return
        // false
        // if stack size > 0 => return false -> too many opening brackets
        // if stack size == 0 -> return true => stack empty hai and sab balanced hai

        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')') {
                boolean val = handleClosingBrackets(st, '(');
                if (val == false) {
                    System.out.println(val);
                    return;
                }
            } else if (ch == '}') {
                boolean val = handleClosingBrackets(st, '{');
                if (val == false) {
                    System.out.println(val);
                    return;
                }
            } else if (ch == ']') {
                boolean val = handleClosingBrackets(st, '[');
                if (val == false) {
                    System.out.println(val);
                    return;
                }
            } else {
                // for every other element in the string -> we'll ignore it
            }

        }

        if (st.size() == 0) {
            System.out.println("true");
            return;
        } else {
            System.out.println("false");
            return;
        }
    }

}
