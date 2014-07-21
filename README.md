# clojure-experiments

First experiments with Clojure to learn the language.

Started after reading the excelent [Clojure for the Brave and True](http://www.braveclojure.com).

## Experiements

### [Mustache-like String Interpolation Macro](src/clojure_experiments/interpolate.clj)

```clojure
(deftest interpolate
  (testing "value with no subsitution returns same value"
    (is (= "test thing" (interpolate "test thing"))))
  (testing "value with basic subsitution returns value with substition"
    (let [name "David"]
      (is (= "Hi David" (interpolate "Hi {{name}}")))))
  (testing "value with basic subsitution returns value with substition"
    (let [name "David" age 29]
      (is (= "Hi David, you're 29" (interpolate "Hi {{name}}, you're {{age}}"))))))
```

## License

Copyright © 2014 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
