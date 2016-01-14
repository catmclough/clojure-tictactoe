(ns tictactoe.board)

(defn make-board []
	(vec (repeat 9 " ")))

(defn fill-space [position marker board]
	(assoc board position marker))

(defn clear-space [position board]
	(fill-space position " " board))

(defn space-is-empty? [position board]
	(clojure.string/blank? (nth board position)))

(defn filled? [board] 
	(not-any? clojure.string/blank? board))

(defn available-spaces [board]
	(filter #(space-is-empty? % board) (range 9)))

(defn horizontal-slices [board]
  	(partition 3 board))

(defn vertical-slices [board]
  	(apply map list (horizontal-slices board)))

(defn diagonal-one [board]
  	(list (nth board 0) (nth board 4) (nth board 8)))

(defn diagonal-two [board]
 	(list (nth board 2) (nth board 4) (nth board 6)))

(defn formatted-board [board]
	(partition 3 (replace {" " "--"} board)))	

(defn horizontal-winner? [board]
  	(let [horizontals (horizontal-slices board)]
    	(or (and (not-any? clojure.string/blank? (first horizontals)) (apply = (first horizontals)))
        (and (not-any? clojure.string/blank? (second horizontals)) (apply = (second horizontals)))
        (and (not-any? clojure.string/blank? (nth horizontals 2)) (apply = (nth horizontals 2))))))

(defn vertical-winner? [board]
  (let [verticals (vertical-slices board)]
    (or (and (not-any? clojure.string/blank? (first verticals)) 
	     (apply = (first verticals)))
        (and (not-any? clojure.string/blank? (second verticals)) 
	     (apply = (second verticals)))
        (and (not-any? clojure.string/blank? (nth verticals 2)) 
	     (apply = (nth verticals 2))))))

(defn diagonal-winner [board]
  (let [diagonals ((fn [x] (list (diagonal-one x) (diagonal-two x))) board)]
    (or (and (not-any? clojure.string/blank? (first diagonals)) (apply = (first diagonals)))
        (and (not-any? clojure.string/blank? (second diagonals)) (apply = (second diagonals))))))

(defn winner? [board]
  (or (horizontal-winner? board) (vertical-winner? board) (diagonal-winner board)))

(defn winner [board markers]
  (cond
	(and (winner? board) (even? (count (available-spaces board))))
		(first markers)
	(and (winner? board) (odd? (count (available-spaces board))))
		(second markers)
	:else nil))

(defn cats-game? [board]
  (and (not (winner? board)) (filled? board)))


