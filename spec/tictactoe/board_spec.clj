(ns tictactoe.board-spec
  (:require [speclj.core :refer :all]
            [tictactoe.board :refer :all]))

(defn invalid-spot-choice [choice board]
    (try
      (fill-space choice "X" board)
      (catch Exception e (str "Caught Exception: " (.getMessage e)))))

(describe "board"
	(with empty-board [0 1 2 3 4 5 6 7 8])

(describe "make-board"
	(it "makes a board with nine empty spaces represented as numbers"
		(should= (make-board board-size) @empty-board)))

(describe "horizontally-won-board"
  (with horizontally-won-board ["X" "X" "X" "O" 4 "O" 6 7 8])

(describe "vertically-won-board"
  (with vertically-won-board ["X" "O" "X" "X" "O" 5 "X" 7 "O"])

(describe "diagonnally-won-board"
  (with diagonally-won-board ["X" "O" "X" 3 "X" 5 "O" 7 "X"])

(describe "cats-game-board"
  (with cats-game-board ["X" "O" "X" "O" "X" "O" "O" "X" "O"])

(describe "x-first-players"
  (with x-first-players ["X" "O"])

(describe "available-spaces"
   (it "returns a list of indeces referring to empty spaces on the board"
       (should= '(0 1 2 3 4 5 6 7 8) (available-spaces @empty-board)))

   (it "returns the correct indices on a partially filled board"
       (should= '(2 5 6 7) (available-spaces ["X" "O" 2 "X" "O" 5 6 7 "X"]))))

(describe "active-player"
   (it "returns 'X' if there are no markers on the board"
       (should= "X" (active-player @empty-board)))

   (it "returns 'O' if there are more Xs on the board than Os"
       (should= "O" (active-player ["X" 1 2 3 4 5 6 7 8]))))

(describe "winner"
    (it "returns the winning marker if there is a winner on any axis"
       (should= "X" (winner @horizontally-won-board)))

    (it "returns nil if there is no winner on any axis"
       (should= nil (winner @empty-board))))

(describe "winner"
    (it "returns nil if there is no winner"
	     (should= nil (winner @empty-board)))

   (it "returns the marker of the winner if there is one"
	     (should= "X" (winner @horizontally-won-board))))

(describe "cats-game?"
   (it "returns true if the board is full and there is no winner"
	     (should= true (cats-game? @cats-game-board))))

(describe "game-over?"
   (it "returns true if there is a winner, even if the board is not filled"
       (should= true (game-over? @horizontally-won-board)))

   (it "returns true if there is no winner but the board is full"
       (should= true (game-over? @cats-game-board)))

   (it "returns false if the game is not over"
       (should= false (game-over? @empty-board))))

(describe "fill-space"
	 (it "returns a board with a new space filled if the position is valid"
		   (should= ["X" 1 2 3 4 5 6 7 8] (fill-space 0 "X" @empty-board)))

	 (it "throws an exception if the spot choice is invalid"
		   (should= "Caught Exception: Invalid Spot Choice." (invalid-spot-choice "*" @empty-board)))

	 (it "throws an exception if the spot is not empty"
		   (should= "Caught Exception: Invalid Spot Choice." (invalid-spot-choice 0 @horizontally-won-board))))))))))

