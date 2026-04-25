// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> res = new ArrayList<>();
        int n = pairs.size();

        for(int i = 0; i < n; i++)
        {
            int j = i - 1;
            while(j >= 0 && (pairs.get(j)).key> (pairs.get(j+1)).key)
            {
                Pair temp = new Pair(pairs.get(j+1).key, pairs.get(j+1).value);
                pairs.set(j+1, pairs.get(j));
                pairs.set(j, temp);
                j--;
            }
            List<Pair> cloneList = new ArrayList<>(pairs);
            res.add(cloneList);
        }
        return res;
    }
}
