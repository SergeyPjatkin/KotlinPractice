package com.practice.sorting


class MergeSort {

    fun sort(array: Array<Int>): Array<Int> =
        mergeSort(array, 0, array.size - 1).let {
            array
        }

    private fun mergeSort(array: Array<Int>, l: Int, r: Int) {
        if (l < r) {    // Base case
            // Find the middle point
            val m = l + (r - l) / 2
            // Sort first and second halves.
            mergeSort(array, l, m)
            mergeSort(array, m + 1, r)
            // Merge the sorted halves.
            merge(array, l, m, r)
        }
    }

    private fun merge(array: Array<Int>, l: Int, m: Int, r: Int) {
        // Find sizes of two sub-arrays to be merged.
        val n1 = m - l + 1
        val n2 = r - m

        /* Create temp arrays with copy of input */
        val lArray = Array(n1) { i -> array[l + i] }
        val rArray = Array(n2) { i -> array[m + 1 + i] }

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        var i = 0
        var j = 0
        // Initial index of merged sub-array array
        var k = l

        while (i < n1 && j < n2) {
            if (lArray[i] <= rArray[j]) {
                array[k] = lArray[i]
                i++
            } else {
                array[k] = rArray[j]
                j++
            }
            k++
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            array[k] = lArray[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            array[k] = rArray[j];
            j++;
            k++;
        }
    }
}