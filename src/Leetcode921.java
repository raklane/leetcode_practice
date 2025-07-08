import java.util.Map;

public class Leetcode921 {

    public int minAddToMakeValid(String s) {

        if(s.length()==0)
            return 0;

        int totalOpen = 0;
        int totalClose = 0;
        int currentOpen = 0;
        int currentClose = 0;
        int totalOpenRequired = 0;
        int totalCloseRequired = 0;
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if(c == '('){
                totalOpen++;
                currentOpen++;
            }else{
                totalClose++;
                if(totalClose>totalOpen) {
                    totalClose--;
                    totalOpenRequired++;
                }
                if(currentOpen>0) currentOpen--;
            }

        }
        if(totalOpen>totalClose) totalCloseRequired = totalOpen-currentOpen-totalClose;
        if(currentOpen>0) totalCloseRequired += currentOpen;

        return Math.abs(totalOpenRequired + totalCloseRequired);

    }

}
