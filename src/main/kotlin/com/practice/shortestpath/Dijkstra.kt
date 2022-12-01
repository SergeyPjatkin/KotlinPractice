package com.practice.shortestpath

// https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/

// A class for Dijkstra's single source the shortest path algorithm.
// The clas is for adjacency matrix representation of the graph.

class Dijkstra {

    // Function that implements Dijkstra's single source the shortest path algorithm for a graph represented using
    // adjacency matrix representation
    fun shortestPath(graph: Array<Array<Int>>, src: Int): Array<Int> {

        // The output array: dist[i] will hold the shortest distance from src to each node.
        val dist = Array(graph.size) { Int.MAX_VALUE }.apply { this[src] = 0 }
        val sptSet = Array(graph.size) { false }

        // Find the shortest path for all vertices.
        for (i in dist.indices) {
            // Pick the minimum distance vertex from the set of vertices not yet processed.
            // u is always equal to src in first iteration.
            val u = minDistance(dist, sptSet)

            // Mark the picked vertex as processed.
            sptSet[u] = true

            // Update dist value of the adjacent vertices of the picked vertex.
            for (v in dist.indices) {
                // Update dist[v] only if is not in sptSet, there is an edge from u to v, and total
                // weight of path from src to v through u is smaller than current value of dist[v].
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v]
            }
        }

        return dist
    }

    private fun minDistance(dist: Array<Int>, sptSet: Array<Boolean>): Int {
        var min = Int.MAX_VALUE
        var minIndex = Int.MIN_VALUE

        for (i in dist.indices) {
            if (!sptSet[i] && dist[i] <= min) {
                min = dist[i]
                minIndex = i
            }
        }
        return minIndex
    }

}