(ns clojure-experiments.interpolate)

(defmacro interpolate
  [text]
  "Evaluate mustache like strings with values referenced in {{these}}"
  (do
    ; split mustache like string into list of strings and symbols
    (def results (let [matcher (re-matcher #"\{\{([^}]+)\}\}" text)]
      (loop [results [] left 0 matched (.find matcher)]
        (if-not matched
          ; finish by appending everything right to last match
          (conj results (.substring text left))
          (recur
            ; append portion left to match and a symbol with the match name
            (conj results (.substring text left (.start matcher)) (symbol (.group matcher 1)))
            (.end matcher)
            (.find matcher))))))
    ; call string with our built array in the context of the caller to build result string
    `(apply str ~results)))
