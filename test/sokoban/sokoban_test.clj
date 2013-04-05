(ns sokoban.core-test
  (:use clojure.test
        [clojure.string :only [join]]
        sokoban.core))

(deftest possible-moves-test
  (doseq [[idx expected] (map-indexed vector [1 2 1 2 2 2 2])]
    (is (= expected (count (possible-moves (load-level idx)))))))
  
(deftest player-position-test
  (doseq [[idx pos] (map-indexed vector [[3 1] [3 1] [1 1]])]
    (is (= pos (first (get (load-level idx) \@))))))
    
(deftest is-valid-move-test
  (let [level0 (load-level 0)]
    (is (is-valid? level0 :left))
    (is (not (is-valid? level0 :right)))
    (is (not (is-valid? (load-level 6) :right)))))

(deftest load-level-test
  (is (= (join "\n" ["#####"
                     "#.o@#"
                     "#####"])
         (to-string (load-level 0))))
  (is (= (join "\n" ["######"
                     "#.o@ #"
                     "######"])
         (to-string (load-level 1)))))
  
(deftest next-state-test
  (is (= (join "\n" ["######"
                     "#.o @#"
                     "######"])
         (to-string (next-state (load-level 1) :right))))
  (is (= (join "\n" ["#####"
                     "#*@ #"
                     "#####"])
         (to-string (next-state (load-level 0) :left)))))
      
(deftest print-state-test
  (is (= "#####\n#*@ #\n#####"
         (to-string (next-state (load-level 0) :left))))
  (is (= (join "\n" ["######"
                     "#+.  #"
                     "# oo #"
                     "#    #"
                     "######"])
         (to-string (next-state (load-level 6) :up)))))
               



       
        


