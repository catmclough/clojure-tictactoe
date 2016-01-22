(ns tictactoe.core
    (:require
              [tictactoe.setup :as setup]
              [tictactoe.interface :as interface]
              [tictactoe.copy-en-us :as copy]
              [tictactoe.board :as board]
              [tictactoe.ai :as ai]))

(defn get-spot [player board]
  (if (= player "X")
      (do (interface/display (copy/player-turn-prompt player)) (flush) (interface/get-input))
      (do (interface/displayln "AI is Considering the Options") (ai/choose-move board))))

(defn pick-next-spot [board]
  (let [active-player (board/active-player board)]
    (loop [choice (get-spot active-player board)]
		  (let [new-board (board/fill-space choice active-player board)]
        (if (not new-board)
	  			(recur (get-spot active-player board))
	  			new-board)))))

(defn end-game [board]
  (cond (board/winner board) (interface/winner-message)
        (board/cats-game? board) (interface/cats-game-message)))

(defn -main []
  (setup/setup-game)
  (loop [board (setup/make-board)]
		  (interface/print-board board)
		  (if (board/game-over? board)
        (end-game board)
        (recur (pick-next-spot board)))))

