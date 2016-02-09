(ns tictactoe.setup-spec
  (:require [speclj.core :refer :all]
            [tictactoe.setup :refer :all]
            [tictactoe.console :as console]))

;(defn set-game-type []
  ;(loop [type-choice (console/get-game-type)]
    ;(if (valid-type-choice? type-choice)
      ;type-choice
      ;(do
        ;(console/game-type-prompt player-ai-game-type two-ai-game-type)
        ;(set-game-type)))))

(def board-size 9)

(describe "board"
	(with empty-board [0 1 2 3 4 5 6 7 8])
  (tags :setup-spec)

(describe "make-board"
	(it "makes a board with nine empty spaces represented as numbers"
		(should= (make-board board-size) @empty-board)))

(describe "set-game-type"
    ;(with-out-str
      (with-redefs
        [console/get-game-type (fn [] 2)]

  (it "returns the type choice if valid"
    (should= 2 set-game-type))))

(describe "setup-game"
  (around [it]
    (with-out-str
      (with-redefs
        [welcome-players #(constantly nil)
         set-game-type #(constantly 2)]
        (it))))

  (it "welcomes the players"
    (should-invoke welcome-players {:times 1} (setup-game)))

  (it "prompts the user to choose a game type"
    (should-invoke console/game-type-prompt {:times 1} (setup-game)))

  (it "tells describes the chosen game type to the user"
    (should-invoke console/two-ai-game-description {:times 1} (setup-game)))))

;    (xit "sets the player's markers"
    ;(should= "X" player-one)
    ;(should= "O" player-two))))

