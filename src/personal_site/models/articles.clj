(ns personal-site.models.articles
  (:use monger.query)
  (:require [monger.collection :as mc]
            [clj-time.core :as t]
            [clojure.string :as s]))

(defn permalink [header]
  (s/replace (s/lower-case (s/replace (str header) #"[,=+>%<./\_ ]" (fn [s] "-"))) #"--" (fn [s] "-")))

(defn getall []
  (with-collection "articles"
                   (find {})
                   (sort (sorted-map :created -1))))

(defn getone [permalink]
  (mc/find-one-as-map "articles" {:permalink permalink}))

(defn add [header text]
  (mc/insert "articles" {:header header, :permalink (permalink header), :text text, :created (t/now)}))
