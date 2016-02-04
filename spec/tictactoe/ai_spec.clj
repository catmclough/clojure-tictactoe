(ns tictactoe.ai-spec
  (:require [speclj.core :refer :all]
            [tictactoe.ai :refer :all]
            [tictactoe.board :as board]))

(def ai-player "O")

(defn pick-next-spot [board player]
  (let [choice (choose-move board player)]
        (board/fill-space choice player board)))

(defn winner-of-two-ai-simulated-game []
  (loop [board (vec (range 9))]
      (if (board/game-over? board)
          (cond (board/winner board) (board/winner board)
                (board/cats-game? board) nil)
          (recur (pick-next-spot board (board/active-player board))))))

(describe "choose-move"
  (it "chooses to win the game when a possible move leads to direct victory"
      (def board [0 "X" 2 3 "O" "X" "X" 7 "O"])
      (should= "0" (choose-move board ai-player)))

  (it "chooses the winning spot when not the first available index"
      (def board [0  "O" "X" "X" 4 "O" "X" "O" "X"])
      (should= "4" (choose-move board ai-player)))

  (it "returns the best move when it means a direct block of the opponent's chance to win"
      (def board ["X" "X" 2 3 "O" 5 6  "O" "X"])
      (should= "2" (choose-move board ai-player)))

  (it "returns the best move when it means a direct block of the opponent's win
      and that spot is not the first available spot"
      (def board ["O" "X" 2 "O" 4  5 "X"  7 "X"])
      (should= "7" (choose-move board ai-player)))

  (it "does not fall into the corner trap"
      (def board-one ["X" 1  2 3 "O" 5 6  7 "X"])
      (should (or (not= "2" (choose-move board-one ai-player))
                  (not= "6" (choose-move board-one ai-player))))

      (def board-two [0 1 "X" 3 "O" 5 "X" 7 8])
      (should (or (not= "0" (choose-move board-two ai-player))
                  (not= "8" (choose-move board-two ai-player)))))

  (it "avoids the two-way winner trap"
      (def board-one [0 "X" 2 "X" "O" 5 6 7 8])
      (should (or (not= "5" (choose-move board-one ai-player))
                  (not= "7" (choose-move board-one ai-player))
                  (not= "8" (choose-move board-one ai-player))))

      (def board-two [0 1 2 "X" "O" 5 6 "X" 8])
      (should (or (not= "1" (choose-move board-two ai-player))
                  (not= "2" (choose-move board-two ai-player))
                  (not= "5" (choose-move board-two ai-player)))))

  (it "evades the edge trap"
      (def board-one ["X" 1 2 3 "O" "X" 6 7 8])
      (should (or (not= "3" (choose-move board-one ai-player))
                  (not= "6" (choose-move board-two ai-player))))

      (def board-two [0 1 2 3 "O" "X" "X" 7 8])
      (should (or (not= "0" (choose-move board-two ai-player))
                  (not= "3" (choose-move board-two ai-player)))))

  (it "chooses the quickest path to victory when two winning moves are available"
      (def board-one ["X" "O" 2 "X" "O" 5 6   7 "X"])
      (should= "7" (choose-move board-one ai-player))

      (def board-two ["X"  1  2 3  "O" "X" 6  "O" "X"])
      (should= "1" (choose-move board-two ai-player)))

  (context "AI vs. AI game"
    (tags :slow)
    (it "never allows AI to lose, meaning it always ties when playing another AI"
      (should= nil (winner-of-two-ai-simulated-game)))))


