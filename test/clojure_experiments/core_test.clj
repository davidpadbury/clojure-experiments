(ns clojure-experiments.core-test
  (:require [clojure.test :refer :all]
            [clojure-experiments.core :refer :all]))

(deftest interpolation
  (testing "value with no subsitution returns same value"
    (is (= "test thing" (interpolate "test thing"))))
  (let [name "David"]
    (testing "value with basic subsitution returns value with substition"
      (is (= "Hi David" (interpolate "Hi {{name}}")))))
  (let [name "David" age 29]
    (testing "value with basic subsitution returns value with substition"
      (is (= "Hi David, you're 29" (interpolate "Hi {{name}}, you're {{age}}"))))))
