package com.largest_rectangle_histogram;
import java.util.List;
import java.util.Stack;
/**
 * for finding out the largest rectangle area in the histogram.
 */
public class AreaOfRectangle {
    /**
     * for finding out the largest rectangle area in the histogram.
     * @param histogram for taking input histogram List.
     * @return returning integer (maxArea) as output.
     */
    public int getLargestRectangleArea(final List<Integer> histogram) {
        final Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int topOfStack;
        int areaWithTopOfStack;
        int indexOfHistogram = 0;
        while (indexOfHistogram < histogram.size()) {
            if (stack.empty() || histogram.get(stack.peek())
                    <= histogram.get(indexOfHistogram)) {
                stack.push(indexOfHistogram++);
            } else {
                topOfStack = stack.peek();
                stack.pop();
                areaWithTopOfStack = histogram.get(topOfStack) * (stack.empty()
                        ? indexOfHistogram : indexOfHistogram
                        - stack.peek() - 1);
                if (maxArea < areaWithTopOfStack) {
                    maxArea = areaWithTopOfStack;
                }
            }
        }
        while (!stack.empty()) {
            topOfStack = stack.peek();
            stack.pop();
            areaWithTopOfStack = histogram.get(topOfStack) * (stack.empty()
                    ? indexOfHistogram : indexOfHistogram
                    - stack.peek() - 1);
            if (maxArea < areaWithTopOfStack) {
                maxArea = areaWithTopOfStack;
            }
        }
        return maxArea;
    }
}
