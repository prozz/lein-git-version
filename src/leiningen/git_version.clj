(ns leiningen.git-version
  (:require [leiningen.help]
            [leiningen.jar]
            [leiningen.compile]
            [leiningen.core.main]
            [leiningen.core.project]
            [robert.hooke]
            [leiningen.test])
  (:use
   [clojure.java.shell :only [sh]]))

(defn get-git-version
  []
  (apply str (rest (clojure.string/trim
                    (:out (sh "git" "log" "-1" "--format='%H'"))))))

(defn git-version
  "Main project task."
  ^{:doc "Show git project version"}
  [project & args]
  (println (get-git-version)))
