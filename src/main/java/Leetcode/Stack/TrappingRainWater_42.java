package Leetcode.Stack;

import java.util.Stack;

public class TrappingRainWater_42 {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < height.length; i++){
            while (!stack.empty() && height[i] > height[stack.peek()]){
                int pre = stack.pop();
                if (stack.empty())
                    break;
                int dis = i - stack.peek() - 1;
                //subtract the previous height
                result += (Math.min(height[i], height[stack.peek()]) - height[pre]) * dis;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String args[]){
        TrappingRainWater_42 obj = new TrappingRainWater_42();
        obj.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
