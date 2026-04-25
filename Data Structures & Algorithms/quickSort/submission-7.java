// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        quickSorthelper(pairs, 0, pairs.size() - 1);
        return pairs;
    }

    public void quickSorthelper(List<Pair> pairs, int s, int e)
    {
        if(s > e)
        {
            return;
        }

        Pair pivot = pairs.get(e);
        int left = s;
        int i = s;
        while(i < e)
        {
            if(pairs.get(i).key < pivot.key)
            {
                Pair temp = pairs.get(i);
                pairs.set(i, pairs.get(left));
                pairs.set(left, temp);
                left++;
            }
            i++;
        }

        pairs.set(e, pairs.get(left));
        pairs.set(left, pivot);

        quickSorthelper(pairs, s, left - 1);
        quickSorthelper(pairs, left + 1, e);
    }
}
