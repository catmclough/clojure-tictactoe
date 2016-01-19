(ns tictactoe.setup
   (:require [tictactoe.interface :as interface]
             [tictactoe.copy-en-us :as copy]))


(defn welcome-players []
 	(interface/displayln copy/welcome-message))

(defn set-player-markers []
  ["X" "O"])

(defn make-board []
	(vec (range 9)))

(defn setup-game []
  (welcome-players))


