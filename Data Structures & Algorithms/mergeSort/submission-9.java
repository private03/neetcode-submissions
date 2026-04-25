// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        if(pairs == null || pairs.size() == 0)
        {
            return pairs;
        }

        return mergeSorthelper(pairs, 0, pairs.size() - 1);

    }

    public List<Pair> mergeSorthelper(List <Pair> pairs, int s, int e)
    {

        if(e - s + 1 <= 1)
        {
            return pairs;
        }

        int m = s + (e - s) / 2;

        mergeSorthelper(pairs, s, m);
        mergeSorthelper(pairs, m + 1, e);
        merge(pairs, s, m, e);

        return pairs;
    }

    public void merge(List <Pair> pairs, int s, int m, int e)
    {
        List<Pair> L = new ArrayList(pairs.subList(s, m + 1));
        List<Pair> R = new ArrayList(pairs.subList(m + 1 , e + 1));

        int l = 0;
        int r = 0;
        int k = s;


        while(l < L.size() && r < R.size())
        {
            if(L.get(l).key <= R.get(r).key)
            {
                pairs.set(k, L.get(l));
                l++;
            }
            else 
            {
                pairs.set(k, R.get(r));
                r++; 
            }
            k++;
        }

        while(l < L.size())
        {
            pairs.set(k, L.get(l));
            l++;
            k++;
        }

        while(r < R.size())
        {
            pairs.set(k, R.get(r));
            r++;
            k++;
        }
    }
}
