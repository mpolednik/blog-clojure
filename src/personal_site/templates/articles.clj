(ns personal-site.templates.articles
  (:use hiccup.core
        hiccup.util
        monger.joda-time
        monger.json)
  (:require [clj-time.format :as tf]
            [clj-time.core :as tc]
            [personal-site.models.articles :as model]))

(defn article [{:keys [header text]}]
  (html
    [:article.article-single
     [:h1.title header]
     text]
    [:nav.article-nav
     [:ul
      [:li [:a {:href "#"} "previous"]]
      [:li [:a {:href "#"} "next"]]]]))

(defn article-item [{:keys [header text permalink created]}]
  (html
    [:article.article
     [:h1.title 
      [:a {:href (url "/articles/" permalink)} header] "&nbsp;"
      [:small (tf/unparse (tf/formatter-local "EEE MMM dd HH:mm:ss yyyy") created)]]
     [:p text]]))

(defn articles-list [articles]
  (html
    (map article-item articles)))

(defn article-form []
  (html
    [:form.horizontal {:action "" :method "post"}
     [:div.control-group
      [:label.control-label {:for "inputHeader"}]
      [:div.controls
       [:input#inputHeader {:type "text" :placeholder "Header" :name "header"}]]]
      [:label.control-label {:for "inputText"}]
      [:div.controls
       [:textarea#inputText {:name "text"}]]
      [:div.controls
       [:button.btn {:type "submit"} "Publish"]]]))
