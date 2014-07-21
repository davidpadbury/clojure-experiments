(ns clojure-experiments.interpolate-test
  (:require [clojure.test :refer :all]
            [clojure-experiments.interpolate :refer :all]))

(deftest interpolatation
  (testing "value with no subsitution returns same value"
    (is (= "test thing" (interpolate "test thing"))))
  (testing "value with basic subsitution returns value with substition"
    (let [name "David"]
      (is (= "Hi David" (interpolate "Hi {{name}}")))))
  (testing "value with basic subsitution returns value with substition"
    (let [name "David" age 29]
      (is (= "Hi David, you're 29" (interpolate "Hi {{name}}, you're {{age}}"))))))
