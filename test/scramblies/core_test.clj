(ns scramblies.core-test
  (:require [clojure.test :refer :all]
            [scramblies.core :refer :all]))

(defn test
  [scramblies word result]
  (testing (str  "scramble?  " scramblies "  -  " word)  (is (= (scramble? scramblies word) result))))

(deftest a-test
  (test "rekqodlw" "world" true)
  (test "cedewaraaossoqqyt" "codewars" true)
  (test "katas" "steak" false)
  (test "rekqodlw" "wolo" false)
  (test "rekqodolw" "wolo" true))

