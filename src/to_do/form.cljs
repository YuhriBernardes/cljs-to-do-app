(ns to-do.form
  (:require [to-do.utils :as utils]))

(defn add-todo [state]
  (when-not (empty? (:new-task @state))
    (let [new-index (count (:to-dos @state))
          new-to-do {:description (:new-task @state)
                     :index       new-index
                     :done?       false}]
      (swap! state update :to-dos conj new-to-do))))

(defn submit-form [state]
  (fn [evt]
                                (.preventDefault evt)
                                (add-todo state)
                                (swap! state assoc :new-task "")))

(defn core [state]
  [:form#todo-form{:name      "new-todo-form"
                   :on-submit (submit-form state)}

   [:input {:type      "text"
            :value     (:new-task @state)
            :on-change (fn [event]
                         (swap! state assoc :new-task (utils/event->intpu-value event)))}]
   [:button#submit {:type  "submit"}
    "ADD"]])
