(ns tictactoe.view-spec
	(:require [speclj.core :refer :all]
            [tictactoe.view :refer :all]))

(describe "welcome-screen"
	(it "displays a welcome message"
		(should= "Hello and Welcome to TicTacToe!" welcome-message)))

(describe "prompt-player-turn"
	(it "identifies the player by their marker and prompts them to choose a spot"
		(should= "Player X, please choose your spot: " (player-turn-prompt "X"))))

