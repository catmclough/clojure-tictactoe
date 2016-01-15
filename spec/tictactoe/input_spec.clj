(ns tictactoe.input-spec
  (:require [speclj.core :refer :all]
            [tictactoe.input :refer :all]))

(describe "get-input"
	(it "receives input from the command line"
		(should= "XOXO" (with-in-str "XOXO" (get-input)))))
