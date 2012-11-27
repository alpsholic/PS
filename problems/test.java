package problems;

public class test {


	public int largestRectangleArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (height.length == 0) return 0;
		int minSoFar = height[0];
		int areaSoFar = height[0];
		int newArea;

		for (int i = 1; i < height.length; i++){
			if (areaSoFar+Math.min(minSoFar, height[i]) < height[i]){
				areaSoFar = height[i];
				minSoFar = height[i];
				continue;
			}
			if (minSoFar <= height[i]){
				newArea = areaSoFar + minSoFar;
			}else{
				newArea = (areaSoFar/minSoFar+1)*height[i];
				minSoFar = height[i];
			}
			if (newArea == height[i]){
				minSoFar = height[i];
			}
			if (newArea>areaSoFar){
				areaSoFar = newArea;
			}
		}
		return areaSoFar;
	}



}
