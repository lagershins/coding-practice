package lagershins

import kotlin.math.min
import kotlin.math.roundToInt

/**
 * 1653. Minimum Deletions to Make String Balanced
 *
 * You are given a string s consisting only of characters 'a' and 'b'.
 *
 * You can delete any number of characters in s to make s balanced. s is balanced
 * if there is no pair of indices (i,j) such that i < j and s\[i] = 'b' and s\[j]= 'a'.
 *
 * Return the minimum number of deletions needed to make s balanced.
 *
 * Example 1:
 *
 * Input: s = "aababbab"
 * Output: 2
 * Explanation: You can either:
 * Delete the characters at 0-indexed positions 2 and 6 ("aababbab" -> "aaabbb"), or
 * Delete the characters at 0-indexed positions 3 and 6 ("aababbab" -> "aabbbb").
 *
 * Example 2:
 *
 * Input: s = "bbaaaaabb"
 * Output: 2
 * Explanation: The only solution is to delete the first two characters.
 *
 * Constraints:
 *     1 <= s.length <= 100,000
 *     s\[i] is 'a' or 'b'.
 */
class Q1653MinimumDeletions {
	fun minimumDeletions(s: String): Int {
		val length = s.length
		if (length < 2) return 0

		// length >= 2
		val aa = IntArray(length) { 0 }
		val bb = IntArray(length) { 0 }

		for (i in 1 ..< length) {
			bb[i] = bb[i - 1] + if(s[i - 1] == 'b') 1 else 0
			aa[length - i - 1] = aa[length - i] + if(s[length - i] == 'a') 1 else 0
		}

		var smallest = Int.MAX_VALUE
		for (i in 0 ..< length) {
			smallest = minOf(smallest, aa[i] + bb[i])
		}
		return smallest
	}
}