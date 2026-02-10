package lagershins.quests.arrays1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.FieldSource

class Q3ConsecutiveOnesTest {
	companion object {
		@JvmStatic
		private val args = listOf(
			arguments(intArrayOf(1,1,0,1,1,1), 3),
			arguments(intArrayOf(1,0,1,1,0,1), 2),
		)
	}

	val target = Q3ConsecutiveOnes()

	@ParameterizedTest
	@FieldSource("args")
	fun test(nums: IntArray, expected: Int) {
		assertThat(target.findMaxConsecutiveOnes(nums)).isEqualTo(expected)
	}

}