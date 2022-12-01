package com.practice.members

import java.util.Stack

// Depth First Search (DFS)
/* Return all path's from [a] to [b] in graph */
fun searchPathsDFS(a: String, b: String, graph: Map<String, ArrayList<String>>): ArrayList<ArrayList<String>> =
    searchRecursion(a, b, graph, arrayListOf(a), arrayListOf(a), arrayListOf())

// Breadth-first search (BFS)
/* Return all path's from [a] to [b] in graph */
fun searchPathsBFS(a: String, b: String, graph: Map<String, ArrayList<String>>): ArrayList<ArrayList<String>> {
    val path: ArrayList<String> = arrayListOf()
    val paths: ArrayList<ArrayList<String>> = arrayListOf()

    val stack: Stack<ArrayList<String>> = Stack()

    path.add(a)
    stack.push(path)

    while (stack.isNotEmpty()) {

        val localPath = stack.pop()
        val last = localPath.last()

        graph[last]?.forEach {
            if (!localPath.contains(it)) {
                val newPath = (localPath.clone() as ArrayList<String>).apply { add(it) }
                if (it == b) {
                    paths.add(newPath)
                } else {
                    stack.push(newPath)
                }
            }
        }
    }
    return paths
}

private fun searchRecursion(
    a: String,
    b: String,
    graph: Map<String, ArrayList<String>>,
    path: ArrayList<String>,
    visited: ArrayList<String>,
    paths: ArrayList<ArrayList<String>>,
): ArrayList<ArrayList<String>> {

    if (a == b) {
        paths.add(path.clone() as java.util.ArrayList<String>)
        return paths;
    }

    graph[a]?.forEach {
        if (!visited.contains(it)) {
            path.add(it)
            visited.add(it)
            searchRecursion(it, b, graph, path, visited, paths)
            path.remove(it)
            visited.remove(it)
        }
    }

    return paths
}
