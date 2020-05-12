(ns to-do.core
  (:require [reagent.dom :as dom]
            [reagent.core :as r]
            [to-do.form :as form]
            [to-do.list :as list]))

(def state (r/atom {:to-dos []
                    :new-task ""}))

(defn current-date []
  (let [date (js/Date.now)
        formatter (js/Intl.DateTimeFormat "en"
                                       #js {:year "numeric"
                                            :weekday "long"
                                            :day "numeric"
                                            :month "long"})
        [day-of-week month-date year] (clojure.string/split (.format formatter date) #",")]
    (str day-of-week ", " month-date " " year)))

(defn index []
  [:div.main
   [:div.title
    [:h1 (current-date)]]
   [:div.form
    [form/core state]]
   [:div.list-container
    [list/core state]]])

(defn main []
  (dom/render [index]
              (.querySelector js/document "#app")))

(defn ^:dev/after-load force-render []
  #_(reset! state {:to-dos []
                 :new-task ""})


(println "Reseting state [DONE]")
  (main)
  (println "Application reloaded [DONE]"))
