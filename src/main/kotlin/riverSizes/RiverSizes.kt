package riverSizes

import java.util.*

class RiverSize {
   fun riverSizes(matrix: List<List<Int>>): List<Int> {
      val sizes = mutableListOf<Int>()
      val visited = List(matrix.size) { MutableList(matrix[0].size) { false } }

      for (i in matrix.indices) {
         for (j in 0 until matrix[0].size) {
            if (visited[i][j]) {
               continue
            }

            traverseNode(i, j, matrix, visited, sizes)
         }
      }

      return sizes
   }

   fun traverseNode(iStart: Int, jStart: Int, matrix: List<List<Int>>, visited: List<MutableList<Boolean>>, sizes: MutableList<Int>) {
      var i = iStart
      var j = jStart

      var currentRiverSize = 0
      val nodesToExplore = Stack<Pair<Int, Int>>()

      nodesToExplore.push(Pair(i, j))

      while (!nodesToExplore.empty()) {
         val currentNode = nodesToExplore.pop()
         i = currentNode.first
         j = currentNode.second

         if (visited[i][j]) {
            continue
         }
         visited[i][j] = true

         if (matrix[i][j] == 0) {
            continue
         }

         currentRiverSize++

         val unvisitedNeighbors = getUnvisitedNeighbors(i, j, matrix, visited)

         for (neighbor in unvisitedNeighbors) {
            nodesToExplore.add(neighbor)
         }
      }

      if (currentRiverSize > 0) {
         sizes.add(currentRiverSize)
      }
   }

   fun getUnvisitedNeighbors (i: Int, j: Int, matrix: List<List<Int>>, visited: List<List<Boolean>>): List<Pair<Int, Int>> {
      val univisitedNeighbors = mutableListOf<Pair<Int, Int>>()
      if(i > 0 && !visited[i - 1][j]) {
         univisitedNeighbors.add(Pair(i - 1, j))
      }
      if (i < matrix.size - 1 && !visited[i + 1][j]) {
         univisitedNeighbors.add(Pair(i + 1, j))
      }
      if (j > 0 && !visited[i][j - 1]) {
         univisitedNeighbors.add(Pair(i, j -1))
      }
      if (j < matrix[0].size - 1 && !visited[i][j + 1]) {
         univisitedNeighbors.add(Pair(i, j + 1))
      }

      return univisitedNeighbors
   }
}