package lagershins.quests.arrays2

/**
 * Q1. Set Mismatch
 * Easy
 *
 * You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some
 * error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one
 * number and loss of another number.
 *
 * You are given an integer array nums representing the data status of this set after the error.
 *
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 *
 * Example 2:
 *
 * Input: nums = [1,1]
 * Output: [1,2]
 *
 * Constraints:
 *
 *     2 <= nums.length <= 10^4
 *     1 <= nums[i] <= 10^4
 */
class Q1ErrorNums {
	// Runtime: 2ms (98.08%) Memory: 48.79MB (80.38%)
	fun findErrorNums(nums: IntArray): IntArray {
		val result = IntArray(2)

		val sortedOccurences = IntArray(nums.size)
		nums.forEach { n ->
			val i = n - 1
			if (sortedOccurences[i] == 0) {
				sortedOccurences[i] = n
			} else {
				result[0] = n
			}
		}
		result[1] = sortedOccurences.indexOfFirst { it == 0 } + 1
		return result
	}
}