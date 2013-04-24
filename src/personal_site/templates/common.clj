(ns personal-site.templates.common
  (:use [hiccup.page]
        [hiccup.core]))

(defn navbar []
  (html
    [:div.navbar.navbar-inverse.navbar-fixed-top
     [:div.navbar-inner
      [:div.container
       [:button.btn.btn-navbar {:type "button" :data-toggle "collapse" :data-target ".nav-collapse"}
        [:span.icon-bar]
        [:span.icon-bar]
        [:span.icon-bar]]
       [:a.brand {:href "#"} "mpolednik.com"]
       [:div.nav-collapse.collapse
        [:ul.nav
         [:li
          [:a {:href "#"} "Home"]]
         [:li
          [:a {:href "#"} "About"]]]]]]]))

(defn layout [& content]
  (html5
    [:head
     [:title "title"]
     [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
     (include-css "/css/bootstrap.css/"
                  "/css/bootstrap-responsive.css")]
    [:body
     (navbar)
     [:div.container
      content]
     (include-js "http://code.jquery.com/jquery.js"
                 "/js/bootstrap.min.js")]))
