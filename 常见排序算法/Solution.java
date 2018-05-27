package com.yzc;

public class Sort {
    // 冒泡排序
    public static int[] bubbleSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
        return array;
    }
    
    // 选择排序
    public static int[] selectionSort(int[] array) {
        int len = array.length;
        int minIndex;
        for (int i = 0; i < len; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(array, minIndex, i);
            }
        }
        return array;
    }

    // 插入排序
    public static int[] insertionSort(int[] array) {
        int len = array.length;
        int preIndex;
        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            int temp = array[i];
            while (preIndex >= 0 && array[preIndex] > temp) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = temp;
        }
        return array;
    }

    // 希尔排序
    public static int[] shellSort(int[] array) {
        int len = array.length;
        int gap;
        for (gap = len / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < gap; i++) {
                int preIndex;
                int temp;
                for (int j = i + gap; j < len; j += gap) {
                    preIndex = j - gap;
                    temp = array[j];
                    while (preIndex >= 0 && array[preIndex] > temp) {
                        array[preIndex + gap] = array[preIndex];
                        preIndex -= gap;
                    }
                    array[preIndex + gap] = temp;
                }
            }
        }
        return array;
    }

    // 快速排序
    public static int[] quickSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = partition(array, start, end);
            quickSort(array, 0, mid - 1);
            quickSort(array, mid + 1, end);
        }
        return array;
    }

    // 归并排序
    public static int[] mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
        return a;
    }

    // 堆排序
    public static int[] heapSort(int a[]) {
        buildMaxHeap(a);
        int len = a.length;
        for (int i = a.length - 1; i > 0; i--) {
            swap(a, i, 0);
            len--;
            heapify(a, 0, len);
        }
        return a;
    }

    private static void buildMaxHeap(int[] a) {
        for (int i = a.length / 2; i >= 0; i--) {
            heapify(a, i, a.length);
        }
    }

    private static void heapify(int[] a, int i, int length) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int lagest = i;

        if (left < length && a[left] > a[lagest]) {
            lagest = left;
        }

        if (right < length && a[right] > a[lagest]) {
            lagest = right;
        }

        if (lagest != i) {
            swap(a, i, lagest);
            heapify(a, lagest, length);
        }
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int index = 0;
        int i = low, j = mid + 1;
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[index] = a[i];
                i++;
                index++;
            } else {
                temp[index] = a[j];
                j++;
                index++;
            }
        }
        while (i <= mid) {
            temp[index] = a[i];
            i++;
            index++;
        }
        while (j <= high) {
            temp[index] = a[j];
            j++;
            index++;
        }
        for (int k = 0; k < temp.length; k++) {
            a[low + k] = temp[k];
        }
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = array[start];
        while (start < end) {
            while (start < end && array[end] > pivot) {
                end--;
            }
            array[start] = array[end];
            while (start < end && array[start] < pivot) {
                start++;
            }
            array[end] = array[start];
        }
        array[start] = pivot;
        return start;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println("hallo");
        int[] res = heapSort(new int[] { 3, 5, 2, 15, 7, 8, 11 });
        for (int item : res) {
            System.out.println(item);
        }
    }
}
