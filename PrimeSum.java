//3.WAP TO FIND AND SUM PRIME NUMBER USING AN ARRAY[1 6 7 8 9 5 16 15 13 17] 

public class PrimeSum{
    public static void main(String[] args) {
        int arr[]={1,6,7,8,9,5,16,15,13,17};
        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(isPrime(arr[i])){
                sum+=arr[i];
            }
        }
        System.out.println("Sum of prime numbers: "+sum);
    }

    public static boolean isPrime(int num){
        if(num<=1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}