public class Leetcode13 {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {

        int total = 0;

        for (int i = 0; i < s.length(); i++) {

            switch (s.charAt(i)){
                case 'I':
                    if((i+1)<s.length() && (s.charAt(i+1)=='V' || s.charAt(i+1)=='X')){
                        total-=1;
                        break;
                    }
                    total+=1;
                    break;
                case 'V':
                    total+=5;
                    break;
                case 'X':
                    if((i+1)<s.length() && (s.charAt(i+1)=='L' || s.charAt(i+1)=='C')){
                        total-=10;
                        break;
                    }
                    total+=10;
                    break;
                case 'L':
                    total+=50;
                    break;
                case 'C':
                    if((i+1)<s.length() && (s.charAt(i+1)=='D' || s.charAt(i+1)=='M')){
                        total-=100;
                        break;
                    }
                    total+=100;
                    break;
                case 'D':
                    total+=500;
                    break;
                case 'M':
                    total+=1000;
                    break;

            }

        }

        return total;

    }
}
