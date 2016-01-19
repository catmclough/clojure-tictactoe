(ns tictactoe.core-spec
    (:require [speclj.core :refer :all]
              [tictactoe.core :refer :all]
              [clojure.java.io :as io]))

(describe "main" 
	(xit "should print 'Winner' when there is a winner of the board"
		(let [input "0\n3\n1\n4\n2\n5\n"
		      output (with-out-str (with-in-str input (-main)))
			    lines (line-seq (io/reader (java.io.ByteArrayInputStream. (.getBytes output))))]
      (should= "Winner!" (last lines)))))

