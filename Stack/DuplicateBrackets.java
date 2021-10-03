package Stack;

import java.util.*;


public class DuplicateBrackets {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        Stack <Character> st = new Stack<>();
        
        // iterate over string length
        // get every element of the string one by one
        // if we have (  or any other element -> then push it, 
        // if we encounter ) then there are 2 cases 
            // 1. pop till we get ( + pop (  too
            // 2. if we had ( on the peek then just return true : this is our condition for duplicate brackets
        
        for (int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);
            if(ch == ')')
            {
                if(st.peek() == '(')
                {
                    System.out.println("true");
                    return;
                }
                else
                {
                    while(st.peek() != '(')
                    {
                        st.pop();
                    }
                    st.pop();
                }
            }
            else
            {
                st.push(ch);
            }
        }
        System.out.println("false");

    }

}