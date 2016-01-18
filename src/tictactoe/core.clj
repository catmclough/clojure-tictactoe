(ns tictactoe.core 
    (:require [tictactoe.output :as output]
              [tictactoe.input :as input] 
              [tictactoe.copy-en-us :as copy]
              [tictactoe.board :as board]))

(defn print-board [board]
	(doseq [row (output/formatted-board board)]
		(output/displayln (vec row))))

(defn get-spot [player]
  (do (output/display (copy/player-turn-prompt player)) (flush) (input/get-input)))

(defn pick-next-spot [board]
	(loop [choice (get-spot "X")]
		(let [new-board (board/fill-space choice "X" board)]
			(if (not new-board)
				(recur (get-spot "X"))
				new-board))))

(defn -main []
	(output/displayln copy/welcome-message)
    (loop [board (board/make-board)]
		  (print-board board)
		  (if (board/winner? board)
			  (println "Winner")
			  (recur (pick-next-spot board)))))

