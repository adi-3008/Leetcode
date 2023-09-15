package prefixSum;

public class MinimumPenaltyForShop {

    public static void main(String[] args) {
        System.out.println(bestClosingTime("YYYY"));
    }
    public static int bestClosingTime(String customers) {
        int n = customers.length();
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        if(customers.charAt(0) == 'N')
            prefix[0]++;

        for(int i = 1; i < n; i++){
            if(customers.charAt(i) == 'N')
                prefix[i]++;
            prefix[i] += prefix[i - 1];
        }

        if(customers.charAt(n - 1) == 'Y')
            suffix[n - 1]++;

        for(int i = n - 2; i >= 0; i--){
            if(customers.charAt(i) == 'Y')
                suffix[i]++;
            suffix[i] += suffix[i + 1];
        }

        int minClosingTime = 0;
        int minPenalty = suffix[0];

        for(int i = 1; i < n; i++){
            int newPanelty = suffix[i] + prefix[i - 1];
            if(newPanelty < minPenalty){
                minPenalty = newPanelty;
                minClosingTime = i;
            }
        }

        if(minPenalty > prefix[n - 1]){
            minPenalty = prefix[n - 1];
            minClosingTime = n;
        }

        return minClosingTime;
    }
}
