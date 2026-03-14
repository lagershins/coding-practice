package lagershins

import kotlin.math.pow

/**
 * 1415. The k-th Lexicographical String of All Happy Strings of Length n
 * Medium
 *
 * A happy string is a string that:
 *
 *     consists only of letters of the set ['a', 'b', 'c'].
 *     s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
 *
 * For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc"
 * are not happy strings.
 *
 * Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.
 *
 * Return the kth string of this list or return an empty string if there are less than k happy strings of length n.
 *
 * Example 1:
 *
 * Input: n = 1, k = 3
 * Output: "c"
 * Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".
 *
 * Example 2:
 *
 * Input: n = 1, k = 4
 * Output: ""
 * Explanation: There are only 3 happy strings of length 1.
 *
 * Example 3:
 *
 * Input: n = 3, k = 9
 * Output: "cab"
 * Explanation: There are 12 different happy string of length 3 ["aba", "abc", "aca", "acb", "bab", "bac", "bca",
 * "bcb", "cab", "cac", "cba", "cbc"]. You will find the 9th string = "cab"
 *
 * Constraints:
 *
 *     1 <= n <= 10
 *     1 <= k <= 100
 */
class Q1415 {
	// Runtime: 16ms (47.37%) Memory: 43.63MB (84.21%)
	fun getHappyString(n: Int, k: Int): String {
		if (k > 3 * 2.0.pow(n - 1)) {
			return ""
		}

		val letters = arrayOf('a', 'b', 'c')
		// Valid letters that can follow a, b & c respectively.
		val after = mapOf(
			'a' to arrayOf('b', 'c'),
			'b' to arrayOf('a', 'c'),
			'c' to arrayOf('a', 'b')
		)

		// Binary representation of (k-1) zero padded to a length of n+1 (to cater for the first character being base 3).
		val binary = (k - 1).toString(2).padStart(n + 1, '0')

		val result = StringBuilder()

		// The first character has 3 possible values, requiring 2 digits to represent in binary
		var prev = letters[binary.take(2).toInt(2)]
		result.append(prev)

		// All remaining characters have 2 possibilities, limited by the previous character
		binary.substring(2).forEach {
			val next = after[prev]?.get(it.code - '0'.code) ?: throw Exception("No valid chars after '$prev'")
			result.append(next)
			prev = next
		}
		return result.toString()
	}
}