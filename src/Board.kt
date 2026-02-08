package chess

class Board {
    //Creates an 8x8 Board, an Array of arrays
    private val board:Array<Array<String>> = Array(8) { Array(8) { "" } }
    fun setup()
    {
        val p=Pieces()
        val whiteSpecial=listOf(p.wRook,p.wKnight,p.wBishop,p.wQueen,p.wKing,p.wBishop,p.wKnight,p.wRook)
        val blackSpecial=listOf(p.bRook,p.bKnight,p.bBishop,p.bQueen,p.bKing,p.bBishop,p.bKnight,p.bRook)
        for (i in 0..7) {
            //special pieces
            board[7][i]= blackSpecial[i]
            board[0][i] = whiteSpecial[i]
            //pawns
            board[1][i] = p.wPawn
            board[6][i]= p.bPawn
            for (i in 2..5) {
                for (col in 0..7)
                {
                    board[i][col] = "\u2003"
                }
            }
        }
    }
    fun displayBoard()
    {
        val letters=listOf(" ","A"," B"," C"," D","E","F"," G","H")
        println(letters.joinToString(" "))
        for (row in 0 .. 7)
        {
            println("$row ${board[row].joinToString(" ")}")
        }
    }
    fun getBoard(): Array<Array<String>> = board}