(ns {{name}}.ui.root
  (:require [clojure.string :as s]
            [om.core :as om :include-macros true]
            [om-tools.core :refer-macros [defcomponent]]
            [sablono.core :as html :refer-macros [html]]
            [{{name}}.info :as info]))

(def app-state (atom {}))

(defcomponent render-root [app owner]
  (render [_]
    (html
      [:div
       [:h1 "Welcome to " info/app-name]
       [:p "I think it's time to start some serious hacking..."]])))

(defn start []
  (om/root render-root app-state {:target (js/document.getElementById "app")}))
