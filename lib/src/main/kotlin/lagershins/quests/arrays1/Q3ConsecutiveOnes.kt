package lagershins.quests.arrays1

import java.util.LinkedList
import kotlin.collections.iterator

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
	fun findMaxConsecutiveOnes(nums: IntArray): Int {
		return nums
			.asIterable()
			.chunked { it: Int -> it == 0 }
			.maxOfOrNull { it.size }
			?: 0
	}
}

/**
 * Overload for the chunked library function that takes a predicate.
 * @see kotlin.sequences.chunked
 */
fun <T> Iterable<T>.chunked(predicate: (T) -> Boolean) = Sequence<List<T>> {
	val iterator = this.iterator()
	iterator {
		var buffer: MutableList<T> = LinkedList()
		for (e in iterator) {
			if (predicate(e)) {
				if (buffer.isNotEmpty()) {
					yield(buffer)
					buffer = LinkedList()
				}
			} else {
				buffer.add(e)
			}
		}

		if (buffer.isNotEmpty()) {
			yield(buffer)
		}
	}
}
