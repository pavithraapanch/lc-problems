package easyLC;

public class validWordAbbreviation {

    //TC - O(min(wordlength, abbrlength))
    //SC - O(1)

    //w - publication
    //a - p5at3

    //w - publication
    //a - pc5at3 - false
    public static boolean validWorAbbr(String word, String abbr){
        // 2 pointer approach
        int i = 0;
        int j = 0;
        int w = word.length();
        int a = abbr.length();

        while(i<w && j<a) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
                continue;
            }
            if (!Character.isDigit(abbr.charAt(j)) && abbr.charAt(j) == '0') return false;
            int temp = 0;
            while (j<a && Character.isDigit(abbr.charAt(j))) {
                temp = temp * 10 + abbr.charAt(j) - '0';
                j++;
            }
            while (temp > 0) {
                i++;
                temp-= 1;
            }
        }
        return (i == w && j == a);
    }
}
