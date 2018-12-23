package cn.edu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @author ����
* @version ����ʱ�䣺2018��12��22�� ����11:08:11
* ��˵��
*/
public class combinationSum {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> LList = new ArrayList<List<Integer>>();  // ���յĽ����
        if(candidates == null || candidates.length < 1 || target < 1 )
            return LList;
        Arrays.sort(candidates);  // ����ʹ�ò��ö���ͬ�Ľ����������
        List<Integer> list = new ArrayList<Integer>();  // ��ʱ�������
        combinationSumCore(candidates,list, target, 0, LList);  // ���ĺ���
        return LList;
    }
    public static void combinationSumCore(int[] candidates,List<Integer> list, int target, int index, List<List<Integer>> LList)
    {
        for(int i = index; i < candidates.length; i++) 
        {
            if(candidates[i] == target)  // ���ڣ��ͼ�������
            {
                List<Integer> result = new ArrayList<Integer>();
                result.addAll(list);
                result.add(candidates[i]);
                LList.add(result);
            }
            else if(candidates[i] < target)  // С�ڣ��ͼ����ݹ�
            {
                List<Integer> result = new ArrayList<Integer>();
                result.addAll(list);
                result.add(candidates[i]);
                combinationSumCore(candidates, result, target - candidates[i], i, LList);  // ���iֵ���䣬����Ϊ��ǰֵ����ʹ�ö��
            }
            else  // ���ڣ����������ֶ����ڣ���˲����ܳ����ڽ������
            {
                break;
            }
        }
    }
	public static void main(String[] args) {
		System.out.println(combinationSum((new int[]{2,3,5}),7));
	}
}
