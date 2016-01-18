 (ns tictactoe.output)


(defn displayln [message]
	(println message))

(defn display [message]
	(print message))

(defn formatted-board [board]
	(partition 3 board))
