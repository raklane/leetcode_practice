public class Leetcode14 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 201; i++) {
            char c = ' ';
            for (int j = 0; j < strs.length; j++) {

                if(strs[j].length()==i)
                    return sb.toString();

                if(strs[j].charAt(i) != c && c != ' ')
                    return sb.toString();

                if(c==' ')
                    c = strs[j].charAt(i);
            }
            sb.append(c);
            
        }
        return sb.toString();
    }
    
}
