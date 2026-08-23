
import java.util.Scanner;

public class Reverse {
    Scanner sc=new Scanner(System.in);
    int arr[];
    int capacity;
    public Reverse(int size){

        this.arr=new int[size];
    }
    public void reverse(){
        int high=0;
        int low=arr.length-1;
        while(high<low){
            int temp=arr[high];
            arr[high]=arr[low];
            arr[low]=temp;

            high++;
            low--;
        }
    }
    public void insert(){
        System.out.println("enter the elements");
        for(int i = 0; i< arr.length;i++) {
            arr[i] = sc.nextInt();
        }
    }

    public void display(){
        System.out.println("the elements of arrays are");
        for (int i=0;i< arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the size of array");
        int size=sc.nextInt();
      Reverse ob=new Reverse(size);
      ob.insert();
      ob.reverse();
      ob.display();
    }
}