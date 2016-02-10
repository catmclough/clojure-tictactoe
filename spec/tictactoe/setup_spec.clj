(ns tictactoe.setup-spec
  (:require [speclj.core :refer :all]
            [tictactoe.setup :refer :all]
            [tictactoe.console :as console]))

(def board-size 9)

(def invalid-game-type-num 999)

(def invalid-game-type-choice "chutes and ladders")

(def empty-board [0 1 2 3 4 5 6 7 8])

(describe "setup"
  (tags :setup-spec)

  (describe "set-game-type"
		(around [it]
		  (with-out-str (it)))

		(it "returns the type choice if valid"
		  (should= two-ai-game-type (set-game-type two-ai-game-type)))

		(it "prompts the player to choose a different type if given a number that does not correspond to a game type"
      (with-redefs
		    [console/get-game-type (fn [] two-ai-game-type)]
		    (should= two-ai-game-type (set-game-type invalid-game-type-num))))

      (it "prompts the player to choose a different type if given a string as the game-type choice"
      (with-redefs
		    [console/get-game-type (fn [] player-ai-game-type)]
        (should= player-ai-game-type (set-game-type invalid-game-type-choice)))))

  (describe "setup-game"
	 (around [it]
	   (with-out-str
	     (with-redefs
	       [welcome-players (fn [] nil)
          console/get-game-type (fn [] 2)]
	       (it))))

	 (it "welcomes the players"
	   (should-invoke welcome-players {:times 1} (setup-game)))

	 (it "prompts the user to choose a game type"
	   (should-invoke console/game-type-prompt {:times 1} (setup-game)))

	 (it "describes the chosen game type to the user"
	   (should-invoke console/two-ai-game-description {:times 1} (setup-game)))))

