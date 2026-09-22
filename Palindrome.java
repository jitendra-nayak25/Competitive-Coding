public class Palindrome {
    public static void main (String args[]){
        String str = "madammmm";

        char[] arr = str.toCharArray();        
        

        int i = 0, j= arr.length-1;

        while(i <= j){
            if(arr[i] == arr[j]){
            i++;
            j--;
            }
            else{
                System.out.println("Not a palindrome");
                return;
            }
        }
        System.out.println("is a Palindrome");
    }
}