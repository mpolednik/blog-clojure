(ns personal-site.models.articles
  (:use monger.query)
  (:require [monger.collection :as mc]))

(defn getall []
  (with-collection "articles"
                   (find {})
                   (sort (sorted-map :created -1))))
