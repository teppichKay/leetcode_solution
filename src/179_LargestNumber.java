class Solution {
  public String largestNumber(int[] nums) {
    String[] strings = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      strings[i] = String.valueOf(nums[i]);
    }
    // sort the new array
    Arrays.sort(strings, (String s1, String s2) -> {
      String left = s1+s2;
      String right = s2+s1;
      return -left.compareTo(right);
    });

    // merge all the strings
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < strings.length; i++ ) {
      sb.append(strings[i]);
    };

    // remove zero from the head
    while (sb.charAt(0) == '0' && sb.length() > 1) {
      sb.deleteCharAt(0);
    }
    
    return sb.toString();
  }
}
