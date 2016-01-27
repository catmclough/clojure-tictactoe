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
      (def board ["X" "X" 2
                  "O"  4  5
                  "X"  7 "O"])
      (should= "2" (choose-move board)))

  (it "returns the best move when it means a direct block of the opponent's win
      and that spot is not the first available spot"
      (def board ["O" "X" 2 "O"  4  5 "X"  7 "X"])
      (should= "7" (choose-move board)))

  (it "does not fall into the corner trap"
      (def board-one ["X" 1  2 3 "O" 5 6  7 "X"])
      (should (or (not= "2" (choose-move board-one))
                  (not= "6" (choose-move board-one))))

      (def board-two [0 1 "X" 3 "O" 5 "X" 7 8])
      (should (or (not= "0" (choose-move board-two))
                  (not= "8" (choose-move board-two)))))

  (it "avoids the two-way winner trap"
      (def board-one [0 "X" 2 "X" "O" 5 6 7 8])
      (should (or (not= "5" (choose-move board-one))
                  (not= "7" (choose-move board-one))
                  (not= "8" (choose-move board-one))))

      (def board-two [0 1 2 "X" "O" 5 6 "X" 8])
      (should (or (not= "1" (choose-move board-two))
                  (not= "2" (choose-move board-two))
                  (not= "5" (choose-move board-two)))))

  (it "evades the edge trap"
      (def board-one ["X" 1 2 3 "O" "X" 6 7 8])
      (should (or (not= "3" (choose-move board-one))
                  (not= "6" (choose-move board-two))))

      (def board-two [0 1 2 3 "O" "X" "X" 7 8])
      (should (or (not= "0" (choose-move board-two))
                  (not= "3" (choose-move board-two)))))

  (it "chooses the quickest path to victory when two winning moves are available"
      (def board-one ["X" "O" 2 "X" "O" 5 6   7 "X"])
      (should= "7" (choose-move board-one))

      (def board-two ["X"  1  2 3  "O" "X" 6  "O" "X"])
      (should= "1" (choose-move board-two))))

