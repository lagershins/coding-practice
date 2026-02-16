package lagershins.quests.monostack

import kotlin.math.max
import kotlin.math.min

/**
 * Q2. Daily Temperatures
 * Medium
 *
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that
 * answer\[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no
 * future day for which this is possible, keep answer\[i] == 0 instead.
 *
 * Example 1:
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 *
 * Example 2:
 *
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 *
 * Example 3:
 *
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 *
 * Constraints:
 *
 *     1 <= temperatures.length <= 10^5
 *     30 <= temperatures[i] <= 100
 */
class Q2DailyTemperatures {
	// Runtime: 19ms (95.34%) Memory: 64.32MB (36.76%)
	fun dailyTemperatures(temperatures: IntArray): IntArray {
		val result = IntArray(temperatures.size)

		// occ[i] is the lowest index of temperatures that we have observed 'i' temperature
		val mostRecent = IntArray(101)
		var max = 0

		for (i in temperatures.size - 1 downTo 0) {
			mostRecent[temperatures[i]] = i
			if (max > temperatures[i]) {
				var closest = Int.MAX_VALUE
				for (j in temperatures[i] + 1..100) {
					if (mostRecent[j] > 0) {
						closest = min(closest, mostRecent[j])
					}
				}
				result[i] = closest - i
			}
			max = max(max, temperatures[i])
		}
		return result
	}
}
