(ns tictactoe.ai-spec
  (:require [speclj.core :refer :all]
            [tictactoe.ai :refer :all]))

(describe "choose-move"
  (it "chooses to win the game when a possible move leads to direct victory"
      (def board [0 "X" 2 3 "O" "X" "X" 7 "O"])
      (should= "0" (choose-move board)))

  (it "chooses the winning spot when not the first available index"
      (def board [0  "O" "X" "X" 4 "O" "X" "O" "X"])
      (should= "4" (choose-move board)))

  (it "returns the best move when it means a direct block of the opponent's chance to win"
    (def board ["X" "X" 2 "O" 4 5 "X" 7 "O"])
    (should= "2" (choose-move board)))

(it "returns the best move when it means a direct block of the opponent's win and that spot is not the first available spot"
    (def board ["X" "O" 2 "O" 4 5 "X" 7 "X"])
    (should= "4" (choose-move board))))



(describe "score-game"
    (it "returns 1 if the ai has won the given board state"
        (should= 1 (score-game ["O" "X" "X" "O" "O" "X" "O" "X" "O"])))

    (it "returns 0 if the given board state is a tie" 
        (should= 0 (score-game ["O" "X" "O" "X" "O" "X" "X" "O" "X"])))

    (it "returns -1 if the ai would lose in the given board state"
        (should= -1 (score-game ["X" "X" "X" "O" "X" "O" "O" "O" "X"]))))
