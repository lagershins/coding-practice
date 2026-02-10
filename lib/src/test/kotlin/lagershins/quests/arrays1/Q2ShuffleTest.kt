package lagershins.quests.arrays1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.FieldSource

class Q2ShuffleTest {
	companion object {
		@JvmStatic
		private val args = listOf(
			arguments(intArrayOf(2,5,1,3,4,7), 3, intArrayOf(2,3,5,4,1,7))
		)
	}

	val target = Q2Shuffle()

	@ParameterizedTest
	@FieldSource("args")
	fun test(nums: IntArray, n: Int, expected: IntArray) {
		assertThat(target.shuffle(nums, n)).isEqualTo(expected)
	}
}