(ns to-do.core
  (:require [reagent.dom :as dom]))

(defn main []
  (dom/render [:div "hello"]
              (.querySelector js/document "#app")))

(defn ^:dev/after-load force-render []
  (main))
