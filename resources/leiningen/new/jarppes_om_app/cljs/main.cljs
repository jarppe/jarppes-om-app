(ns {{name}}.ui.main
  (:require [{{name}}.ui.root :as root]
            [{{name}}.ui.error :refer [error]]))

(-> js/window .-onerror (set! (fn [message url line]
                                (error {:type     "on-error"
                                        :message  message
                                        :url      url
                                        :line     line})
                                false)))

(-> js/window .-onload (set! root/start))
