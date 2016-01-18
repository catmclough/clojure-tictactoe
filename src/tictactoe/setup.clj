(ns tictactoe.setup
  :require [tictactoe.output :as output]
          [tictactoe.copy-en-us :as copy])

(defn setup-game []
  welcome-player) 

(defn welcome-player []
 	(output/displayln copy/welcome-message)) 

(defn set_player_markers []
  ["X" "O"])
