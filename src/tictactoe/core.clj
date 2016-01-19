(ns tictactoe.core
    (:require
              [tictactoe.setup :as setup]
              [tictactoe.output :as output]
              [tictactoe.input :as input]
              [tictactoe.copy-en-us :as copy]
              [tictactoe.board :as board]))

(defn print-board [board]
	(doseq [row (output/formatted-board board)]
		(output/displayln (vec row))))

(defn get-spot [player]
  (do (output/display (copy/player-turn-prompt player)) (flush) (input/get-input)))

(defn pick-next-spot [board]
  (let [active-player (board/player-up-next board)]
  	(loop [choice (get-spot active-player)]
		  (let [new-board (board/fill-space choice active-player board)]
	  		(if (not new-board)
	  			(recur (get-spot active-player))
	  			new-board)))))

(defn -main []
  (setup/setup-game)
  (loop [board (setup/make-board)]
		  (print-board board)
		  (if (board/winner? board)
			  (println "Winner")
			  (do
          (recur (pick-next-spot board))))))

