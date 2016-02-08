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

(defn game-type-prompt [player-ai-game-type two-ai-game-type]
  (display (copy/game-type-prompt player-ai-game-type two-ai-game-type))
  (flush))

(defn get-game-type []
  (Integer/parseInt (get-input)))

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

(defn player-ai-game-description []
  (displayln copy/player-ai-game-description))

(defn two-ai-game-description []
  (displayln copy/two-ai-game-description))

(defn prompt-player-turn [marker]
  (display (copy/player-turn-prompt marker)))

(defn ai-choosing []
  (displayln copy/ai-choosing-message))

(defn winner-message [winner]
  (displayln (copy/winner-message winner)))

(defn cats-game-message []
  (displayln copy/cats-game-message))

