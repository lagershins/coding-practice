package lagershins

import org.jsoup.Jsoup
import java.io.PrintStream
import java.util.TreeMap

class SecretMessage {
	fun decode(url: String, out: PrintStream = System.out) {
		val grid = TreeMap<Int, TreeMap<Int, Char>>(Comparator.reverseOrder())

		Jsoup.connect(url).execute().streamParser().use { parser ->
			parser.selectNext("tr") ?: return out.println("Table header row not found in document")
			parser
				.stream()
				.filter { it.`is`("tr") }
				.map { it.select("p").eachText() }
				.map { (a, b, c) -> Triple(a.toInt(), b.first(), c.toInt()) }
				.forEach { (x, c, y) ->
					val row = grid.getOrElse(y) {
						TreeMap<Int, Char>().also { grid[y] = it }
					}
					row[x] = c
				}
		}

		grid.values.forEach {
			it.entries.fold(StringBuilder()) { acc, (x, c) ->
				val spaces = (acc.length..<x).count()
				acc.append(" ".repeat(spaces)).append(c)
			}.also(out::println)
		}
	}
}