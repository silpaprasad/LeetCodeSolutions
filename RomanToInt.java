package solutions;

class RomanToInt {
    public int romanToInt(String s) {
        int ans=0,num=0;
        for(int i=s.length()-1;i>=0;i--){
            switch(s.charAt(i)){
                case 'I' : num = 1;break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            if(4*num<ans) ans-=num;
            else ans+=num;
        }
        return ans;
    }
    public static void main(String[] args) {
        RomanToInt solution = new RomanToInt();

        // Test cases like LeetCode
        String[] testCases = {
                "III",      // 3
                "IV",       // 4
                "IX",       // 9
                "LVIII",    // 58
                "MCMXCIV",  // 1994
                "XL",       // 40
                "XC",       // 90
                "CD",       // 400
                "CM",       // 900
                "MMXXV"     // 2025
        };

        System.out.println("Roman to Integer Conversion:\n");

        for (String roman : testCases) {
            int result = solution.romanToInt(roman);
            System.out.printf("Input: %s Output: %d%n", roman, result);
        }
    }
}

