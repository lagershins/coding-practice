package lagershins.quiz.assignment1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.FieldSource

class Q2MountainArrayTest {
	companion object {
		@JvmStatic
		private val args = listOf(
			arguments(intArrayOf(2, 1), false),
			arguments(intArrayOf(3,5,5), false),
			arguments(intArrayOf(0,3,2,1), true),
			arguments(intArrayOf(0,1,2,3), false),
			arguments(intArrayOf(3,2,1,0), false),
		)
	}

	private val target = Q2MountainArray()

	@ParameterizedTest
	@FieldSource("args")
	fun test(digits: IntArray, expected: Boolean) {
		assertThat(target.validMountainArray(digits)).isEqualTo(expected)
	}
}