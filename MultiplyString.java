/**
 * Practiced on 12/12/2012
 * 
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * 
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 
 * ===============================
 * The idea is just do multiplication as what we learned in elementary school.
 * 
 * The function "multiply" is written originally by myself. It's ugly.
 * Then I found a prettier way to do it. Then I wrote the function "prettierMultiply".
 * The codes are easy to follow.
 */

package com.congli.leetcode;

import java.util.ArrayList;

public class MultiplyString {
	
	public String prettierMultiply(String num1, String num2) 
    {
        if(num1.equals("0") || num2.equals("0")) return "0";
        
        int[] array = new int[num1.length()+num2.length()+1];

        for(int i = 0; i < num1.length(); ++i)
        {
            int carrier = 0;
        	for(int j = 0; j < num2.length(); ++j)
        	{
        		int dig1 = num1.charAt(num1.length()-i-1)-'0';
            	int dig2 = num2.charAt(num2.length()-j-1)-'0';
        		int digResult = (dig1*dig2 + array[i+j] + carrier) % 10;
        		carrier = (dig1*dig2 + array[i+j] + carrier) / 10;
        		array[i+j] = digResult;
        	}
        	array[i+num2.length()] = carrier;
        }
        
        int i = array.length-1;
        while(i > 0 && array[i] == 0)
            --i;
        
        String result = "";
        while(i >= 0)
        	result += Integer.toString(array[i--]);
        
        return result;
    }

	
	// The following codes are ugly.
	public String multiply(String num1, String num2) 
	{
        if(num1 == null || num1.length() == 0) return num2;
        if(num2 == null || num2.length() == 0) return num1;
        if(num1.equals("0") || num2.equals("0")) return "0";
        
        int num2Ind = num2.length()-1;
        
        String result = "0";
        while(num2Ind >= 0)
        {
            String multiplied = multiplyDigit(num1, num2.charAt(num2Ind), num2.length()-num2Ind);
            --num2Ind;
            result = add(result, multiplied);
        }
        return result;
    }
    
    private String multiplyDigit(String num1, char num2Char, int level)
    {
        if(num1 == null || num1.length() == 0) return String.valueOf(num2Char);
        
        
        int carrier[] = new int[1];
        int num1Ind = num1.length()-1;
        int num2 = num2Char -'0';
        
        String result = "";
        while(num1Ind >= 0)
        {
            int digResult = multiplyHelper(num1.charAt(num1Ind--)-'0', num2, carrier);
            result = Integer.toString(digResult)+result;
        }
        if(carrier[0] > 0) result = Integer.toString(carrier[0])+result;
        
        while(level > 1)
        {
            result += "0";
            --level;
        }
            
        return result;
    }
    
    private int multiplyHelper(int a, int b, int[] carrier)
    {
        int result = (a*b+carrier[0])%10;
        carrier[0] = (a*b+carrier[0])/10;
        return result;
    }
    
    private String add(String num1, String num2)
    {
        if(num1 == null || num1.length() == 0) return num2;
        if(num2 == null || num2.length() == 0) return num1;
        
        int carrier[] = new int[1];
        int num1Ind = num1.length()-1;
        int num2Ind = num2.length()-1;
        
        String result = "";
        while(num1Ind >= 0 || num2Ind >= 0)
        {
            int digResult = 0;
            if(num1Ind >= 0 && num2Ind >= 0)
            {
                digResult = addHelper(num1.charAt(num1Ind--)-'0', num2.charAt(num2Ind--)-'0', carrier); 
            }
            else if(num1Ind >= 0)
            {
                digResult = addHelper(num1.charAt(num1Ind--)-'0', 0, carrier); 
            }
            else
            {
                digResult = addHelper(0, num2.charAt(num2Ind--)-'0', carrier); 
            }
            result = Integer.toString(digResult)+result;
        }
        if(carrier[0] > 0) result = Integer.toString(carrier[0])+result;
        return result;
    }
    
    private int addHelper(int a, int b, int[] carrier)
    {
        int result = (a+b+carrier[0])%10;
        carrier[0] = (a+b+carrier[0])/10;
        return result;
    }
}