(ns tictactoe.extensive-ai-spec
  (:require [speclj.core :refer :all]
            [tictactoe.board :as board]
            [tictactoe.ai :as ai]))

(def human-player "X")

(def ai-player "O")

(defn get-hypothetical-boards [board]
  (let [open-spots (board/available-spaces board)]
    (map #(board/fill-space % human-player board) open-spots)))

(defn possible-winners
  ([]
    (possible-winners (board/make-board) []))
  ([board possible-winner-list]
      (if (board/game-over? board)
        (conj possible-winner-list (board/winner board))
        (if (= (board/active-player board) ai-player)
          (recur (board/fill-space (ai/choose-move board ai-player) ai-player board) possible-winner-list)
            (map #(possible-winners % possible-winner-list) (get-hypothetical-boards board))))))

(describe "Generate Many AI Board Outcomes"
  (tags :gen)
  (it "the AI never loses when using the 'choose-move' algorithm"
      (println "Generating All Possible Winners: ")
      (let [winners (flatten (possible-winners))]
        (apply println winners)
        (println (str (count winners) " possible outcomes found"))
        (should= nil (some #(= human-player %) winners)))))

