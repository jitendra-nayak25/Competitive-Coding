import java.util.Scanner;
public class RemoveDuplicate {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a String.");
        String str = s.nextLine();

        Remove r = new Remove();
        r.operation(str);
    }
}

class Remove{
    public void operation(String str){
        String result ="";
        for(int i = 0; i < str.length(); i++){

            char c = str.charAt(i);
            if(result.indexOf(c) == -1){
                result += c;
            }
        }
        System.out.println("String after removing duplicates: " + result);
    }
}