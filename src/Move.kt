package chess

import kotlin.system.exitProcess

fun coordinator(coord: String):Pair<Int, Int>
{
    val colChar = coord[0]
    val rowChar = coord[1]

    // Unicode subtraction to get a digit
    val col = colChar - 'a'
    val row = rowChar.digitToInt()

    return Pair(col, row)
}
fun isValidInput(input: String): Boolean {
    // Must be 2 characters
    if (input.length != 2) return false

    // Must be a letter
    val col = input[0].lowercaseChar()
    val row = input[1]

    // If within these bounds returns true
    return col in 'a' .. 'h' && row in '0' .. '7'
}
fun getValidCoordinate(): Pair<Int, Int> {
    while (true) {
        val square=readln().lowercase()

        if (square=="q") exitProcess(0)

        if (isValidInput(square))
        {
            return coordinator(square)
        }
        else
        {
            println("Invalid square! Use a letter a-h and a number 1-8, e.g., e2")
        }
    }
}

fun movePiece(board: Board)
{
    val b = board.getBoard()
    var validStart = false
    var sCol = 0
    var sRow = 0
    var eCol = 0
    var eRow = 0
    // Keep asking until a valid starting square is chosen
    while (!validStart) {
        println("Choose piece to move:")
        val start = getValidCoordinate()
        sCol = start.first
        sRow = start.second

        if (b[sRow][sCol] == "\u2003")
        {
            println("No piece at that location. Choose again.")
        }
        else
        {
            validStart = true
        }
    }
    println("Move where?")
    val end = getValidCoordinate()
    eCol = end.first
    eRow = end.second

    // Move the piece
    b[eRow][eCol] = b[sRow][sCol]
    b[sRow][sCol] = "\u2003"
}