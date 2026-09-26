public class RainwaterStorage {
    public static void main(String args[]){
        int arr[] = {3, 0, 2, 0, 4};
        RainWaterStore rws = new RainWaterStore();
        rws.calculateRainwater(arr);

    }
}

class RainWaterStore{

    public void calculateRainwater(int arr[]) {
        int n = arr.length;
        int waterStored = 0;

        for(int i =0; i < n; i++){

            int left = 0;
            int right = 0;

            for(int l =0; l <= i; l++){
                left = Math.max(left, arr[l]);
            }
            for(int r = i; r < n; r++){
                right = Math.max(right, arr[r]);
            }
            waterStored += Math.min(left, right) - arr[i];
        }
        System.out.println("Total water stored is: " + waterStored);

    }


}
