package mediumLC;

import java.util.*;

// ["abc" , "bcd" , "cde", "ef", "za", "acf"]
// [["abc" , "bcd" , "cde"], ["ef", "za"]]

//1. Find the sequence - +1, +1 or -1 or +2,+3
//2. create a HashFunc - with this sequence as key and strings as value
//3. Return ValueSet from HashMap

/**
 * TC - O(N*K), N = no.of strigs, K is the length of each string
 * SC - O(N*K), worst case = N strings might take O(K) space each {creating hash for each string}
 */
public class groupShiftedStrings {
    public static void main(String[] args){
        String[] arr = new String[]{"abc" , "bcd" , "cde", "ef", "za", "acf"};
        System.out.println(groupShiftedStrings(arr));
    }
    public static String getHashKey(String str){
        char[] ch = str.toCharArray();
        StringBuilder hashKey = new StringBuilder();

        for(int i=1; i<ch.length; i++){
            int digit = (char) (ch[i] - ch[i-1] + 26 ) % 26 - 'a';
            hashKey.append(digit);
        }
        return hashKey.toString();
    }

    public static List<List<String>> groupShiftedStrings(String[] arr){
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(String str: arr){
            String hashKey = getHashKey(str);
            map.putIfAbsent(hashKey, new ArrayList<>());
            map.get(hashKey).add(str);
        }

        for(List<String> values: map.values()){
            result.add(values);
        }
        return result;
    }
}
