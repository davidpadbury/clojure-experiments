(ns clojure-experiments.core)

(defmacro interpolate
  [text]
  (do
    (def results (let [matcher (re-matcher #"\{\{([^}]+)\}\}" text)]
      (loop [results [] left 0 matched (.find matcher)]
        (if-not matched
          (conj results (.substring text left))
          (recur
            (conj results (.substring text left (.start matcher)) (symbol (.group matcher 1)))
            (.end matcher)
            (.find matcher))))))
    `(apply str ~results)))
