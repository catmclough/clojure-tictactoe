(ns tictactoe.board-spec
  (:require [speclj.core :refer :all]
            [tictactoe.board :refer :all]))

(describe "board"
	(with empty-board [0 1 2 3 4 5 6 7 8])

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

(describe "space-is-empty?"
   (it "returns true if there is no marker on the given space"
   (should= true (space-is-empty? 0 @empty-board))))

(describe "filled?"
   (it "returns true if there are no empty spaces on the given board"
	(should= true (filled? @cats-game-board))))

(describe "available-spaces"
   (it "returns a list of indeces referring to empty spaces on the board"
	(should= '(0 1 2 3 4 5 6 7 8) (available-spaces @empty-board))))

(describe "player-up-next"
  (it "returns 'X' if there are no markers on the board"
      (should= "X" (player-up-next @empty-board)))
  (it "returns 'O' if there are more Xs on the board than Os"
      (should= "O" (player-up-next ["X" 1 2 3 4 5 6 7 8]))))

(describe "horizontal-slices"
  (it "returns three collections containing the markers or spaces on the horizontal rows of a given board"
    (should= '(("X" "X" "X") ("O" 4 "O") (6 7 8))	(horizontal-slices @horizontally-won-board))))

(describe "vertical-slices"
  (it "returns three collections containing the markers or spaces on the vertical axes of the given board"
    (should= '(("X" "O" 6) ("X" 4 7) ("X" "O" 8)) (vertical-slices @horizontally-won-board))))

(describe "diagonal-one"
  (it "returns a list containing the markers or spaces on the first diagonal of the given board"
    (should= '("X" 4 8) (diagonal-one @horizontally-won-board))))

(describe "diganol-two"
  (it "returns a list containing the markers or spaces on the second diagonal of the given board"
    (should= '("X" 4 6) (diagonal-two @horizontally-won-board))))

(describe "horizontal-winner"
  (it "returns marker of winner if there is a winner on a horizontal axis"
    (should= "X" (horizontal-winner @horizontally-won-board)))

  (it "returns nil if there is no winner on a horizontal axis"
    (should= nil (horizontal-winner @empty-board))))

(describe "vertical-winner"
  (it "returns nil if theres is a winner on a vertical axis"
    (should= "X" (vertical-winner @vertically-won-board)))

  (it "returns nil if there is no winner on a vertical axis"
    (should= nil (vertical-winner @empty-board))))

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

(describe "valid-spot-choice?"
	(it "returns true if the given choice is a number between 0-9 and the corresponding spot on the given board is empty"
		(should= "0" (valid-spot-choice? "0" @empty-board)))
	
  (it "returns nil if the given choice is not a number between 0-9 and the corresponding spot on the given board is not empty"
	(should= nil (valid-spot-choice? "0" @horizontally-won-board))))

(describe "fill-space"
	(it "returns a board with a space filled if the position is valid"
		(should= ["X" 1 2 3 4 5 6 7 8] (fill-space "0" "X" @empty-board)))
	(it "returns false if the position is invalid"
		(should= false (fill-space "*" "X" @empty-board)))
	(it "returns false if the position on the board is already filled"
		(should= false (fill-space "0" "X" @horizontally-won-board))))))))))
