(ns tictactoe.extensive-ai-spec
  (:require [speclj.core :refer :all]
            [tictactoe.board :as board]
            [tictactoe.ai :as ai]))

(def human-player "X")

(def ai-player "O")

(defn player-can-win?
  ([board]
    (player-can-win? board (board/available-spaces board)))
  ([board spots-to-check]
    (if (empty? spots-to-check)
      false
      (if (= human-player (board/winner (board/fill-space (first spots-to-check) human-player board)))
        true
        (recur board (rest spots-to-check))))))

(defn choose-best-player-move
  ([board]
    (choose-best-player-move board (board/available-spaces board)))
  ([board open-spots]
    (if (= 1 (count open-spots))
      (first open-spots)
      (if (= ai-player (board/winner (board/fill-space (first open-spots) ai-player board)))
        (first open-spots)
        (recur board (rest open-spots))))))

(defn ai-did-not-lose? [board]
  (if (or (= (board/winner board) ai-player) (board/cats-game? board))
    true
    false))

(defn ai-cannot-lose?
  ([]
    (ai-cannot-lose? (vec (range 9))))
  ([board]
    (if (board/game-over? board)
      (ai-did-not-lose? board)
      (if (= (board/active-player board) ai-player)
        (recur (board/fill-space (ai/choose-move board ai-player) ai-player board))
        (if (= true (player-can-win? board))
          false
          (recur (board/fill-space (choose-best-player-move board) human-player board)))))))

(describe "Generate Many AI Board Outcomes"
  (tags :gen)
  (it "the AI never loses when using the 'choose-move' algorithm"
      (should= true (ai-cannot-lose?))))

