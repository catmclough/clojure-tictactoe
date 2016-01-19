(ns tictactoe.ai
  (:require [tictactoe.board :as board]))

(defn choose-move [board]
;  (str (first (board/available-spaces board))))
  (str minimax (board)))

(defn score-spot [board-state]
  (cond (= "O" (board/winner board-state)) 1
        (= "X" (board/winner board-state)) -1
        :else 0))

(defn minimax (board-state)
  (if (board/filled? board-state)
    (score-spot board-state)
    (let [scores (score-hypothetical-moves board-state)])

(defn score-hypothetical-moves [board]
  (let [available-spaces (board/available-spaces board)]
