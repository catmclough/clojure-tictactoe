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
    (it "prints a welcome message"
        (let [output (with-out-str (welcome-players))
              lines (line-seq (io/reader
                                (java.io.ByteArrayInputStream.
                                (.getBytes output))))]
              (should= "Hello and Welcome to TicTacToe!" (last lines))))

    (it "sets the player's markers"
        (should= 2 (count (set-player-markers))))))
