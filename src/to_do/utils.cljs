(ns to-do.utils)


(defn event->intpu-value [evt]
  (-> evt
      .-target
      .-value))

(defmacro with-handler [body]
  `(fn [event]
     ~@body))
