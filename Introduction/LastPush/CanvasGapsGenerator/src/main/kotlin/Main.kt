fun fillPatternRow(patternRow: String, patternWidth: Int) = if (patternRow.length <= patternWidth) {
    val filledSpace = "$separator".repeat(patternWidth - patternRow.length)
    "$patternRow$filledSpace"
} else {
    error("patternRow length > patternWidth, please check the input!")
}

fun getPatternHeight(pattern: String) = pattern.lines().size

fun repeatHorizontally(pattern: String, n: Int, patternWidth: Int): String {
    val pictureRows = pattern.lines()
    val sb = StringBuilder()
    for (row in pictureRows) {
        val currentRow = fillPatternRow(row, patternWidth)
        sb.append(currentRow.repeat(n))
        sb.append(newLineSymbol)
    }
    return sb.toString()
}

fun dropTopFromLine(line: String, width: Int, patternHeight: Int, patternWidth: Int): String {
    val nToDrop = if (patternHeight > 1) {
        patternWidth * width + newLineSymbol.length
    } else {
        0
    }
    val newPattern = line.removeSuffix(newLineSymbol).drop(nToDrop)
    return "$newPattern$newLineSymbol"
}

fun baseGenerator(firstLine: String, secondLine: String, height: Int): String {
    val sb = StringBuilder()
    sb.append(firstLine)
    return when {
        height < 1 -> ""
        height == 1 -> sb.toString()
        else -> {
            sb.append(secondLine)
            sb.append(repeatVertically(firstLine, secondLine, height))
            sb.toString()
        }
    }
}

fun repeatVertically(firstLine: String, secondLine: String, height: Int): String {
    val currentHeight = makeEvenNumber(height) / 2 - 1
    val pattern = "$firstLine$secondLine".repeat(currentHeight)
    return if (height % 2 == 0) {
        pattern
    } else {
        "$pattern$firstLine"
    }
}

fun makeEvenNumber(number: Int) = if (number % 2 == 0) {
    number
} else {
    number - 1
}

fun canvasGenerator(pattern: String, width: Int, height: Int): String {
    val patternWidth = getPatternWidth(pattern)
    val patternHeight = getPatternHeight(pattern)
    val repeatedPattern = repeatHorizontally(pattern, width, patternWidth)
    val dropped = dropTopFromLine(repeatedPattern, width, patternHeight, patternWidth)
    return "$repeatedPattern${baseGenerator(dropped, dropped, height - 1)}"
}

fun addEmptyWindow(patternRow: String, patternWidth: Int, toAddAfter: Boolean = false): String {
    val separator = "$separator".repeat(patternWidth)
    return if (toAddAfter) {
        "$patternRow$separator"
    } else {
        "$separator$patternRow"
    }
}

fun isEmpty(pattern: String) = pattern == ""

fun repeatHorizontallyWithGaps(pattern: String, n: Int, toAddSeparatorAfter: Boolean): String {
    val pictureRows = pattern.lines()
    val patternWidth = getPatternWidth(pattern)
    val sb = StringBuilder()
    for (row in pictureRows) {
        val currentRow = fillPatternRow(row, patternWidth)

        val currentRwSb = StringBuilder()
        val currentWidth = makeEvenNumber(n) / 2
        val patternToRepeat = addEmptyWindow(currentRow, patternWidth, toAddSeparatorAfter).repeat(currentWidth)
        if (isEmpty(patternToRepeat)) {
            currentRwSb.append(currentRow)
        } else {
            currentRwSb.append(patternToRepeat)
        }
        if (n % 2 != 0 && !isEmpty(patternToRepeat)) {
            currentRwSb.append(patternToRepeat.dropLast(patternToRepeat.length - currentRow.length))
        }
        sb.append(currentRwSb.toString())
        sb.append(newLineSymbol)
    }
    return sb.toString()
}

fun canvasWithGapsGenerator(pattern: String, width: Int, height: Int): String {
    val firstLine = repeatHorizontallyWithGaps(pattern, width, true)
    val secondLine = repeatHorizontallyWithGaps(pattern, width, false)
    return baseGenerator(firstLine, secondLine, height)
}

fun main() {
    // Write your code here
}
