public class Leetcode12 {

    public static void main(String[] args) {
        System.out.println(intToRoman(3749));
    }

    public static String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();
        int division = 0;
        if(num>=1000){
            division = num/1000;
            num = num % 1000;
            while (division>0){
                sb.append('M');
                division--;
            }
        }

        if(num >= 100){
            division = num/100;
            num = num %100;
            if(division==9){
                sb.append("CM");
                division=0;
            }else if(division==4){
                sb.append("CD");
                division=0;
            }else if(division>=5){
                sb.append('D');
            }
            division = division>=5?division-5:division;
            while (division>0){
                sb.append('C');
                division--;
            }
        }

        if(num >= 10){
            division = num/10;
            num = num %10;
            if(division==9){
                sb.append("XC");
                division=0;
            }
            else if(division==4){
                sb.append("XL");
                division=0;
            }
            else if(division>=5){
                sb.append('L');
            }
            division = division>=5?division-5:division;
            while (division>0){
                sb.append('X');
                division--;
            }
        }

        if(num >= 1){
            division = num;
            if(division==9){
                sb.append("IX");
                division=0;
            }
            else if(division==4){
                sb.append("IV");
                division=0;
            }
            else if(division>=5){
                sb.append('V');
            }
            division = division>=5?division-5:division;
            while (division>0){
                sb.append('I');
                division--;
            }
        }

        return  sb.toString();
    }

}

