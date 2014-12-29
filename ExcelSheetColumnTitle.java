package leetcode_3rd_round;

public class ExcelSheetColumnTitle {
  public String convertToTitle(int n) {
    StringBuilder sb = new StringBuilder();
    
    --n;
    while (n >= 0) {
      int num = n % 26;
      n = n / 26 - 1;
      sb.insert(0, (char)('A' + num));
    }
    
    return sb.toString();
  }
}
