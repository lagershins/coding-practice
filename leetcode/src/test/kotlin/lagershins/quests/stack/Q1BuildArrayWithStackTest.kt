package lagershins.quests.stack

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.FieldSource

class Q1BuildArrayWithStackTest {
	companion object {
		@JvmStatic
		private val args = listOf(
			arguments(intArrayOf(1, 3), 3, arrayOf("Push", "Push", "Pop", "Push")),
			arguments(intArrayOf(1, 2, 3), 3, arrayOf("Push", "Push", "Push")),
			arguments(intArrayOf(1, 2), 4, arrayOf("Push", "Push")),
			arguments(intArrayOf(3, 7), 7, arrayOf("Push", "Pop", "Push", "Pop", "Push", "Push", "Pop", "Push", "Pop", "Push", "Pop", "Push")),
			arguments(intArrayOf(1), 1, arrayOf("Push")),
			arguments(intArrayOf(3), 3, arrayOf("Push", "Pop", "Push", "Pop", "Push")),
		)
	}

	val target = Q1BuildArrayWithStack()

	@ParameterizedTest
	@FieldSource("args")
	fun test(nums: IntArray, n: Int, expected: Array<String>) {
		assertThat(target.buildArray(nums, n)).containsExactlyElementsOf(expected.asIterable())
	}
}