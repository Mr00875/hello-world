package cn.edu.leetcode;


import java.util.ArrayList;
import java.util.List;
import java.sql.Array;
import java.util.Arrays;


/**
* @author 作者
* @version 创建时间：2018年12月17日 下午7:02:58
* 类说明
*/

public class convert {
	
	public static String convert1(String s, int numRows) {

        if (numRows == 1) 
        	return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) 
            	goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) 
        	ret.append(row);
        return ret.toString();
    }
	
	public static String convert2(String s, int numRows) {

        if (numRows == 1) 
        	return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
	public static String convert3(String s, int numRows) {

        if(numRows == 1) 
        	return s;
        int[] rowIdx = new int[numRows];
        char[] chars = new char[s.length()];
        int n = 0;
        int burketSize = numRows * 2 - 2;
        int burketNum = chars.length / burketSize; 
        int rem = chars.length % burketSize;
        for(int i = 1; i < numRows; i ++){
        	int flag = i == 1 ? 1 : 2;
        	n = flag * burketNum + (rem >= i ? ( 1 + (burketSize - rem + 1 < i ? 1 : 0)) : 0);
        	rowIdx[i] = rowIdx[i-1] + n;
        }
        int flag = -1;
        int curRow = 0;
        for(char c : s.toCharArray()){
        	chars[rowIdx[curRow]] = c;
        	rowIdx[curRow] = rowIdx[curRow] + 1;
        	 if (curRow == 0 || curRow == numRows - 1) 
        		 flag = -flag;
             curRow += flag;
        }
        return new String(chars);
    }
	 public static void main(String[] args) {
		System.out.println(convert1("LEETCODEISHIRING", 4));
		System.out.println(convert2("LEETCODEISHIRING", 4));
		System.out.println(convert3("LEETCODEISHIRING", 4));
		
	}

}
