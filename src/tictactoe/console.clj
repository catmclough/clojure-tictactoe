(ns tictactoe.console
    (:require [tictactoe.copy-en-us :as copy]))

(defn displayln [message]
	(println message))

(defn display [message]
	(print message))

(defn clear-screen []
  (print "\u001b[2J"))

(defn get-input []
	(read-line))

(defn- formatted-board [board]
	(partition 3 board))

(defn print-board [board]
	(doseq [row (formatted-board board)]
		(displayln (vec row))))

(defn refresh-round [board]
    (clear-screen)
		(print-board board))

(defn welcome-player []
  (displayln copy/welcome-message))

(defn prompt-player-turn [marker]
  (display (copy/player-turn-prompt marker)))

(defn ai-choosing []
  (displayln copy/ai-choosing-message))

(defn winner-message [winner]
  (displayln (copy/winner-message winner)))

(defn cats-game-message []
  (displayln copy/cats-game-message))

