package lagershins.quests.arrays1

import java.util.LinkedList
import kotlin.collections.iterator
import kotlin.math.max

/**
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 *
 * Example 1:
 *
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 *
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 *
 * Example 2:
 *
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 *
 * Constraints:
 *
 *     1 <= nums.length <= 105
 *     nums[i] is either 0 or 1.
 */
class Q3ConsecutiveOnes {
	// Runtime: 3ms (75.83%) Memory: 53.21MB (81.15%)
	fun findMaxConsecutiveOnes(nums: IntArray): Int {
		var max = 0
		var count = 0
		nums.forEach {
			when (it) {
				0 -> {
					max = max(max, count)
					count = 0
				}

				else -> count++
			}
		}
		return max(max, count)
	}
}
