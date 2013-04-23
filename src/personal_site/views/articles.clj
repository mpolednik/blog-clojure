(ns personal-site.views.articles
  (:require [personal-site.templates.articles :as template]
            [personal-site.templates.common :as common]
            [personal-site.models.articles :as model]))

(defn articles-list []
  (common/layout (template/articles-list (model/getall))))

(defn article-form []
  (common/layout (template/article-form)))
