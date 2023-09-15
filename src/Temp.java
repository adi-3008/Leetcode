import java.util.Arrays;
import java.util.Collections;

public class Temp {
    public int minDeletions(String s) {
        Integer[] frequency = new Integer[26];
        for(char ch : s.toCharArray()){
            frequency[ch - 'a']++;
        }
        Arrays.sort(frequency, Collections.reverseOrder());
        System.out.println(Arrays.toString(frequency));
        int min = 0;
        for(int i = 1; i < 26; i++){
            if(frequency[i] == 0) break;
            if(frequency[i] == frequency[i - 1]){
                frequency[i]--;
                min++;
            }
        }
        return min;
    }
}
