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

(describe "main"
  (tags :core)

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
  (tags :core)

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

  (context "game is not over"
    (around [it]
      (with-out-str
        (with-redefs
          [console/refresh-board (fn [board] nil)
           end-game (fn [board] nil)
           play-turn (fn [board game-type] '("X" "X" "X" "O" "O" 5 "O" 7 8))]
    (it))))

    (it "does not end the game, but continues to receive input and update the board until the game has been won"
      (should= nil (with-in-str (make-input '("1" "3" "0" "1")) (play-game player-ai-type))))

    (it "runs, receiving input and updating the board, but ends if game is tied"
      (should= nil (with-in-str (make-input '("1" "0" "8" "1" "6" "5")) (play-game player-ai-type)))))

  (context "Invalid Input"
    (tags :slow)
    (it "handles all spot-choice input without breaking"
      (should= nil (with-in-str (make-input '("1" "*" "*" "3" "3" "0" "beep-boop" "1")))))))

