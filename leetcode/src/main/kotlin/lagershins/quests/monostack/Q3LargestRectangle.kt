package lagershins.quests.monostack

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
	// Runtime: 1,316ms (5.08%) Memory: 60.82 (96.09%)
	fun largestArea(heights: IntArray): Int {
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
}