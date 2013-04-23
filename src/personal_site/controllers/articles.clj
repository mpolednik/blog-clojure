(ns personal-site.controllers.articles
  (:use monger.json
        monger.joda-time
        ring.util.response)
  (:require [monger.collection :as mc]
            [clj-time.core :as t]))

(defn add [header text]
  (mc/insert "articles" {:header header, :text text, :created (t/now)})
  (redirect "/"))
