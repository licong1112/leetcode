package leetcode_3rd_round;

public class ExcelColumnSheetNumber {
  public static void main(String[] args) {
    ExcelColumnSheetNumber test = new ExcelColumnSheetNumber();
    
    System.out.println(test.titleToNumber("AAA"));
  }
  
  public int titleToNumber(String s) {
    int result = 0;
    int base = 1;
    for (int i = s.length()-1; i >= 0; --i) {
      char c = s.charAt(i);
      result += (c - 'A' + 1) * base;
      base *= 26;
    }
    return result;
  }
}
