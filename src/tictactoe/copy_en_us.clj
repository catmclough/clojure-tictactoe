(ns tictactoe.copy-en-us)

(def welcome-message "Hello and Welcome to TicTacToe!")

(defn player-turn-prompt [marker] (println marker)
 (str "Player " marker ", please choose your spot: "))
