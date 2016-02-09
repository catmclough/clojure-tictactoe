(ns tictactoe.core-spec
    (:require [speclj.core :refer :all]
              [tictactoe.core :refer :all]
              [tictactoe.setup :as setup]
              [tictactoe.board :as board]))

(defn make-input [entries]
  (apply str (interleave entries (repeat "\n"))))

;(defn -main []
  ;(let [game-type (setup/setup-game)]
    ;(loop [board (setup/make-board board/board-size)]
      ;(console/refresh-round board)
         ;(if (board/game-over? board)
          ;(end-game board)
          ;(recur (pick-and-validate-next-spot board game-type))))))

(describe "main"
  (tags :core)
  (around [it]
    (with-out-str (it)))

  (xit "runs, receiving input and updating the board, but ends if computer wins"
    (should= nil (with-in-str (make-input '("1" "3" "0" "1")) (-main))))

  (xit "runs, receiving input and updating the board, but ends if game is tied"
    (should= nil (with-in-str (make-input '("1" "0" "8" "1" "6" "5")) (-main))))

  (xit "sets up the game"
    (with-redefs
      [setup/setup-game #(2)
       ]
        (should-invoke setup/setup-game {:times 1} (-main))))

  (context "Invalid Input"
    (tags :slow)
    (xit "handles all spot-choice input without breaking"
      (should= nil (with-in-str (make-input '("1" "*" "*" "3" "3" "0" "beep-boop" "1")))))))

