public class Leetcode10 {

    public static void main(String[] args) {
        System.out.println(isMatch("bbbba",".*a*a"));
    }

    public static boolean isMatch(String s, String p) {

        int currentIndex = 0;
        int i = 0;
        char precedingChar = ' ';
        for(i=0; i<p.length() && currentIndex<s.length(); i++){

            char c = p.charAt(i);
            if(c == '.'){
                currentIndex++;
                precedingChar='.';
                continue;
            }
            if(s.charAt(currentIndex) == c){
                currentIndex++;
                precedingChar = c;
                continue;
            }
            if(c == '*'){

                for(int j=currentIndex; j<s.length();j++){
                    if(precedingChar=='.' || s.charAt(j) == precedingChar){
                        boolean matched = isMatch(s.substring(j+1,s.length()), p.substring(i+1,p.length()));
                        if(matched == true)
                            return  true;
                    }else{
                        break;
                    }
                }
            }else{
                if(s.charAt(currentIndex) != c){
                    if((i+1)<p.length() && p.charAt(i+1) == '*'){
                        precedingChar = c;
                    }else
                        return false;
                }
            }


        }
        if(currentIndex==s.length()){
            if(i==p.length())
                return true;
            else{
                int starStep = 0;
                for(;i<p.length();i++){
                    if(p.charAt(i) == '*')
                        starStep=0;
                    else
                        starStep++;
                }
                if(starStep>0)
                    return false;
                return true;
            }
        }
        return false;
    }

}


