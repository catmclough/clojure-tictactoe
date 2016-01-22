(ns tictactoe.setup
   (:require [tictactoe.interface :as interface]))


(defn welcome-players []
 	(interface/welcome-player))

(defn set-player-markers []
  ["X" "O"])

(defn make-board []
	(vec (range 9)))

(defn setup-game []
  (welcome-players))


