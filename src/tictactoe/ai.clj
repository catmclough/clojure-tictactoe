(ns tictactoe.ai
  (:require [tictactoe.board :as board]))

(defn score-game [board-state]
  (cond (= "O" (board/winner board-state)) 1
        (= "X" (board/winner board-state)) -1
        :else 0))

(declare minimax)

(defn minimax
  ([board-state]
    (minimax board-state {}))
  ([board-state score-map]
    (if (board/filled? board-state)
      (score-game board-state)
      (do
        (loop [available-spaces (board/available-spaces board-state)]
          (if (empty? available-spaces)
            score-map
            (do
              (let [new-board-state (board/fill-space (str (first available-spaces)) (board/active-player board-state) board-state)]
                (let [scores (merge-with + score-map {(first available-spaces) (minimax new-board-state)})]
                  (if (= "O" (board/active-player board-state))
                    (key (apply max-key val scores))
                    (key (apply min-key val scores))))))))))))

    ;for each available move, create a new board state by putting the active player in that spot
    ;add to your scores list (at that move's key) the minimax score for that new game state
    ;if the active player is "O"
      ;get the key @ max val from your completed scores list
    ;otherwise
      ;get he kay @ min val from your completed scores list


(defn choose-move [board]
;  (str (first (board/available-spaces board))))
    (str (minimax board)))


