package Reccursion;
import java.util.*;
public class subSequence {

   public static ArrayList<String> getSS(String str){
       if(str.length()==0){
           ArrayList<String> temp= new ArrayList<>();
           temp.add("");
           return temp;
       }
       char cc= str.charAt(0);
       String rest=str.substring(1);
       ArrayList<String> list1= new ArrayList();
       ArrayList<String> list2= getSS(rest);
       for (String s : list2) {
           list1.add(s);
           list1.add(cc + s);
       }
       return list1;
   }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print(getSS("abc"));

    }
}
