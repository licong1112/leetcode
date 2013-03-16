/**
 * Practiced on 1/6/2013
 * 
 * 0����Щ�������__��
 * 1����Щ�������__��
 * 2����Щ�������__��
 * 3����Щ�������__��
 * ������
 * ������
 * 
 * =================
 * ���ۡ�����������
 */

package com.congli.leetcode;

public class Test {

	public static void main(String[] args) {
		Test test = new Test();
		int[] result = new int[6];
		test.find(0, result);
	}

	public void find(int index, int[] result)
	{
		if(index == result.length)
		{
			if(isValid(result))
			{
				for(int i = 0; i < result.length; ++i)
					System.out.print(result[i]);
				System.out.println();
			}
			return;
		}
		for(int i = 0; i < result.length; ++i)
		{
			result[index] = i;
			find(index+1, result);
			result[index] = 0;
		}
	}
	
	private boolean isValid(int[] result)
	{
		
		int[] map = new int[result.length];
		for(int i = 0; i < map.length; ++i)
			map[i] = 1;
		for(int i = 0; i < result.length; ++i)
			++map[result[i]];

		for(int i = 0; i < result.length; ++i)
		{
			if(result[i] != map[i])
				return false;
		}
		return true;
	}
}
