(ns tictactoe.core-spec
    (:require [speclj.core :refer :all]
              [tictactoe.core :refer :all]
              [tictactoe.setup :as setup]
              [tictactoe.board :as board]
              [tictactoe.console :as console]))

(def two-ai-type 2)

(def player-ai-type 1)

(defn make-input [entries]
  (apply str (interleave entries (repeat "\n"))))

(describe "core"
  (tags :core)

  (describe "main"
		(around [it]
		  (with-out-str
		    (with-redefs
		      [play-game (fn [game-type] nil)
		       setup/setup-game (fn [] two-ai-type)]
		  (it))))

		(it "sets up the game"
		  (should-invoke setup/setup-game {:times 1} (-main)))

		(it "initiates game-play"
		  (should-invoke play-game {:times 1} (-main))))

  (describe "gameplay"
    (context "game is not over"
		  (around [it]
		    (with-out-str
		      (with-redefs
		        [console/refresh-board (fn [board] nil)
		         end-game (fn [board] nil)
		         play-turn (fn [board game-type] '("X" "X" "X" "O" "O" 5 "O" 7 8))]
		  (it))))

		  (it "continuously receives input and updates the board, ending if the game is won"
		    (should= nil (with-in-str (make-input '("1" "3" "0" "1")) (play-game player-ai-type))))

		  (it "continuously receives input and updates the board, ending if the game is tied"
		    (should= nil (with-in-str (make-input '("1" "0" "8" "1" "6" "5")) (play-game player-ai-type)))))

		(context "game is over"
			(around [it]
			  (with-out-str
			    (with-redefs
			      [console/refresh-board (fn [board] nil)
			       board/game-over? (fn [board] true)
			       end-game (fn [board] nil)]
			  (it))))

			(it "prints the current board state"
			  (should-invoke console/refresh-board {:times 1} (play-game two-ai-type)))

			(it "ends the game"
			  (should-invoke end-game {:times 1} (play-game two-ai-type))))

		(context "User chooses invalid spot choice"
		  (tags :slow)
		  (it "handles all spot-choice input without breaking"
		    (should= nil (with-in-str (make-input '("1" "*" "*" "3" "3" "0" "beep-boop" "1"))))))))

