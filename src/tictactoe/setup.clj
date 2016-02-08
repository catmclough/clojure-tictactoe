(ns tictactoe.setup
   (:require [tictactoe.console :as console]))

(defn welcome-players []
 	(console/welcome-player))

(def player-one "X")

(def player-two "O")

(def player-ai-game-type 1)

(def two-ai-game-type 2)

(defn make-board []
	(vec (range 9)))

(defn valid-type-choice? [choice]
  (or (= player-ai-game-type choice) (= two-ai-game-type choice)))

(defn set-game-type []
  (loop [type-choice (console/get-game-type)]
    (if (valid-type-choice? type-choice)
      type-choice
      (do
        (console/game-type-prompt player-ai-game-type two-ai-game-type)
        (set-game-type)))))

(defn setup-game []
  (welcome-players)
  (console/game-type-prompt player-ai-game-type two-ai-game-type)
  (let [game-type (set-game-type)]
    (cond (= game-type player-ai-game-type) (console/player-ai-game-description)
          (= game-type two-ai-game-type) (console/two-ai-game-description))
    game-type))

