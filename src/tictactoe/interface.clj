(ns tictactoe.interface
    (:require [tictactoe.copy-en-us :as copy]))

(defn displayln [message]
	(println message))

(defn display [message]
	(print message))

(defn get-input []
	(read-line))

(defn formatted-board [board]
	(partition 3 board))

(defn print-board [board]
	(doseq [row (formatted-board board)]
		(displayln (vec row))))

(defn welcome-player []
  (displayln copy/welcome-message))

(defn prompt-player-turn [marker]
  (displayln (copy/player-turn-prompt marker)))

(defn ai-choosing []
  (displayln copy/ai-choosing-message))

(defn winner-message []
  (displayln copy/winner-message))

(defn cats-game-message []
  (displayln copy/cats-game-message))
