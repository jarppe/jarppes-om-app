(ns {{name}}.index-page
  (:require [hiccup.core :refer [html]]
            [hiccup.page :refer [html5 include-css include-js]]
            [garden.core :refer [css]]
            [{{name}}.env :as env]))

(def index-page
  (html
    (html5
      [:head
       [:title "{{name}}"]
       [:meta {:charset "utf-8"}]
       [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge"}]
       [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
       [:style {:type "text/css"}
        (css {:pretty-print? env/dev?}
             [:html :body {:color             "#DDD"
                           :background-color  "#444"
                           :font-family "sans-serif"}]
             [:h1 {:font-size "48px"}])]]
      [:body
       [:div#app
        [:h1 "Loading, please wait..."]]]
      (if env/prod?
        (include-js "{{name}}.js")
        (concat (include-js "out/goog/base.js" "react.js" "{{name}}.js")
                [[:script {:type "text/javascript"} "goog.require('{{name}}.ui.main');"]])))))
