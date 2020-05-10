(ns to-do.core
  (:require [reagent.dom :as dom]))

(defn index []
  [:div.main
   [:div "input place"]
   [:div "Task place"]])

(defn main []
  (dom/render [index]
              (.querySelector js/document "#app")))

(defn ^:dev/after-load force-render []
  (main))
