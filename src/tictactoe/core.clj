(ns tictactoe.core
	(:require [tictactoe.board :as board]
            	  [tictactoe.output :as output]
           	  [tictactoe.view :as view]
            ))

(defn print-board [board]
	(doseq [row (board/formatted-board board)]
		(output/display (vec row))))

(defn -main []
	(output/display view/welcome-message)
	(print-board [" " " " " " " " " " " " " " " " " "])
	(output/display (view/player-turn-prompt "X")))

