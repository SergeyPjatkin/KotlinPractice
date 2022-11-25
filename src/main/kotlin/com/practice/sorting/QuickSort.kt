package com.practice.sorting


class QuickSort {

    fun sort(array: Array<Int>): Array<Int> =
        sort(array, 0, array.size - 1).let {
            array
        }

    private fun sort(array: Array<Int>, low: Int, high: Int) {
        if (low < high) {
            // pi is partitioning index, arr[p]
            // is now at right place
            val pi = partition(array, low, high)
            // Separately sort elements before
            // partition and after partition
            sort(array, low, pi - 1);
            sort(array, pi + 1, high);
        }
    }

    private fun partition(array: Array<Int>, low: Int, high: Int): Int {

        fun swap(array: Array<Int>, i: Int, j: Int) {
            val temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        // pivot
        val pivot: Int = array.get(high)

        // Index of smaller element and indicates the right position
        // of pivot found so far.
        var i = low - 1
        for (j in low..high - 1) {

            // If current element is smaller than the pivot
            if (array[j] < pivot) {
                // Increment index of smaller element
                i++
                swap(array, i, j)
            }
        }
        swap(array, i + 1, high);
        return (i + 1);
    }
}