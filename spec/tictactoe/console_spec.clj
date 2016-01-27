(ns tictactoe.console-spec
  (:require [speclj.core :refer :all]
            [tictactoe.console :refer :all]
            [tictactoe.copy-en-us :as copy]))

(describe "displayln"
	(it "outputs the given message to the console with a newline"
		(should= "Hello There!\n"
			(with-out-str (displayln "Hello There!")))))

(describe "display"
	(it "outputs the given message to the console"
		(should= "Hello There!"
			(with-out-str (display "Hello There!")))))

(describe "get-input"
	(it "receives input from the command line"
		(should= "XOXO"
      (with-in-str "XOXO" (get-input)))))

(describe "formatted-board"
	(it "returns a seq of formatted rows for display purposes"
		(should= '(("X" "X" "X")("O" 4 "O")(6 7 8))
			(formatted-board ["X" "X" "X" "O" 4 "O" 6 7 8]))))

(describe "print-board"
  (it "send the formatted board to the output"
    (should= "[0 1 2]\n[3 4 5]\n[6 7 8]\n"
      (with-out-str (print-board [0 1 2 3 4 5 6 7 8])))))

(describe "welcome-player"
  (it "welcomes the player with the copy's welcome message"
    (should= "Hello and Welcome to TicTacToe!\n"
      (with-out-str (welcome-player)))))

(describe "prompt-player-turn"
  (it "prompts the given player to play their turn"
    (should= "Player X, please choose your spot: "
      (with-out-str (prompt-player-turn "X")))))

(describe "ai-choosing"
  (it "alerts the user that the AI is choosing a spot"
    (should= "AI is Considering the Options\n"
      (with-out-str (ai-choosing)))))

(describe "winner-message"
  (it "displays a message telling the user who has won the game"
    (should= "Game Over.\nO has won the game.\n"
      (with-out-str (winner-message "O")))))

(describe "cats-game-message"
  (it "displays a message indicating there was a cat's game"
    (should= "Game of Cats, this is a Cats Game\n"
      (with-out-str (cats-game-message)))))

