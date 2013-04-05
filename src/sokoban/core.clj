;; My solution to the Sokoban Ruby Quiz.
(ns sokoban.core
  (:use [clojure.string :only [join]]
        [clojure.set :only [intersection union]]))

(def levels
  [["#####" 
    "#.o@#"
    "#####"]
   ["######"
    "#.o@ #"
    "######"]
   ["#####"
    "#@o.#"
    "#####"]
   ["#####"
    "#.o@#"
    "#   #"
    "#####"]
   ["#####"
    "#.o #"
    "#  @#"
    "#####"]
   ["#####"
    "#.o #"
    "# @ #"
    "#####"]
   ["######"
    "#..  #"
    "#@oo #"
    "#    #"
    "######"]])

(defn x-group-by
  "https://groups.google.com/forum/?fromgroups=#!topic/clojure/pRla3_7vqvc"
  ([f g coll]
     (persistent!
      (reduce
       (fn [ret x]
         (let [k (f x)]
           (assoc! ret k (g (get ret k) x))))
       (transient {}) coll)))
  ([f coll]
     (x-group-by f #(conj (or % []) %2) coll)))

(def moves {:left [-1 0] :right [1 0] :down [0 1] :up [0 -1]})
(def input-keys {\a :left \d :right \w :up \s :down})

(defn array-2d-add-coords [arr]
  "Decorates each cell in the array with its coordinate"
  (map-indexed (fn [y line] (map-indexed (fn [x el] [[x y] el]) line)) arr))

(defn load-level [n]
  (let [level (nth levels n)
        coord-chars (filter
                     #(not= (last %) \ )
                     (apply concat (array-2d-add-coords level)))]
    (x-group-by last #(conj (or % #{}) (first %2)) coord-chars)))

(defn player-position [state]
  (first (get state \@)))

(def add-vecs (comp vec (partial map + )))

(defn next-state [state move]
  (let [dir (move moves)
        new-pos (add-vecs dir (player-position state))]
    (assoc state
      \@ #{new-pos}
      \o (set (map (fn [pos] (add-vecs pos (if (= pos new-pos) dir [0 0])))
                   (get state \o))))))

(defn is-valid? [state move]
  (let [new-state (next-state state move)
        crates (get new-state \o)]
    (and (empty? (intersection (get new-state \#)
                               (union (get new-state \@) crates)))
         (= (count crates) (count (get state \o))))))

(defn possible-moves [state]
  (filter #(is-valid? state %) (keys moves)))

(defn geometry [state]
  (let [coords (apply concat (vals state))]
    [(inc (apply max (map first coords)))
     (inc (apply max (map last coords)))]))

(defn char-at [state pos]
  (let [chars (set (keys (filter (fn [[k v]] (contains? v pos)) state)))]
    (case chars
      #{} \space
      #{\. \o} \*
      #{\. \@} \+
      (first chars))))

(defn to-string [state]
  (let [[max-x max-y] (geometry state)]
    (join "\n"
          (map (fn [y] (join (map (fn [x] (char-at state [x y]))
                                  (range max-x))))
               (range max-y)))))
  
(def print-state (comp println to-string))

(defn game-loop [state]
  (print-state state)
  (if (= (get state \o) (get state \.))
    (println "Well done!")
    (let [ch (first (read-line))
          move (get input-keys ch)]
      (if (= ch \q)
        (println "Bye!")
        (game-loop (if (and move (is-valid? state move))
                     (next-state state move)
                     state))))))
