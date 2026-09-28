import java.util.Scanner;
public class VowelConsonant {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a String to check for vowels and consonants: ");
        String str = sc.nextLine();

        Checker vc = new Checker();
        vc.check(str);

        sc.close();
    }
}

 class Checker{

    public void check(String str){
        int vowel = 0;
        int consonant = 0;
        str = str.toLowerCase();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                if( ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                    vowel++;
                }else{
                    consonant++;
                }
                
            }

        }
        System.out.println("Number of Vowels =" + vowel);
        System.out.println("Number of Consonants =" + consonant);
        
    }
}