package MangVaPhuongThuc.baitap;

class findOccurrenceValue {
     static int findOccurrenceValue (int arr[],int n, int x){
        int res = 0 ;
        for (int i  = 0 ; i < n ; i++){
            if (x == arr[i]){
                res++;
            }
        }
        return  res;
    }
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,3,3,3,3,4,4,4,4,4,5};
        int n = arr.length;
        int x = 4;
        System.out.println(findOccurrenceValue(arr,n,x));
    }
}
