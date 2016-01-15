(ns tictactoe.core 
	(:require [tictactoe.output :as output]
	          [tictactoe.input :as input] 
		  [tictactoe.view :as view]
		  [tictactoe.board :as board]))

(def empty-board [" " " " " " " " " " " " " " " " " "])

(defn print-board [board]
	(doseq [row (board/formatted-board board)]
		(output/displayln (vec row))))

(defn get-spot [player] (do (output/display (view/player-turn-prompt player)) (flush) (input/get-input))) 

(defn pick-next-spot [board]
	(loop [choice (get-spot "X")]
		(let [new-board (board/fill-space choice "X" board)]
			(if (not new-board)
				(recur (get-spot "X"))
				new-board))))
(defn -main []
	(output/displayln view/welcome-message) (loop [board (board/make-board)]	
		(print-board board)
		(if (board/winner? board)
			(println "Winner")
			(recur (pick-next-spot board)))))

