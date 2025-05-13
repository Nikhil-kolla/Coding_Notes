/*
LC 451 - https://leetcode.com/problems/sort-characters-by-frequency/description/
TC - O(log N)
SC - O(N)
 */

public class FrequencySort {

    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for(char ch: s.toCharArray())
            freqMap.put(ch, freqMap.getOrDefault(ch,0)+1);

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b) -> (b.getValue()-a.getValue()));

        pq.addAll(freqMap.entrySet());

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> currEntry = pq.poll();

            for(int i=0;i<currEntry.getValue();i++)
                sb.append(currEntry.getKey());
        }

        return sb.toString();
    }
}
