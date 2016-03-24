(ns ml.core
  (:require [clojure.core.matrix :as m]
            [clatrix.core :as c]))

(def A (m/matrix [[0 1 2] [3 4 5]]))
(def B (c/matrix [[0 1 2] [3 4 5]]))
(def C (m/matrix :clatrix [[0 1 2] [3 4 5]]))

(c/clatrix? A)
(m/matrix? A)
(c/clatrix? C)

(m/row-count A) 
(m/column-count B)
(count B) 

(c/get B 1 1)
(c/get B 3)
(c/set B 1 1 7) ;mutates

(c/map inc B)
(c/map-indexed #(inc %3) B)

(defn d-mat
  [n e d]
  (nth (iterate (fn [x] (into [] (repeat n x))) e) d))
(d-mat 5 6 2)
(defn square-mat
  [n e]
  (d-mat n e 2))
(square-mat 5 6)
(defn square-mat-spec
  [n e]
  (m/matrix (square-mat n e)))
(square-mat-spec 5 6)
