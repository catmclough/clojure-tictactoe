(ns tictactoe.board-spec
  (:require [speclj.core :refer :all]
            [tictactoe.board :refer :all]))

(describe "board"
	(with empty-board [" " " " " " " " " " " " " " " " " "])

(describe "horizontally-won-board"
  (with horizontally-won-board ["X" "X" "X" "O" " " "O" " " " " " "])

(describe "vertically-won-board"
  (with vertically-won-board ["X" "O" "X" "X" "O" " " "X" " " "O"])

(describe "diagonnally-won-board"
  (with diagonally-won-board ["X" "O" "X" " " "X" " " "O" " " "X"])

(describe "cats-game-board"
  (with cats-game-board ["X" "O" "X" "O" "X" "O" "O" "X" "O"])

(describe "x-first-players"
  (with x-first-players ["X" "O"])

(describe "make-board"
	(it "makes a board with nine empty spaces"
		(should= (make-board) @empty-board)))

(describe "formatted-board"
	(it "returns a seq of formatted rows for display purposes"
		(should= '(("X" "X" "X")("O" "--" "O")("--" "--" "--"))
			(formatted-board @horizontally-won-board))))

(describe "space-is-empty?"
   (it "returns true if there is no marker on the given space"
   (should= true (space-is-empty? 0 @empty-board))))

(describe "filled?"
   (it "returns true if there are no empty spaces on the given board"
	(should= true (filled? @cats-game-board))))

(describe "available-spaces"
   (it "returns a list of indeces referring to empty spaces on the board"
	(should= '(0 1 2 3 4 5 6 7 8) (available-spaces @empty-board))))

(describe "horizontal-slices"
  (it "returns three collections containing the markers or spaces on the horizontal rows of a given board"
    (should= '(("X" "X" "X") ("O" " " "O") (" " " " " ")) 
	(horizontal-slices @horizontally-won-board))))

(describe "vertical-slices"
  (it "returns three collections containing the markers or spaces on the vertical axes of the given board"
    (should= '(("X" "O" " ") ("X" " " " ") ("X" "O" " ")) (vertical-slices @horizontally-won-board))))

(describe "diagonal-one"
  (it "returns a list containing the markers or spaces on the first diagonal of the given board"
    (should= '("X" " " " ") (diagonal-one @horizontally-won-board))))

(describe "diganol-two"
  (it "returns a list containing the markers or spaces on the second diagonal of the given board"
    (should= '("X" " " " ") (diagonal-two @horizontally-won-board))))

(describe "horizontal-winner?"
  (it "returns true if there is a winner on a horizontal axis"
    (should= true (horizontal-winner? @horizontally-won-board)))

  (it "returns false if there is no winner on a horizontal axis"
    (should= false (horizontal-winner? @empty-board))))

(describe "vertical-winner?"
  (it "returns true if theres is a winner on a vertical axis"
    (should= true (vertical-winner? @vertically-won-board)))

  (it "returns false if there is no winner on a vertical axis"
    (should= false (vertical-winner? @empty-board))))

(describe "winner?"
   (it "returns true if there is a winner on any axis"
     (should= true (winner? @horizontally-won-board)))

   (it "returns false if there is no winner on any axis"
     (should= false (winner? @empty-board))))

(describe "winner"
   (it "returns nil if there is no winner"
	(should= nil (winner @empty-board @x-first-players)))

   (it "returns the marker of the winner if there is one"
	(should= "X" (winner @horizontally-won-board @x-first-players))))

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
		(should= ["X" " " " " " " " " " " " " " " " "] (fill-space "0" "X" @empty-board)))
	(it "returns false if the position is invalid"
		(should= false (fill-space "*" "X" @empty-board)))
	(it "returns false if the position on the board is already filled"
		(should= false (fill-space "0" "X" @horizontally-won-board))))))))))

