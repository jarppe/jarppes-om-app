(ns {{name}}.routing
  (:require [ring.util.http-response :refer [ok content-type] :as resp]
            [compojure.core :refer [context]]
            [compojure.route :as route]
            [compojure.api.core :refer [defroutes* middlewares GET* POST*]]
            [compojure.api.middleware :refer [api-middleware]]
            [{{name}}.env :as env]
            [{{name}}.index-page :refer [index-page]]))

(defroutes* routes
  (GET* "/" []
    (-> index-page
        (ok)
        (content-type "text/html; charset=\"UTF-8\"")))
  (middlewares [(api-middleware)]
    (context "/api" []
      (GET* "/info" []
        (ok {:app "{{name}}"
             :mode env/mode}))
      (POST* "/error" {body :body-params addr :remote-addr {:strs [user-agent]} :headers}
        (println "client error:" body addr user-agent)
        (ok {}))))
  (route/resources "/")
  (constantly (resp/not-found "Not found")))

