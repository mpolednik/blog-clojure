(defproject personal-site "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [hiccup "1.0.3"]
                 [compojure "1.1.5"]
                 [ring "1.1.8"]
                 [com.novemberain/monger "1.6.0-beta2"]
                 [clj-time "0.5.0"]
                 [cheshire "5.1.1"]]
  :main personal-site.core/main)
