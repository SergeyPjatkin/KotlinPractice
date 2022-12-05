package com.practice.tree

// https://www.geeksforgeeks.org/trie-insert-and-search/

// O(keyLenght), memory O(ALPHABET_SIZE * key_length * N)
class Trie() {
    class TrieNode(char: Char) {
        val children: MutableList<TrieNode> = mutableListOf()
        var key: Char = char
        var isEndOfWord = false
    }

    private val root = TrieNode(' ')

    fun insert(word: String) {

        var node = root
        for (c in word) {
            node.children.firstOrNull { it.key == c }?.let {
                node = it
            } ?: run {
                node = TrieNode(c).apply { node.children.add(this) }
            }
        }
        node.isEndOfWord = true
    }

    fun search(word: String): Boolean {

        var node = root
        for (c in word) {
            node.children.firstOrNull { it.key == c }?.let {
                node = it
            } ?: run {
                return false
            }
        }
        return node.isEndOfWord
    }
}