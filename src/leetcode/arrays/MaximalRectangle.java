package leetcode.arrays;

import java.util.Deque;
import java.util.LinkedList;

public class MaximalRectangle {

	public static void main(String[] args) {
		int input[][] = { { 1, 1, 1, 0 }, { 1, 1, 1, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 0, 1 },
				{ 1, 1, 1, 1 } };
		MaximalRectangle mrs = new MaximalRectangle();
		int maxRectangle = mrs.maximum(input);
		System.out.println("Max rectangle is of size " + maxRectangle);
		assert maxRectangle == 8;
	}

	public int maximum(int input[][]) {
		int temp[] = new int[input[0].length];
		MaximalRectangle mh = new MaximalRectangle();
		int maxArea = 0;
		int area = 0;
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				if (input[i][j] == 0) {
					temp[j] = 0;
				} else {
					temp[j] += input[i][j];
				}
			}
			area = mh.maxHistogram(temp);
			if (area > maxArea) {
				maxArea = area;
			}
		}
		return maxArea;
	}

	public int maxHistogram(int input[]) {
		Deque<Integer> stack = new LinkedList<Integer>();
		int maxArea = 0;
		int area = 0;
		int i;
		for (i = 0; i < input.length;) {
			if (stack.isEmpty() || input[stack.peekFirst()] <= input[i]) {
				stack.offerFirst(i++);
			} else {
				int top = stack.pollFirst();
				// if stack is empty means everything till i has to be
				// greater or equal to input[top] so get area by
				// input[top] * i;
				if (stack.isEmpty()) {
					area = input[top] * i;
				}
				// if stack is not empty then everythin from i-1 to input.peek()
				// + 1
				// has to be greater or equal to input[top]
				// so area = input[top]*(i - stack.peek() - 1);
				else {
					area = input[top] * (i - stack.peekFirst() - 1);
				}
				if (area > maxArea) {
					maxArea = area;
				}
			}
		}
		while (!stack.isEmpty()) {
			int top = stack.pollFirst();
			// if stack is empty means everything till i has to be
			// greater or equal to input[top] so get area by
			// input[top] * i;
			if (stack.isEmpty()) {
				area = input[top] * i;
			}
			// if stack is not empty then everything from i-1 to input.peek() +
			// 1
			// has to be greater or equal to input[top]
			// so area = input[top]*(i - stack.peek() - 1);
			else {
				area = input[top] * (i - stack.peekFirst() - 1);
			}
			if (area > maxArea) {
				maxArea = area;
			}
		}
		return maxArea;
	}

}
