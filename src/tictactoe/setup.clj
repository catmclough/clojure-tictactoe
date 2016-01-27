(ns tictactoe.setup
   (:require [tictactoe.console :as console]))

(defn welcome-players []
 	(console/welcome-player))

(defn set-player-markers []
  ["X" "O"])

(defn make-board []
	(vec (range 9)))

(defn setup-game []
  (welcome-players))

