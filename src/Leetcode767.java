public class Leetcode767 {

    public static void main(String[] args) {

    }

    public String reorganizeString(String s) {

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i)  + " " + i);
            count[s.charAt(i) - 'a']++;
        }
        int max = 0;
        int maxIndex = -1;
        int otherLetters = 0;
        for (int i = 0; i < count.length; i++) {
            if(count[i] > max){
                max = count[i];
                maxIndex = i;
            }
        }
        if(max > (s.length()-max+1)) return "";
        //aaaaabbccdddeeee     abc ade abc ade ade e
        StringBuilder sb = new StringBuilder(s.length());
        int intervalsToFill = max-1;
        if(intervalsToFill == 0) return s;
        otherLetters = s.length() - max;
        int letterPerFill = otherLetters/intervalsToFill;

        int currentIndex = 0;
        while (max != 0){
            sb.append((char)(maxIndex+'a'));
            max--;
            int intermediateLetterscount = 0;
            while(intermediateLetterscount < letterPerFill && max>0){
                if(currentIndex==26) currentIndex=0;
                if(currentIndex == maxIndex || count[currentIndex] == 0){
                    currentIndex++;
                    continue;
                }
                sb.append((char)(currentIndex+'a'));
                count[currentIndex]--;
                intermediateLetterscount++;
                currentIndex++;
            }
        }
        StringBuilder sbPendingLetter = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            if(i==maxIndex) continue;
            if(sb.length() + sbPendingLetter.length() == s.length()) break;
            if(count[i] != 0){
                sb.append((char)(i+'a'));
                count[i]--;
            }
        }
        return sbPendingLetter.toString() + sb.toString();

    }

}
