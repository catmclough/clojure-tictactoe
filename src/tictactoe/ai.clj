(ns tictactoe.ai
  (:require [tictactoe.board :as board]))

(defn possible-moves [board]
  (let [open-spots (board/available-spaces board)]
    (map #(board/fill-space (str %) (board/active-player board) board) open-spots)))

(defn score-game [board-state]
  (cond (= "O" (board/winner board-state)) 1
        (= "X" (board/winner board-state)) -1
        :else 0))

(defn minimax [board]
  (let [score (score-game board)]
    (if (board/filled? board)
      score
      (do
        (if (= (board/active-player board) "O")
          (apply max (map #(minimax %) (possible-moves board)))
          (apply min (map #(minimax %) (possible-moves board))))))))

(defn get-scores [board]
  (let [open-spots (board/available-spaces board)]
    ;(println (possible-moves board)) => (false false false false)
    (map vector open-spots (map #(minimax %) (possible-moves board)))))

(defn choose-move [board]
  (str (key (apply max-key val (into {} (get-scores board))))))

