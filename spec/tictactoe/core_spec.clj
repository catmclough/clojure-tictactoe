(ns tictactoe.core-spec
  (:require [speclj.core :refer :all]
            [tictactoe.core :refer :all]
	    [clojure.java.io :as io]))

(describe "main"
	(it "should print board with 'X' in the given position"
		(let [input "0\n1\n2\n"
		      output (with-out-str
				(with-in-str input (-main)))
			lines (line-seq (io/reader (java.io.ByteArrayInputStream. (.getBytes output))))]
		(prn output)
		(should= "Winner" (last lines)))))
