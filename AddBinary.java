package com.congli.leetcode;

/**
 * Practiced on 11/19/2012.
 * 
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100"
 */
public class AddBinary {
	
	public static void main(String[] args)
	{
		AddBinary sl = new AddBinary();
		System.out.println(sl.addBinary("1", "111"));
	}
	
    public String addBinary(String a, String b) {
       if(a == null || a == "") return b;
       if(b == null || a == "") return a;
       
       char[] resultChar = new char[Math.max(a.length(), b.length())+1];
       resultChar[0] = '0';
       int aInd = a.length()-1;
       int bInd = b.length()-1;
       char[] carry = {'0'};
       
       for(int i = Math.max(aInd, bInd)+1; i >= 0; --i)
       {
	       if(aInd < 0 && bInd < 0) resultChar[i] = carry[0];
	   	   else if(aInd < 0) resultChar[i] = helper(b.charAt(bInd--), '0', carry);
           else if(bInd < 0) resultChar[i] = helper(a.charAt(aInd--), '0', carry);
           else resultChar[i] = helper(a.charAt(aInd--), b.charAt(bInd--), carry);
       }
       
       String result = "";
       for(int i = (resultChar[0] == '0' ? 1 : 0); i < resultChar.length; ++i)
       {
           result += resultChar[i];
       }
       return result;
   }
    
   private char helper(char a, char b, char[] carry)
   {
       if(a == b)
       {
           char result = carry[0] == '1' ? '1' : '0';
           carry[0] = a == '1' ? '1' : '0';
           return result;
       }
       else return carry[0] == '1' ? '0' : '1';
   }
}