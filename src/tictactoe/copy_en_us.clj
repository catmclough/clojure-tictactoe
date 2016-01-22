(ns tictactoe.copy-en-us)

(def welcome-message "Hello and Welcome to TicTacToe!")

(defn player-turn-prompt [marker]
 (str "Player " marker ", please choose your spot: "))

(def ai-choosing-message "AI is Considering the Options")

(defn winner-message [winner]
  (str "Game Over.\n" winner " has won the game."))

(def cats-game-message "Game of Cats, this is a Cats Game")
