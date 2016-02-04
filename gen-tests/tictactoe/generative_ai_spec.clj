(ns tictactoe.generative-ai-spec
  (:require [speclj.core :refer :all]
            [clojure.pprint]
            [tictactoe.core :refer :all]
            [tictactoe.setup :as setup]
            [tictactoe.board :as board]
            [tictactoe.ai :as ai]
            [tictactoe.console :as console]
            [clojure.test.check.generators :as gen]
            [clojure.test.check :as tc]
            [clojure.test.check.properties :as prop]))

;(defn get-spot-choice [player board]
  ;(if (= player player-one)
      ;;(do (console/prompt-player-turn player) (flush) (console/get-input))
      ;(do (console/ai-choosing) (ai/choose-move board "X"))
      ;(do (console/ai-choosing) (ai/choose-move board "O"))))

;(defn pick-and-validate-next-spot [board]
  ;(let [active-player (board/active-player board)]
    ;(loop [choice (get-spot-choice active-player board)]
        ;(or
          ;(try
            ;(board/fill-space choice active-player board)
            ;(catch Exception e (console/displayln (.getMessage e))))
          ;(recur (get-spot-choice active-player board))))))

;(defn simulated-game-winner []
  ;(loop [board (setup/make-board)]
      ;(console/refresh-round board)
        ;(if (board/game-over? board)
          ;(cond (board/winner board) (board/winner board)
                ;(board/cats-game? board) "none")
          ;(recur (pick-and-validate-next-spot board)))))

;(defmacro check-that [desc n property]
  ;`(it ~desc
    ;(let [check# (tc/quick-check ~n ~property)
          ;passed# (:result check#)]
      ;(when-not passed# (clojure.pprint/pprint check#))
      ;(should passed#))))

;(describe "Generative AI Board Outcomes"
  ;(check-that "the AI never loses"
    ;1
    ;(prop/for-all [winner (gen/string simulated-game-winner)]
        ;(= "none" winner))))
