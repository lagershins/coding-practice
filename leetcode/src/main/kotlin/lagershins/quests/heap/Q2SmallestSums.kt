package lagershins.quests.heap

import java.util.PriorityQueue
import kotlin.math.max

/**
 * Q2. Find K Pairs with Smallest Sums
 * Medium
 *
 * You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.
 *
 * Define a pair (u, v) which consists of one element from the first array and one element from the second array.
 *
 * Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
 *
 * Example 1:
 *
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],
 * [11,6]
 *
 * Example 2:
 *
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [[1,1],[1,1]]
 * Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 *
 * Constraints:
 *
 *     1 <= nums1.length, nums2.length <= 10^5
 *     -10^9 <= nums1[i], nums2[i] <= 10^9
 *     nums1 and nums2 both are sorted in non-decreasing order.
 *     1 <= k <= 104
 *     k <= nums1.length * nums2.length
 */
class Q2SmallestSums {
	// Runtime: 201ms (9.22%) Memory: 76.56MB (25.53%)
	fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
		val heap = PriorityQueue<List<Int>>(k) { a, b -> b.sum() - a.sum() }
		var largestSmallest = Int.MAX_VALUE

		for (i in 0..<nums1.size) {
			for (j in 0..<nums2.size) {
				if (nums1[i] + nums2[j] >= largestSmallest) break

				val next = arrayListOf(nums1[i], nums2[j])
				if (heap.size < k) {
					heap.add(next)
					if (heap.size == k) largestSmallest = heap.peek().sum()
				} else if (heap.comparator().compare(heap.peek(), next) < 0) {
					heap.remove()
					heap.add(next)
					largestSmallest = heap.peek().sum()
				}
			}
		}
		return heap.take(k)
	}
}