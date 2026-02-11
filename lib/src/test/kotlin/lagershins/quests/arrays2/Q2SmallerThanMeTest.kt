package lagershins.quests.arrays2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.FieldSource

class Q2SmallerThanMeTest {
	companion object {
		@JvmStatic
		private val args = listOf(
			arguments(intArrayOf(8,1,2,2,3), intArrayOf(4,0,1,1,3)),
			arguments(intArrayOf(6,5,4,8), intArrayOf(2,1,0,3)),
			arguments(intArrayOf(7,7,7,7), intArrayOf(0,0,0,0)),
		)
	}

	val target = Q2SmallerThanMe()

	@ParameterizedTest
	@FieldSource("args")
	fun test(nums: IntArray, expected: IntArray) {
		assertThat(target.smallerNumbersThanCurrent(nums)).isEqualTo(expected)
	}
}