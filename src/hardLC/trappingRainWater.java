package hardLC;

public class trappingRainWater {

    public static void main(String args[]){
        int[] height = new int[]{0,1,0,2,0,3,0,3};
        int res = trappingRainWater(height);
        System.out.println("res " + res);
    }
    public static int trappingRainWater(int[] height){
        //2 pointer approach.
        //0,1,0,2,0,3,0,3 = 3
        //traverse from left to right and right to left, find the min(L,R) - h[i] = trapped water in each index.
        //space consuming.
        int l = 0;
        int r = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;

        //l = 0, 1, 2, 3, 4
        //r = 5, 4
        //lMax = 0, 1, 2
        //rMax = 0, 3
        //result = 1 + 2 = 3

        while(l < r){
            if(height[l] < height[r]){
                if(height[l] < leftMax){
                    result += leftMax - height[l];
                }else{
                    leftMax = height[l];
                }
                l++;
            } else {
                if(height[r] < rightMax){ // 0<0 ;
                    result += rightMax - height[r];
                }else{
                    rightMax = height[r]; // 0
                }
                r--; // r=len-2;
            }
        }
        return result;
    }
}
