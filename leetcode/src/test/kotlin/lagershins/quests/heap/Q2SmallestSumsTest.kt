package lagershins.quests.heap

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.FieldSource

class Q2SmallestSumsTest {
	companion object {
		@JvmStatic
		private val args = listOf(
			arguments(intArrayOf(1, 7, 11), intArrayOf(2, 4, 6), 3, listOf(listOf(1, 2), listOf(1, 4), listOf(1, 6))),
			arguments(intArrayOf(1, 1, 2), intArrayOf(1, 2, 3), 2, listOf(listOf(1, 1), listOf(1, 1))),
			arguments(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), 2, listOf(listOf(1, 4), listOf(1, 5))),
			arguments(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), 2, listOf(listOf(1, 4), listOf(1, 5))),
//			arguments(intArrayOf(0, 0, 0, 0, 0), intArrayOf(-3, 22, 35, 56, 76), 22, listOf(listOf(0, -3))),
		)
	}

	private val target = Q2SmallestSums()

	@ParameterizedTest
	@FieldSource("args")
	fun test(nums1: IntArray, nums2: IntArray, k: Int, expected: List<List<Int>>) {
		assertThat(target.kSmallestPairs(nums1, nums2, k)).containsExactlyInAnyOrder(*expected.toTypedArray())
	}
}