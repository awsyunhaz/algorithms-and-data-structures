package Leetcode.Math;

public class RectangleArea_223 {
    // respective area - overlap
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = (C-A)*(D-B) + (G-E)*(H-F);
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int bottom = Math.max(B, F);
        int top = Math.min(D, H);
        if (left < right && bottom < top) {
            area -= (right - left) * (top - bottom);
        }
        return area;
    }
}
