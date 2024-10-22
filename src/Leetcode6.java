public class Leetcode6 {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
    }

    public static String convert(String s, int numRows) {
        
        StringBuilder[] sbarr = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbarr[i] = new StringBuilder();
        }

        int index = 0;
        while(index < s.length()){

            int currentArray;
            for (currentArray = 0; currentArray < numRows && index<s.length(); currentArray++) {
                sbarr[currentArray].append(s.charAt(index++));
            }

            for (currentArray = numRows-2; currentArray >0  && index<s.length(); currentArray--) {
                sbarr[currentArray].append(s.charAt(index++));
            }

        }

        StringBuilder sb = new StringBuilder();
        for(StringBuilder sba : sbarr){
            sb.append(sba);
        }
        return  sb.toString();
        
    }

}
