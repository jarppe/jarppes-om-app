(ns user)

(defn init []
  (require '[{{name}}.server :as server]
           '[{{name}}.env :as env]))

(defn run []
  (println "Loading {{name}}...")
  (require '{{name}}.server)
  (println "Starting {{name}}...")
  ((resolve '{{name}}.server/start-server) {"http" "8080", "nrepl" "6000"}))

"Server ready"
