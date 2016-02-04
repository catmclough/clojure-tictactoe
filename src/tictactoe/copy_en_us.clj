(ns tictactoe.copy-en-us)

(def welcome-message "Hello and Welcome to TicTacToe!")

(defn game-type [type]
  (str "Game: "
    (cond (= type 2) "Two Computer"
          (= type 1) "Player (X) vs. Computer (O)")))

(def game-type-prompt "Enter 1 to play an AI, or 2 to see 2 AIs play eachother: ")

(defn player-turn-prompt [marker]
 (str "Player " marker ", please choose your spot: "))

(def ai-choosing-message "AI is Considering the Options")

(defn winner-message [winner]
  (str "Game Over.\n" winner " has won the game."))

(def cats-game-message "Game of Cats, this is a Cats Game")

