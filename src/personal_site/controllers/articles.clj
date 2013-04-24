(ns personal-site.controllers.articles
  (:use monger.json
        monger.joda-time
        ring.util.response)
  (:require [monger.collection :as mc]
            [personal-site.models.articles :as model]))

(defn add [header text]
  (model/add header text)
  (redirect "/"))
