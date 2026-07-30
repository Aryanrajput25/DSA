

class Solution {
    int count = 0;

    public int reversePairs(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return count;
    }

    public void merge(int[] arr, int low, int mid, int high) {

        List<Integer> temp = new ArrayList<>();

        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left++]);
            } else {
                temp.add(arr[right++]);
            }
        }

        while (left <= mid) {
            temp.add(arr[left++]);
        }

        while (right <= high) {
            temp.add(arr[right++]);
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public void countPairs(int[] arr, int low, int mid, int high) {

        int right = mid + 1;

        for (int i = low; i <= mid; i++) {

            while (right <= high && arr[i] > 2L * arr[right]) {
                right++;
            }

            count += (right - (mid + 1));
        }
    }

    public void mergeSort(int[] arr, int low, int high) {

        if (low >= high)
            return;

        int mid = low + (high - low) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        countPairs(arr, low, mid, high);

        merge(arr, low, mid, high);
    }
}