class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split("\\s+");
        if (words == null || words.length == 0) return 0;
        String last = words[words.length-1];
        return last.length();
    }
}
