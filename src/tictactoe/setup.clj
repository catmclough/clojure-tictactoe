(ns tictactoe.setup
   (:require [tictactoe.console :as console]))

(defn welcome-players []
 	(console/welcome-player))

(def player-one "X")

(def player-two "O")

(defn make-board []
	(vec (range 9)))

(defn valid-type-choice? [choice]
  (or (= 1 choice) (= 2 choice)))

(defn set-game-type []
  (loop [type-choice (console/get-game-type)]
    (if (valid-type-choice? type-choice)
      type-choice
      (do
        (console/game-type-prompt)
        (set-game-type)))))

(defn setup-game []
  (welcome-players)
  (console/game-type-prompt)
  (flush)
  (let [game-type (set-game-type)]
    (console/give-game-type game-type)
    game-type))

