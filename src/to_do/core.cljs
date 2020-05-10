(ns to-do.core
  (:require [reagent.dom :as dom]
            [reagent.core :as r]))

(def state (r/atom {:to-dos []
                    :new-task ""}))

(defn event->intpu-value [evt]
  (-> evt
      .-target
      .-value))

(defn add-todo [description]
  (when-not (empty? description)
    (let [new-index (count (:to-dos @state))
          new-to-do {:description description
                     :index new-index
                     :done? false}]
      (swap! state update :to-dos conj new-to-do ))))

(defn add-fake-tasks []
  (doseq [item ["First" "Second" "Third" "Fourth"]]
    (add-todo item))
  (println "Insert fake tasks [DONE]"))

(defn to-do [{:keys [index description done?]}]
  [:div {:key index} description " - " (str done?)])

(defn form []
  [:form {:name "new-todo-form"
          :on-submit (fn [evt]
                       (.preventDefault evt)
                       (add-todo (:new-task @state))
                       (swap! state assoc :new-task "")
                       nil)}

   [:input {:type      "text"
            :value     (:new-task @state)
            :on-change #(swap! state assoc :new-task (event->intpu-value %))}]
   [:input {:type "submit"
            :value "+"}]])

(defn index []
  [:div.main
   [:button {:on-click add-fake-tasks} "Add Fake Tasks"]
   [form]
   [:div (map to-do (:to-dos @state))]])

(defn main []
  (dom/render [index]
              (.querySelector js/document "#app")))

(defn ^:dev/after-load force-render []
  (reset! state {:to-dos []
                 :new-task ""})
(println "Reseting state [DONE]")
  (main)
  (println "Application reloaded [DONE]"))
