(defproject tic-tac-toe "0.1.0-SNAPSHOT"
  :description "A command line AI tic-tac-toe game written in Clojure."
  :url "http://https://github.com/catmclough/clojure-tictactoe"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0-RC2"]
                 [org.clojure/test.check "0.9.0"]]
  :profiles {:dev {:dependencies [[speclj "3.3.1"]]}}
  :plugins [[speclj "3.3.1"]]
  :test-paths ["spec" "gen-tests"]
  :main tictactoe.core)
