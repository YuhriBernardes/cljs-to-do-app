(ns to-do.list)

(defn to-do [state {:keys [index description done?]}]
  [:li.item {:key index}
   [:div.content
    [:input {:type      "checkbox"
             :id (str "check-" index)
             :checked   done?
             :on-change (fn [_]
                          (swap! state update :to-dos update index update :done? not))}]
    [:label {:for (str "check-" index)}
     [:div.check]
     [:div.text description]]]])

(defn core [state]
  [:ul#task-list
   (map (partial to-do state) (:to-dos @state))])
