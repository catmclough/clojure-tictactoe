(ns tictactoe.core-spec
    (:require [speclj.core :refer :all]
              [tictactoe.core :refer :all]
              [clojure.java.io :as io]))

(defn make-input [entries]
  (apply str (interleave entries (repeat "\n"))))

(describe "main"
  (around [it]
    (with-out-str (it)))

  (it "handles all spot-choice input without breaking"
      (should= nil (with-in-str (make-input '("*" "*" "3" "3" "0" "beep-boop" "1")))))

  (it "runs, receiving input and updating the board, but ends if computer wins"
      (should= nil (with-in-str (make-input '("3" "0" "1")) (-main))))

  (it "runs, receiving input and updating the board, but ends if game is tied"
      (should= nil (with-in-str (make-input '("0" "8" "1" "6" "5")) (-main)))))

