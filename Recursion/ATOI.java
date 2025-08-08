/*
    Below there are two approaches, 1 is we will do process for each character of given string and takes extra space
    In 2 approach we are stopping as long as it reaches max integer and no extra space.
 */
//Approach - 1
class ATOI {
    public void removeLeadSpace(StringBuilder s){
        int i = 0;
        while(i < s.length() && s.charAt(i) == ' ') i++;
        s.delete(0, i);
    }
    public void removeLeadZero(StringBuilder s){
        int i = 0;
        while(i < s.length() && s.charAt(i) == '0') i++;
        s.delete(0, i);
    }
    public void nonIntegerNumber(StringBuilder s){
        int i = 0;
        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') i++;
        s.delete(i, s.length());
    }
    public int myAtoi(String s) {
        StringBuilder ss = new StringBuilder(s);
        removeLeadSpace(ss);
        char sign = (ss.length() > 0 && (ss.charAt(0) == '+' || ss.charAt(0) == '-')) ? ss.charAt(0) : ' ';
        if(sign != ' ') ss.delete(0, 1);
        removeLeadZero(ss);
        nonIntegerNumber(ss);
        if(ss.length() > 10) return sign == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        String maxStr = "2147483647", minStr = "2147483648";
        if((sign == '+' || sign == ' ') && ss.length() == 10 && ss.toString().compareTo(maxStr) >= 0) return Integer.MAX_VALUE;
        if(sign == '-' && ss.length() == 10 && ss.toString().compareTo(minStr) >= 0) return Integer.MIN_VALUE;
        if(ss.length() == 0) ss.append("0");
        return (sign == '-' ? -1 : 1 ) * Integer.parseInt(ss.toString());
    }
}

//Approach - 2
public class StringToInteger {
    public int myAtoi(String s) {
        int res = 0;
        int sign = 1;
        int i = 0;

        // Skip leading spaces
        while (i < s.length() && s.charAt(i) == ' ') i++;

        // Handle sign
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Process digits
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Overflow check BEFORE multiplying
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + digit;
            i++;
        }

        return res * sign;
    }

    public static void main(String[] args) {
        StringToInteger obj = new StringToInteger();
        System.out.println(obj.myAtoi("   -042"));  // Output: -42
        System.out.println(obj.myAtoi("4193 with words")); // Output: 4193
        System.out.println(obj.myAtoi("91283472332")); // Output: 2147483647
    }
}