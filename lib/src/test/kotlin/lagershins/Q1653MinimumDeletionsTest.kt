package lagershins

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class Q1653MinimumDeletionsTest {
	private val target = Q1653MinimumDeletions()

	@Test
	fun `case 1`() {
		assertThat(target.minimumDeletions("aababbab")).isEqualTo(2)
	}

	@Test
	fun `case 2`() {
		assertThat(target.minimumDeletions("bbaaaaabb")).isEqualTo(2)
	}
}