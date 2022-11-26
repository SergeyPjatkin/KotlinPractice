package com.practice.hastable

// https://kotlinlang.org/docs/operator-overloading.html
// https://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/

class Map<K, V> {

    data class Pair<K, V>(val key: K, var value: V)

    private var storage: Array<Pair<K, V>> = emptyArray()

    val size: Int
        get() = storage.size

    operator fun get(key: K): V? {
        storage.forEach {
            if (it.key == key)
                return it.value
        }
        return null
    }

    operator fun set(key: K, value: V) {
        // Search existing key
        for (i in storage.indices) {
            if (storage[i].key == key) {
                storage[i].value = value
                return
            }
        }
        // Append item.
        storage = storage.plus(Pair(key, value))
    }

    fun remove(key: K) {
        for (i in storage.indices) {
            if (storage[i].key == key) {
                val oldStorage = storage
                storage = Array(oldStorage.size - 1) { if (it < i) oldStorage[it] else oldStorage[it + 1] }
                return
            }
        }
    }

    fun clean() {
        storage = emptyArray()
    }

    fun forEach(block: (pair: Pair<K, V>) -> Unit) = storage.forEach { block(it) }
}