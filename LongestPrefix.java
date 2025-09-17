package solutions;

public class LongestPrefix {
        public String longestCommonPrefix(String[] strs) {
            // Start by assuming the first string is the longest common prefix
            String lcp = strs[0]; //eg: lcp = "flower"

            // Step 2: Compare lcp with every other string in the array
            for(int i=0; i<strs.length; i++) {
                // Compare current string: strs[i] with lcp
                // Loop runs for: "flower", "flow", "flight"

                while(!(strs[i].startsWith(lcp))) {
                    // Check if current string starts with lcp
                    // For i = 2, strs[i] = "flight", lcp = "flower"
                    // "flight".startsWith("flower") → false
                    // So, shorten lcp: "flower" → "flowe", then "flow", etc.
                    // Cut off the last character of lcp

                    lcp = lcp.substring(0, lcp.length()-1);
                    // lcp becomes: "flowe" → "flow" → "flo" → "fl"

                    // If we reduce lcp to an empty string, it means no common prefix
                    if (lcp.isEmpty()) {
                        return ""; // early exit
                    }
                }
                // If lcp matches the beginning of the current string,
                // continue to next string.
            }
            // Step 3: After all strings checked, return the final lcp

            return lcp; // "fl"
        }

        public static void main(String[] args){
            String[] testCases={"flower", "flow", "flight"};

            LongestPrefix lp= new LongestPrefix();

                String result=lp.longestCommonPrefix(testCases);
                System.out.println(result);

        }
}

/*
class LongestPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                // If current string is too short or characters don't match
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0]; // Entire first string is the prefix
    }
}
* */