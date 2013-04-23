(ns personal-site.core
  (:use compojure.core
        ring.adapter.jetty)
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [compojure.response :as response]
            [personal-site.views.articles :as view-articles]
            [personal-site.controllers.articles :as controller-articles]
            [monger.core :as mc]))

(defroutes webservice
           (GET "/" [] (view-articles/articles-list))
           (GET "/admin/articles" [] (view-articles/article-form))
           (POST "/admin/articles" [header text] (controller-articles/add header text))
           (route/resources "/")
           (route/not-found "Page not found!"))

(defn main [& args]
  (mc/connect-via-uri! (get (System/getenv) "MONGOHQ_URL" "mongodb://localhost/personal-site"))
  (run-jetty (handler/site webservice) {:port (Integer/parseInt (get (System/getenv) "PORT" "8080"))}))
