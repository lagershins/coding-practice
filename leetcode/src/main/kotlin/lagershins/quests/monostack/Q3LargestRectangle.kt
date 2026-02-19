package lagershins.quests.monostack

import java.util.TreeMap
import kotlin.math.max
import kotlin.math.min

/**
 * Q3. Largest Rectangle in Histogram
 * Hard
 *
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
 * return the area of the largest rectangle in the histogram.
 *
 * Example 1:
 *
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 *
 * Example 2:
 *
 * Input: heights = [2,4]
 * Output: 4
 *
 * Constraints:
 *
 *     1 <= heights.length <= 10^5
 *     0 <= heights[i] <= 10^4
 */
class Q3LargestRectangle {
	fun largestArea(heights: IntArray): Int {
		return attempt1(heights)
	}

	// Runtime: 1,316ms (5.08%) Memory: 60.82 (96.09%)
	fun attempt1(heights: IntArray): Int {
		var maxArea = 0
		var prevH = 0

		for (i in 0 ..<heights.size) {
			val h = heights[i]
			if (h <= prevH) {
				prevH = h
				continue
			}

			prevH = h
			maxArea = max(maxArea, h)

			var commonH = h
			for (j in i + 1 ..< heights.size) {
				val hJ = heights[j]
				if (hJ == 0) {
					break
				}

				commonH = min(commonH, hJ)
				maxArea = max(maxArea, commonH * (j - i + 1))
			}
		}
		return maxArea
	}

	// Runtime: 174ms (7.04%) Memory: 68.00 (6.30%)
	fun attempt2(heights: IntArray): Int {
		var maxArea = 0
		var prevH = 0

		val factorsMap = TreeMap<Int, Int>()

		// Process heights in reverse order (right to left)
		for (i in (heights.size - 1) downTo 0) {
			val h = heights[i]
			factorsMap[h] = (factorsMap[h] ?: 0) + 1

			for ((k, v) in factorsMap) {
				if (k < h) {
					factorsMap[k] = v + 1
					maxArea = max(maxArea, k * (v + 1))
				} else break
			}

			// Where h <= prevH, processing of prevH will have reduced all factors greater
			// than prevH to zero so there is nothing to process.
			if (h < prevH) {
				// all factors greater than h will now be reduced to h, so we need to find
				// the most abundant occurrence and add it to the factor for h.
				var maxFactor = 0

				factorsMap.iterator().also {
					it.forEach { (k, v) ->
						if (k > h) {
							maxFactor = max(maxFactor, v)
							it.remove()
						}
					}
				}

				if (factorsMap[h] == 1) {
					factorsMap.computeIfPresent(h) { _, v -> v + maxFactor }
				}
			}
			maxArea = max(maxArea, h * (factorsMap[h] ?: 0))
			prevH = h
		}
		return maxArea
	}
}