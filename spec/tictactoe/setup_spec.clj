(ns tictactoe.output-spec
  (:require [speclj.core :refer :all]
            [tictactoe.setup :refer :all]))

(describe "setup-game"
    (it "prints a welcome message"
        (should= (copy/welcome-message) (welcome-player)))
    (it "sets the player's markers"
        (should= 2 (count set-player-markers))))
