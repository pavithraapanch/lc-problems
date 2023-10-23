package mediumLC;

public class maximumSwap {
    //23799
    //9372
    // 0, 1,
    public int maxSwap(int num){
        int len = String.valueOf(num).length();
        char[] arr = String.valueOf(num).toCharArray();
        int[] lastIndex = new int[10];

        //Iterate through array to find lastIndex of all chars.
        for(int i=0; i<len; i++){
            lastIndex[arr[i] - '0'] = i;
        }

        //Swap the first idx with the largest num present
        for(int i=0; i<len; i++) {
            for(int j=9; j>=0; j--){
                if(lastIndex[arr[j]] > i){
                    char tmp = arr[i];
                    arr[i] = arr[lastIndex[j]];
                    arr[lastIndex[j]] = tmp;
                    return Integer.parseInt(new String(arr));
                }
            }
        }
        return num;
    }
}
