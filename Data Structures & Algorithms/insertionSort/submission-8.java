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
        // need a arraylist for res
        ArrayList<List<Pair>> res = new ArrayList();
        // check if the size isnt zero
        if (pairs.size() == 0) return new ArrayList<List<Pair>>();

        res.add(new ArrayList<>(pairs));
        // use two loops
        // start main index at one
        int i = 1; 
        while (i < pairs.size()) {
            // need a var for j to be behind 1
            int j = i - 1;
            Pair temp = pairs.get(i);
            while (j >= 0 && pairs.get(j).key > temp.key) { 
                pairs.set(j + 1, pairs.get(j));
                j--;
            }
            pairs.set(j + 1, temp);
            // need a arraylist for each state
            ArrayList<Pair> clone = new ArrayList<>(pairs);
            // iterate i
            i++;
            // add clone to res
            res.add(clone);
        } 
        //return res
        return res;

    }
}
