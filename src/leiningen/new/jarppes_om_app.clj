(ns leiningen.new.jarppes-om-app
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "jarppes-om-app"))

(defn jarppes-om-app [app-name]
  (let [data {:name app-name
              :sanitized (name-to-path app-name)}]
    (main/info "What a treat! Shiny new OM app is about to be generated for you...")
    (->files data
             ;; Project:
             ["project.clj" (render "project.clj" data)]
             ["Procfile" (render "Procfile" data)]
             ["system.properties" (render "system.properties" data)]
             [".gitignore" (render "gitignore" data)]
             ["README.md" (render "README.md" data)]
             ;; Server:
             ["src/clj-main/{{sanitized}}/main.clj" (render "clj/main.clj" data)]
             ["src/clj/user.clj" (render "clj/user.clj" data)]
             ["src/clj/{{sanitized}}/env.clj" (render "clj/env.clj" data)]
             ["src/clj/{{sanitized}}/index_page.clj" (render "clj/index_page.clj" data)]
             ["src/clj/{{sanitized}}/server.clj" (render "clj/server.clj" data)]
             ["src/clj/{{sanitized}}/routing.clj" (render "clj/routing.clj" data)]
             ;; Shared:
             ["src/cljx/{{sanitized}}/info.cljx" (render "cljx/info.cljx" data)]
             ;; Front:
             ["src/cljs-main/{{sanitized}}/ui/main.cljs" (render "cljs/main.cljs" data)]
             ["src/cljs/{{sanitized}}/ui/root.cljs" (render "cljs/root.cljs" data)]
             ["src/cljs/{{sanitized}}/ui/error.cljs" (render "cljs/error.cljs" data)])))
