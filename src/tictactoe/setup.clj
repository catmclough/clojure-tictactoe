(ns tictactoe.setup
   (:require [tictactoe.console :as console]))

(defn welcome-players []
 	(console/welcome-player))

(def player-one "X")

(def player-two "O")

(defn make-board []
	(vec (range 9)))

(defn setup-game []
  (welcome-players))

