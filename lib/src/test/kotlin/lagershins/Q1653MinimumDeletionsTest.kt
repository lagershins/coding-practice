package lagershins

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class Q1653MinimumDeletionsTest {
	private val target = Q1653MinimumDeletions()

	@ParameterizedTest
	@CsvSource(
		"aababbab, 2",
		"bbaaaaabb, 2",
		"aaaaaaaaa, 0",
		"bbbbbbb, 0",
		"ababababaa, 4",
		"bbabababab, 4",
		"ababaaaabbbbbaaababbbbbbaaabbaababbabbbbaabbbbaabbabbabaabbbababaa, 25",
		"aabbabba, 2",
	)
	fun test(s: String, expected: Int) {
		assertThat(target.minimumDeletions(s)).isEqualTo(expected)
	}
}