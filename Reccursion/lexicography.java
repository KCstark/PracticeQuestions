package Reccursion;

public class lexicography {

    public static Boolean lexicoTest(String str){
        int mark=0;
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i)<=str.charAt(i+1)){
                mark=1;
            }else{
                break;
            }
        }
        if(mark==1)
            return true;
        return false;
    }
    public static void main(String[] args) {
        int mark=0;
        String str="aaaabc";
        System.out.println(lexicoTest(str));
    }
}
