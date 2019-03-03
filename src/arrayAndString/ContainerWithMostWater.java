package arrayAndString;

public class ContainerWithMostWater {
    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int leftMax = 0;
        int rightMax = height.length - 1;
        int res = Math.min(height[leftMax], height[rightMax]) * (rightMax - leftMax);
        while(leftMax < rightMax) {
            res = Math.max(res, Math.min(height[leftMax], height[rightMax]) * (rightMax - leftMax));
            if(height[leftMax] < height[rightMax])
                leftMax++;
            else
                rightMax--;
        }
        return res;
    }
}
