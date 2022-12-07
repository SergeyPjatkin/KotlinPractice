package com.practice.hastable

// https://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/

class HashMap<K, V> {

    data class HashNode<K, V>(val key: K, var value: V, var next: HashNode<K, V>? = null)

    private var numBuckets = 10
    private val buckets: MutableList<HashNode<K, V>?> = MutableList(numBuckets) { null }

    var size: Int = 0
        private set

    operator fun get(key: K): V? {
        if (size == 0)
            return null
        return key.getBucketIndex().let { index ->
            buckets[index]?.let { head ->
                head.getNode(key)?.value
            }
        }
    }

    operator fun set(key: K, value: V) {
        key.getBucketIndex().let { index ->
            if (buckets[index] == null) {
                buckets[index] = HashNode(key, value)
                size++
            } else {
                buckets[index].let { oldHead ->
                    oldHead?.getNode(key)?.let {
                        it.value = value
                        return
                    }
                    buckets[index] = HashNode(key, value, oldHead)
                    size++
                }
            }
        }
    }

    fun forEach(block: (key: K, value: V) -> Unit) {
        if (size > 0)
            return
        buckets.forEach { head ->
            var node: HashNode<K, V>? = head
            while (node != null) {
                block(node.key, node.value)
                node = node.next
            }
        }
    }

    // Function implements hash function to find index for a key.
    private fun K.getBucketIndex(): Int =
        (hashCode() % numBuckets).let {
            // key.hashCode() could be negative.
            if (it < 0) -1 * it else it
        }

    private fun HashNode<K, V>.getNode(key: K): HashNode<K, V>? {
        var node: HashNode<K, V>? = this
        while (node != null) {
            if (node.key == key)
                return node
            node = node.next
        }
        return null
    }
}