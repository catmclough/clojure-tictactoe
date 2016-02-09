(ns tictactoe.setup-spec
  (:require [speclj.core :refer :all]
            [tictactoe.setup :refer :all]
            [tictactoe.console :as console]))

(def board-size 9)

(describe "board"
	(with empty-board [0 1 2 3 4 5 6 7 8])
  (tags :setup-spec)

(describe "valid-type-choice?"
  (it "returns true if given game type choice is valid option"
    (should= true (valid-type-choice? player-ai-game-type))))

(describe "set-game-type"
  (around [it]
    (with-out-str (it)))

  (it "returns the type choice if valid"
    (with-redefs
      [console/get-game-type (fn [] 2)]
        (should= 2 (set-game-type)))))

(describe "setup-game"
  (around [it]
    (with-out-str
      (with-redefs
        [welcome-players (fn [] nil)
         set-game-type (fn [] 2)]
        (it))))

  (it "welcomes the players"
    (should-invoke welcome-players {:times 1} (setup-game)))

  (it "prompts the user to choose a game type"
    (should-invoke console/game-type-prompt {:times 1} (setup-game)))

  (it "tells describes the chosen game type to the user"
    (should-invoke console/two-ai-game-description {:times 1} (setup-game)))))

