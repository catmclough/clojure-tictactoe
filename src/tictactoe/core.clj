(ns tictactoe.core
    (:require
              [tictactoe.setup :as setup]
              [tictactoe.console :as console]
              [tictactoe.board :as board]
              [tictactoe.ai :as ai]))

(def player-one "X")

(defn get-spot-choice [player board]
  (if (= player player-one)
      (do (console/prompt-player-turn player) (flush) (console/get-input))
      (do (console/ai-choosing) (ai/choose-move board))))

(defn pick-and-validate-next-spot [board]
  (let [active-player (board/active-player board)]
    (loop [choice (get-spot-choice active-player board)]
		  (let [new-board (board/fill-space choice active-player board)]
        (if (not new-board)
	  			(recur (get-spot-choice active-player board))
	  			new-board)))))

(defn end-game [board]
  (cond (board/winner board) (console/winner-message (board/winner board))
        (board/cats-game? board) (console/cats-game-message)))

(defn -main []
  (setup/setup-game)
  (loop [board (setup/make-board)]
		  (console/print-board board)
		  (if (board/game-over? board)
        (end-game board)
        (recur (pick-and-validate-next-spot board)))))

