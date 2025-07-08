public class Leetcode161 {
    public static void main(String[] args){
        System.out.println(isOneEditDistance("ab","acb"));
    }
    public static boolean isOneEditDistance(String s, String t) {

        if(Math.abs(s.length()-t.length())>1)
            return false;
        int numOfChanges = 0;

        if(s.length()>t.length())
            numOfChanges += makeChanges(s.toString(),t.toString());
        else
            numOfChanges += makeChanges(t.toString(),s.toString());

        return numOfChanges==1;

    }

    private static int makeChanges(String l1, String s1){
        if(l1.length() == s1.length()){
            int numOfDifferentChars = 0;
            for (int i = 0; i < l1.length(); i++) {
                if(l1.charAt(i) != s1.charAt(i))
                    numOfDifferentChars++;
            }
            return numOfDifferentChars;
        }
        int i = 0;
        for (; i < s1.length(); i++) {
            if(l1.charAt(i) != s1.charAt(i))
                break;
        }
        for (; i < l1.length()-1; i++) {
            if(s1.charAt(i) != l1.charAt(i+1))
                return 2;
        }
        return 1;
    }
}
