(ns tictactoe.ai
  (:require [tictactoe.board :as board]))

(def ai-marker "O")

(defn hypothetical-boards [board]
  (let [open-spots (board/available-spaces board)]
    (map #(board/fill-space (str %) (board/active-player board) board) open-spots)))

(defn score-game [board-state depth]
  (cond (= ai-marker (board/winner board-state)) (- 10 depth)
      (and (board/winner board-state) (not= ai-marker (board/winner board-state))) (- depth 10)
      :else 0))

(defn minimax
  ([board]
      (minimax board 0))
  ([board depth]
    (let [score (score-game board depth)]
      (if (board/game-over? board)
        score
        (do
          (let [depth (inc depth)]
          (if (= (board/active-player board) ai-marker)
            (apply max (map #(minimax % depth) (hypothetical-boards board)))
            (apply min (map #(minimax % depth) (hypothetical-boards board))))))))))

(defn get-scores [board]
  (let [open-spots (board/available-spaces board)
        minimax-scores (map #(minimax %) (hypothetical-boards board))]
    (map (fn [space score] {:space space :score score}) open-spots minimax-scores)))

(defn choose-move [board]
  (let [scores (get-scores board)]
    (str (:space (apply max-key :score scores)))))

