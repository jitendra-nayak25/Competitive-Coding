import java.util.Scanner;
public class CharacterFrequency {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String to check for character frequency: ");
        String str = sc.nextLine();

        FrequencyChecker fc = new FrequencyChecker();
        fc.fCheck(str);

        sc.close();
    }
}

class FrequencyChecker{
    public void fCheck(String str){
        int[] frequency = new int[256];

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            frequency[ch]++;
        }
        
        for(int i = 0; i < 256; i++){
            if(frequency[i] > 0){
                System.out.println("Frequency of "+ (char)i + " = " + frequency[i]);
            }
        }
    }

}