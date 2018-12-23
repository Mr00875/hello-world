package cn.edu.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*package cn.edu.leetcode;

import java.util.Arrays;

*//**
* @author 作者
* @version 创建时间：2018年12月17日 下午3:55:58
* 类说明
*//*
public class SearchRange {
	public static int[] searchRange(int[] nums, int target) {
		int[] index=new int[]{-1,-1};
		int numsSize=nums.length;
		int low_i,low_j,high_i,high_j;
	    int low_middle=0,high_middle=0;
	    low_i = 0;
	    low_j = numsSize-1;
	    while(low_i<=low_j)
	    {
	        low_middle = (low_i+low_j)/2;
	        if(nums[low_middle]==target)
	        {
	            if(low_middle==0) break;
	            else
	            {
	                if(nums[low_middle-1]<target) break;
	                else low_j = low_middle;
	            }
	        }
	        else if(nums[low_middle]<target)
	            low_i = low_middle+1;
	        else
	            low_j = low_middle-1;
	    }
	    if(nums[low_middle]!=target) 
	        return index;
	    high_i = low_middle;
	    high_j = numsSize-1;
	    while(high_i<=high_j)
	    {
	        high_middle = (high_i+high_j)/2;
	        if(nums[high_middle]==target)
	        {
	            if(high_middle==numsSize-1) break;
	            else
	            {
	                if(nums[high_middle+1]>target) break;
	                else high_i = high_middle+1;
	            }
	        }
	        else
	            high_j = high_middle-1;
	    }
	    index[0] = low_middle+1;
	    index[1] = high_middle+1;
	    return index;

	}        

	public static void main(String[] args) {
		int[] nums={5,7,7,8,8,8,8,10};
		int target=6;
		int[] index=searchRange(nums,target);
		System.out.println("  "+index[0]+" "+index[1]);
	}
}
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
     int[] index=new int[]{-1,-1};
		int numsSize=nums.length;
		int low_i,low_j,high_i,high_j;
	    int low_middle=0,high_middle=0;
	    low_i = 0;
	    low_j = numsSize-1;
	    while(low_i<=low_j)
	    {
	        low_middle = (low_i+low_j)/2;
	        if(nums[low_middle]==target)
	        {
	            if(low_middle==0) break;
	            else
	            {
	                if(nums[low_middle-1]<target) break;
	                else low_j = low_middle;
	            }
	        }
	        else if(nums[low_middle]<target)
	            low_i = low_middle+1;
	        else
	            low_j = low_middle-1;
	    }
	    if(nums[low_middle]!=target) 
	        return index;
	    high_i = low_middle;
	    high_j = numsSize-1;
	    while(high_i<=high_j)
	    {
	        high_middle = (high_i+high_j)/2;
	        if(nums[high_middle]==target)
	        {
	            if(high_middle==numsSize-1) break;
	            else
	            {
	                if(nums[high_middle+1]>target) break;
	                else high_i = high_middle+1;
	            }
	        }
	        else
	            high_j = high_middle-1;
	    }
	    index[0] = low_middle;
	    index[1] = high_middle;
	    return index;
    }
}

public class SearchRange {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);
            
            int[] ret = new Solution().searchRange(nums, target);
            
            String out = integerArrayToString(ret);
            
            System.out.print(out);
        }
    }
}