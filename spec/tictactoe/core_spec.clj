(ns tictactoe.core-spec
    (:require [speclj.core :refer :all]
              [tictactoe.core :refer :all]
              [clojure.java.io :as io]))

;(describe "-main;"
  ;(around [it]
    ;(with-out-str (it)))

  ;(xit "welcomes the players"
      ;(should= "Hello and Welcome to Tic-Tac-Toe!\n")

  ;(xit "prints uses the output to display the current board state"
      ;(let [output (with-out-str "[0 1 2]\n[3 4 5]\n[6 7 8]\n")
        ;lines (line-seq (io/reader (java.io.ByteArrayInputStream.(.getBytes output))))]
        ;(should= output (last lines))))))

