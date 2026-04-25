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
        // have a res arraylist
        ArrayList<List<Pair>> res = new ArrayList<>();
        if(pairs.size() > 0) res.add(new ArrayList<>(pairs));

        int i = 1;
        // have two loops
        // one loop to traverse throught the main array
        while (i < pairs.size()) {
            int j = i - 1;
            Pair curr = pairs.get(i);
            // traverse down the array untill you reach -1
            while (j >= 0 && pairs.get(j).key > curr.key ) {
                pairs.set(j + 1, pairs.get(j));
                j--;
            }
            pairs.set(j + 1, curr);
            // have a clone keep each states
            ArrayList clone = new ArrayList<>(pairs);
            res.add(clone);
            i++;
        }
        return res;
        
    }
}
