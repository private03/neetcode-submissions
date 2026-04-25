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
        return helperMergesort(pairs, 0, pairs.size()-1);
    }

    public List<Pair> helperMergesort(List<Pair> arr, int l, int r)
    {
        int m = (l + r) / 2;
        if(l < r)
        {
            helperMergesort(arr, l, m);
            helperMergesort(arr, m+1, r);
            Merge(arr, l, m, r);
        }
        return arr;
    }

    public void Merge(List<Pair> arr, int l, int m, int r)
    {
        int arrLength1 = m - l + 1;
        int arrLength2 = r - m;

        List<Pair> leftHalf = new ArrayList<Pair>();
        List<Pair> rightHalf = new ArrayList<Pair>();


        for(int i = 0; i < arrLength1; i++)
        {
            leftHalf.add(arr.get(l + i));
        }

        for(int j = 0; j < arrLength2; j++)
        {
            rightHalf.add(arr.get(m + 1 + j));
        }

        int i = 0;
        int j = 0;
        int k = l;

        while(i < leftHalf.size() && j < rightHalf.size())
        {
            if(leftHalf.get(i).key <= rightHalf.get(j).key)
            {
                arr.set(k,leftHalf.get(i)) ;
                i++;
            } else 
            {
                arr.set(k,rightHalf.get(j)); 
                j++;
            }
            k++;
        }

        while(i < leftHalf.size())
        {
            arr.set(k,leftHalf.get(i));
            i++;
            k++;
        }

        while(j < rightHalf.size())
        {
            arr.set(k,rightHalf.get(j));
            j++;
            k++;
        }

    }
}
