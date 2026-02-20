package lagershins.quests.queue

import lagershins.quests.monostack.Q3LargestRectangle
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.FieldSource

class StudentLunchesTest {
	companion object {
		@JvmStatic
		private val args = listOf(
			arguments(intArrayOf(1, 1, 0, 0), intArrayOf(0, 1, 0, 1), 0),
			arguments(intArrayOf(1, 1, 1, 0, 0, 1), intArrayOf(1, 0, 0, 0, 1, 1), 3),
			arguments(intArrayOf(1, 1, 1, 0, 0, 1), intArrayOf(0, 1, 0, 0, 1, 1), 3),
			arguments(intArrayOf(1, 1, 1, 1), intArrayOf(0, 0, 0, 0), 4),
		)
	}

	private val target = StudentLunches()

	@ParameterizedTest
	@FieldSource("args")
	fun test(students: IntArray, sandwiches: IntArray, expected: Int) {
		assertThat(target.countStudents(students, sandwiches)).isEqualTo(expected)
	}
}