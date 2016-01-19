(ns tictactoe.output-spec
  (:require [speclj.core :refer :all]
            [tictactoe.setup :refer :all]))

(describe "board"
	(with empty-board [0 1 2 3 4 5 6 7 8])

(describe "make-board"
	(it "makes a board with nine empty spaces represented as numbers"
		(should= (make-board) @empty-board)))

(describe "setup-game"
    (it "prints a welcome message"
        (should= (copy/welcome-message) (welcome-player)))
    (it "sets the player's markers"
        (should= 2 (count set-player-markers)))))
