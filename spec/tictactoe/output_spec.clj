(ns tictactoe.output-spec
  (:require [speclj.core :refer :all]
            [tictactoe.output :refer :all]))

(describe "displayln"
	(it "outputs the given message to the console with a newline"
		(should= "Hello There!\n" 
			(with-out-str (displayln "Hello There!")))))

(describe "display"
	(it "outputs the given message to the console"
		(should= "Hello There!"
			(with-out-str (display "Hello There!")))))

(describe "formatted-board"
	(it "returns a seq of formatted rows for display purposes"
		(should= '(("X" "X" "X")("O" 4 "O")(6 7 8))
			(formatted-board ["X" "X" "X" "O" 4 "O" 6 7 8]))))
