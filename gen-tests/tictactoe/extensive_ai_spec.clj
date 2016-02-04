(ns tictactoe.extensive-ai-spec
  (:require [speclj.core :refer :all]
            [tictactoe.board :as board]
            [tictactoe.ai :as ai]))
            ;[clojure.test.check.generators :as gen]
            ;[clojure.test.check :as tc]
            ;[clojure.test.check.properties :as prop]))

(def human-player "X")

(def ai-player "O")

(def num-tests 2)

(defn get-spot-choice [player board]
  (if (= player human-player)
    (str (rand-nth (board/available-spaces board)))
    (ai/choose-move board ai-player)))

(defn play-next-turn [board]
  (let [active-player (board/active-player board)
        choice (get-spot-choice active-player board)]
      (board/fill-space choice active-player board)))

(defn simulated-game-winner []
  (loop [board (vec (range 9))]
    (if (board/game-over? board)
      (cond (board/winner board) (board/winner board)
        (board/cats-game? board) "tie")
        (recur (play-next-turn board)))))

(defn print-stats [winners]
  (println (str "AI Marker: " ai-player))
  (println (str "Player Marker: " human-player))
  (println (str "AI is playing " num-tests " games vs. a randomly guessing 'human'."))
  (print "Winners: ")
  (apply println winners))

(describe "Generate Many AI Board Outcomes"
  (tags :gen)
  (it "the AI never loses when using the 'choose-move' algorithm"
    (let [winners (repeatedly num-tests simulated-game-winner)]
      (print-stats winners)
      (should= nil (some #(= human-player %) winners)))))

