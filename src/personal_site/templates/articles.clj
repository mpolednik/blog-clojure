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
      [:li [:a {:href "#"} "&laquo; previous"]]
      [:li [:a {:href "#"} "next &raquo;"]]]]))

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

(defn article-row [{:keys [header permalink created]}]
  (html
     [:tr
      [:td {:href (url "/articles/" permalink)} header]
      [:td (tf/unparse (tf/formatter-local "EEE MMM dd HH:mm:ss yyyy") created)]
      [:td (tf/unparse (tf/formatter-local "EEE MMM dd HH:mm:ss yyyy") created)]
      [:td
       [:i.icon-trash]
       [:i.icon-edit]]]))

(defn articles-table [articles]
  (html
    [:table.table.table-hover
     [:thead
      [:tr
       [:th "header"]
       [:th "permalink"]
       [:th "created"]
       [:th "actions"]]
     [:tbody
      (map article-row articles)]]]))

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
       [:button.btn {:type "submit"} "Publish"]]]
    (articles-table (model/getall))))
