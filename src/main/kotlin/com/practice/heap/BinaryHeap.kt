package com.practice.heap

// impl: https://algorithmtutor.com/Data-Structures/Tree/Binary-Heaps/
//
// https://runestone.academy/ns/books/published/pythonds/Trees/BinaryHeapImplementation.html
// https://www.geeksforgeeks.org/binary-heap/

class BinaryHeap(val MAX_SIZE: Int) {

    private var heap: Array<Int> = Array(MAX_SIZE) { 0 }
    private var size = 0

    val maxValue: Int
        get() = heap[0]

    val heapArray: Array<Int>
        get() = heap.copyOfRange(0, size)

    fun build(input: Array<Int>) {
        if (input.size > heap.size) {
            throw Exception("Heap Overflow: Input size more then heap size.")
        }
        for (i in input.indices) {
            heap[i] = input[i]
        }
        size = input.size
        if (size < heap.size) {
            heap.fill(0, input.size, heap.size - 1)
        }

        for (i in size / 2 downTo 0) {
            maxHeapify(i)
        }
    }

    fun insert(data: Int) {
        if (size > MAX_SIZE) {
            throw Exception("Heap Overflow: Insert failed.")
        }
        // First insert the time at the last position of the array and move it up.
        heap[size] = data;
        size++

        // Move up until the heap property satisfies
        var i = size - 1
        while (i != 0 && heap[parent(i)] < heap[i]) {
            swap(i, parent(i))
            i = parent(i)
        }
    }

    fun extractMax(): Int {
        if( size == 0) {
            throw Exception("Heap empty")
        }
        val maxItem = maxValue

        // Replace the first item with the last item.
        heap[0] = heap[size - 1]
        size--

        // Maintain the heap property by heapifying the first item.
        maxHeapify(0);

        return maxItem
    }

    private fun parent(i: Int) = (i - 1) / 2

    private fun leftChild(i: Int) = 2 * i + 1

    private fun rightChild(i: Int) = 2 * i + 2

    private fun swap(i: Int, ii: Int) {
        val temp = heap[i]
        heap[i] = heap[ii]
        heap[ii] = temp
    }

    // Moves the item at position i of array a into its appropriate position.
    private fun maxHeapify(i: Int) {

        val left = leftChild(i)
        val right = rightChild(i)
        var largest = i

        // Check if the left node is larger than the current node.
        if (left <= size && heap[left] > heap[largest]) {
            largest = left
        }

        // Check if the right node is larger than the current node and left node.
        if (right <= size && heap[right] > heap[largest]) {
            largest = right
        }

        // Swap the largest node with the current node
        // and repeat this process until the current node is larger than
        // the right and the left node.
        if (largest != i) {
            swap(i, largest)
            maxHeapify(largest)
        }
    }
}