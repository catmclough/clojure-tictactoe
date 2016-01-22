(ns tictactoe.core
    (:require
              [tictactoe.setup :as setup]
              [tictactoe.interface :as interface]
              [tictactoe.board :as board]
              [tictactoe.ai :as ai]))

(defn get-spot-choice [player board]
  (if (= player "X")
      (do (interface/prompt-player-turn player) (flush) (interface/get-input))
      (do (interface/ai-choosing) (ai/choose-move board))))

(defn pick-and-validate-next-spot [board]
  (let [active-player (board/active-player board)]
    (loop [choice (get-spot-choice active-player board)]
		  (let [new-board (board/fill-space choice active-player board)]
        (if (not new-board)
	  			(recur (get-spot-choice active-player board))
	  			new-board)))))

(defn end-game [board]
  (cond (board/winner board) (interface/winner-message (board/winner board))
        (board/cats-game? board) (interface/cats-game-message)))

(defn -main []
  (setup/setup-game)
  (loop [board (setup/make-board)]
		  (interface/print-board board)
		  (if (board/game-over? board)
        (end-game board)
        (recur (pick-and-validate-next-spot board)))))

