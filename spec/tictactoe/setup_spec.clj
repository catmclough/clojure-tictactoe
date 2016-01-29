(ns tictactoe.setup-spec
  (:require [speclj.core :refer :all]
            [tictactoe.setup :refer :all]
            [clojure.java.io :as io]))

(describe "board"
	(with empty-board [0 1 2 3 4 5 6 7 8])

(describe "make-board"
	(it "makes a board with nine empty spaces represented as numbers"
		(should= (make-board) @empty-board)))

(describe "setup-game"
  (it "sets the player's markers"
    (should= "X" player-one)
    (should= "O" player-two))))
