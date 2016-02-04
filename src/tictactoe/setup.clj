(ns tictactoe.setup
   (:require [tictactoe.console :as console]))

(defn welcome-players []
 	(console/welcome-player))

(def player-one "X")

(def player-two "O")

(defn make-board []
	(vec (range 9)))

(defn setup-game [game-type]
  (welcome-players)
  (console/give-game-type game-type))

