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
        msHelper(pairs, 0, pairs.size() - 1);
        return pairs;
    }


    public void msHelper(List<Pair> pairs, int s, int e) {
        if (e - s + 1 <= 1) return;

        int m = s + (e - s) / 2;

        msHelper(pairs, s, m);
        msHelper(pairs, m + 1, e);

        merge(pairs, s, m, e);

    }


    public void merge(List<Pair> pairs, int s, int m, int e) {
        ArrayList<Pair> startArray = new ArrayList<>(pairs.subList(s, m + 1));
        ArrayList<Pair> endArray = new ArrayList<>(pairs.subList(m + 1, e + 1));

        int k = s;
        int l = 0;
        int r = 0;

        while (l < startArray.size() && r < endArray.size()) {
            if (startArray.get(l).key <= endArray.get(r).key) {
                pairs.set(k, startArray.get(l));
                l++;
            } else {
                pairs.set(k, endArray.get(r));
                r++;
            }
            k++;
        }

        while (l < startArray.size()) {
            pairs.set(k, startArray.get(l));
            l++;
            k++;
        }

        while (r < endArray.size()) {
            pairs.set(k, endArray.get(r));
            r++;
            k++;
        }

    }
}
