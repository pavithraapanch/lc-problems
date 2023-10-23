package mediumLC;

public class minAddToMakeParanthesesValid {

    // ()), ((()
    public int minAddToMakeValid(String s) {
        int left = 0, right = 0;
        for(char ch : s.toCharArray()){
            if(ch == '(')
                left++;
            else if(ch == ')'){
                if(left > 0) left--;
                else right++;
            }
        }
        return left+right;
    }
}
