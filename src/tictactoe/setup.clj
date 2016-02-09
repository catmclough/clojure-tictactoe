(ns tictactoe.setup
   (:require [tictactoe.console :as console]))

(defn welcome-players []
 	(console/welcome-player))

(def player-one "X")

(def player-two "O")

(def player-ai-game-type 1)

(def two-ai-game-type 2)

(defn make-board [size]
	(vec (range size)))

(defn valid-type-choice? [choice]
  (println (or (= 1 choice) (= 2 choice)))
  (or (= 1 choice) (= 2 choice)))

(defn set-game-type []
  (loop [type-choice (console/get-game-type)]
    (if (valid-type-choice? type-choice)
      type-choice
      (do
        (console/game-type-prompt 1 2)
        (set-game-type)))))

(defn setup-game []
  (welcome-players)
  (console/game-type-prompt 1 2)
  (let [game-type (set-game-type)]
    (cond (= game-type 1) (console/player-ai-game-description)
          (= game-type 2) (console/two-ai-game-description))
    game-type))

