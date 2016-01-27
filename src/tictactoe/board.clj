(ns tictactoe.board)

(def player-one "X")
(def player-two "O")
(def board-size 9)

(defn space-is-empty? [position board]
	(number? (nth board position)))

(defn filled? [board]
	(not-any? number? board))

(defn available-spaces [board]
	(filter #(space-is-empty? % board) (range board-size)))

(defn active-player [board]
  (let [x-count (get (frequencies board) player-one)
        o-count (get (frequencies board) player-two)]
    (cond (= x-count nil) player-one
          (= o-count nil) player-two
          (<= x-count o-count) player-one
          :else player-two)))

(defn horizontal-slices [board]
  	(partition 3 board))

(defn vertical-slices [board]
  	(apply map list (horizontal-slices board)))

(defn diagonal-one [board]
  	(list (nth board 0) (nth board 4) (nth board 8)))

(defn diagonal-two [board]
 	(list (nth board 2) (nth board 4) (nth board 6)))

(defn horizontal-winner [board]
  	(let [horizontals (horizontal-slices board)]
    	(cond
        (and (not-any? number? (first horizontals)) (apply = (first horizontals)))
            (first (first horizontals))
        (and (not-any? number? (second horizontals)) (apply = (second horizontals)))
            (first (second horizontals))
        (and (not-any? number? (nth horizontals 2)) (apply = (nth horizontals 2)))
            (first (nth horizontals 2)))))

(defn vertical-winner [board]
  (let [verticals (vertical-slices board)]
    (cond (and (not-any? number? (first verticals)) (apply = (first verticals)))
              (first (first verticals))
          (and (not-any? number? (second verticals)) (apply = (second verticals)))
              (first (second verticals))
          (and (not-any? number? (nth verticals 2)) (apply = (nth verticals 2)))
              (first (nth verticals 2)))))

(defn diagonal-winner [board]
  (let [diagonals ((fn [x] (list (diagonal-one x) (diagonal-two x))) board)]
      (cond (and (not-any? number? (first diagonals)) (apply = (first diagonals)))
                (first (first diagonals))
            (and (not-any? number? (second diagonals)) (apply = (second diagonals)))
                (first (second diagonals)))))

(defn winner [board]
  (or (horizontal-winner board) (vertical-winner board) (diagonal-winner board)))

(defn cats-game? [board]
  (and (not (winner board)) (filled? board)))

(defn game-over? [board]
  (cond (winner board) true
        (cats-game? board) true
        :else false))

(defn valid-spot-choice? [choice board]
	(and (some #{choice} (vec (map #(str %)(range 9))))
	     (some #{choice} (vec (map #(str %) (available-spaces board))))))

(defn fill-space
	[choice marker board]
		(if (valid-spot-choice? choice board)
			(assoc board (Integer/parseInt choice) marker)
			false))
