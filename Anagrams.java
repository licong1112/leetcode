/**
 * Practiced on 11/20/2012
 * 
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 * 
 * ==============================
 * Not hard one, but plenty of labor work, such as sort each string.
 * Need to get familiar with Iterator.
 */

package com.congli.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Anagrams {

	public static void main(String[] args) {
		Anagrams test = new Anagrams();
		String[] strs = {"and", "dan", "test"};
		ArrayList<String> list = test.anagrams(strs);
	}

	public ArrayList<String> anagrams(String[] strs) 
	{
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        ArrayList<String> result = new ArrayList<String>();
        for(int i = 0; i < strs.length; ++i)
        {
        	String key = sort(strs[i]);
            if(map.containsKey(key))
            {
                map.get(key).add(strs[i]);
            }
            else
            {
                ArrayList<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(key, list);
            }
        }
        
        Iterator it = map.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry entry = (Entry) it.next();
            ArrayList<String> list = (ArrayList<String>) entry.getValue();
            if(list.size() <= 1) continue;
            else
            {
                for(String str : list)
                {
                    result.add(str);
                }
            }
        }
        return result;
    }
    
	private String sort(String str)
	{
		char[] strArray = str.toCharArray();
		mergeSort(strArray, 0, str.length()-1);
		String newStr = "";
		for(char c : strArray)
		{
			newStr += c;
		}
		return newStr;
	}
	
	private void mergeSort(char[] str, int start, int end)
	{
		if(start >= end) return;
		int mid = start + (end - start) / 2;
		mergeSort(str, start, mid);
		mergeSort(str, mid+1, end);
		merge(str, start, mid, end);
	}
	
	private void merge(char[] str, int start, int mid, int end)
	{
		char[] temp = new char[end-start+1];
		int aInd = start;
		int bInd = mid+1;
		for(int i = 0; i < temp.length; ++i)
		{
			if(aInd <= mid && bInd <= end)
			{
				temp[i] = str[aInd] < str[bInd] ? str[aInd++] : str[bInd++];
			}
			else if(aInd <= mid)
			{
				temp[i] = str[aInd++];
			}
			else
			{
				temp[i] = str[bInd++];
			}
		}
		for(int i = 0; i < temp.length; ++i)
		{
			str[start++] = temp[i];
		}
	}
}
