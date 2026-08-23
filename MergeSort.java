//2. WAP TO SORT AN ARRAY USING MERGE SORT[10 40 46 76 2 4 1 50]

public class MergeSort{

    static void merge(int arr[], int low, int mid, int high ){
        int n1=mid - low + 1;
        int n2=high - mid;


        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[low + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = low;
        
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void mergeSort(int arr[], int low, int high){
        if(low<high){
            int mid=(low+high)/2;
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }

    }

    public static void main(String args[]){
        int arr[]={10,40,46,76,2,4,1,50};
        System.out.println("The elements of array are");
        for(int x:arr){
            System.out.print(x+" ");
        }   
        int n=arr.length;

        mergeSort(arr,0,n-1);
        System.out.println("\nThe sorted array is:");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }



    }
}
