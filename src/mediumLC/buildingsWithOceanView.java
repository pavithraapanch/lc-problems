package mediumLC;

import java.util.ArrayList;
import java.util.List;

public class buildingsWithOceanView {

    public static void main(String[] args){
        int[] heights = new int[]{4,2,3,2,1,1};
        int[] res = buildingsWithOceanView(heights);
        for(int i=0; i<res.length; i++){
            System.out.print(res[i] + ",");
        }
    }
    /*
    Monotonic Stack - Decreasing stack, add elements lesser.
    Since we iterate from the right, we check if the current building has any other buildings on the right, which are greater than current.
    Basically, any building inside the stack which is greater and will block the view.

    4,2,3,2,1,1
    0,2,3,5

    TC - O(N)
    SC - O(1)
    * */
    public static int[] buildingsWithOceanView(int[] heights){
        int n = heights.length;
        if(n == 0) return null;
        List<Integer> result = new ArrayList<>();

        int j = n-1;
        int maxHeight = -1;
        while(j>=0){
            if(heights[j] > maxHeight) {
                maxHeight = heights[j];
                result.add(j);
            }
            j--;
        }
        int[] res = new int[result.size()];
        int k=0;
        for(int i=result.size()-1; i>=0; i--) {
            res[k++] = result.get(i);
        }
        return res;
    }
}
