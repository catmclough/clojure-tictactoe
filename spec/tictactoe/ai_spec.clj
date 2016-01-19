(ns tictactoe.ai-spec
  (:require [speclj.core :refer :all]
            [tictactoe.ai :refer :all]))

(describe "choose-move"
  (xit "returns the best move when it means instant victory for the AI"
    (def board ["X" "O" "X" 4 "O" 5 "X" 7 8])
    (should= "7" (choose-move board))))

(describe "score-spot"
    (it "returns 1 if the ai has won the given board state"
        (should= 1 (score-spot ["O" "X" "X" "O" "O" "X" "O" "X" "O"])))
    
    (it "returns 0 if the given board state is a tie" 
        (should= 0 (score-spot ["O" "X" "O" "X" "O" "X" "X" "O" "X"])))

    (it "returns -1 if the ai would lose in the given board state"
        (should= -1 (score-spot ["X" "X" "X" "O" "X" "O" "O" "O" "X"]))))
