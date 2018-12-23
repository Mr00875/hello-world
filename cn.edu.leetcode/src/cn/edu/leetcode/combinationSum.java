package cn.edu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @author 作者
* @version 创建时间：2018年12月22日 上午11:08:11
* 类说明
*/
public class combinationSum {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> LList = new ArrayList<List<Integer>>();  // 最终的结果集
        if(candidates == null || candidates.length < 1 || target < 1 )
            return LList;
        Arrays.sort(candidates);  // 排序，使得不用对相同的结果集计算多次
        List<Integer> list = new ArrayList<Integer>();  // 临时结果保存
        combinationSumCore(candidates,list, target, 0, LList);  // 核心函数
        return LList;
    }
    public static void combinationSumCore(int[] candidates,List<Integer> list, int target, int index, List<List<Integer>> LList)
    {
        for(int i = index; i < candidates.length; i++) 
        {
            if(candidates[i] == target)  // 等于，就加入结果集
            {
                List<Integer> result = new ArrayList<Integer>();
                result.addAll(list);
                result.add(candidates[i]);
                LList.add(result);
            }
            else if(candidates[i] < target)  // 小于，就继续递归
            {
                List<Integer> result = new ArrayList<Integer>();
                result.addAll(list);
                result.add(candidates[i]);
                combinationSumCore(candidates, result, target - candidates[i], i, LList);  // 这边i值不变，是因为当前值可以使用多次
            }
            else  // 大于，则后面的数字都大于，因此不可能出现在结果集中
            {
                break;
            }
        }
    }
	public static void main(String[] args) {
		System.out.println(combinationSum((new int[]{2,3,5}),7));
	}
}
