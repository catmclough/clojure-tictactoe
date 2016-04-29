# Clojure Tic-Tac-Toe

This is a command line tic-tac-toe game written in Clojure. To download the game, clone the repository and run the game through <a href="http://leiningen.org/">Leiningen</a> with the command 'lein run'.

###Testing
Unit tests are written in <a href="http://speclj.com/">Speclj</a> (3.3.1). Generative tests use <a href="https://github.com/clojure/test.check">test.check</a> (0.9.0).

Generative tests follow every possible game outcome to make sure the AI can never lose. These tests are quite slow, so to run only the unit tests, use the following:
```
lein spec --tag=~gen
```

To run all the tests (including generative tests), run:
```
lein spec
```

