(ns {{name}}.main
  (:gen-class))

(defn -main [& args]
  (println "Loading {{name}}...")
  (require '{{name}}.server)
  (println "Starting {{name}}...")
  ((resolve '{{name}}.server/start-server) (apply hash-map args)))
