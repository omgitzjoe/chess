package chess
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    // Beginning message
    println("Hello, Welcome to Chess!")
    println("enter 'q' to quit game")
    // Display Board and initialize game.
    var endGame=false
    val board= Board()
    board.setup()
    println("White goes first!")
    board.displayBoard()

    // Counter to track turns
    var counter=0
    while (!endGame)
    {
        val player = if (counter % 2 == 0) "White" else "Black"
        println("${player}'s move")
        // Player makes a move
        movePiece(board)
        board.displayBoard()
        // Increments will alter between black and white
        counter += 1
    }
}