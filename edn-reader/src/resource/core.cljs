(ns resource.core
  (:require [cljs.reader :as reader]))

(def a-atom (atom nil))

(defn get-absolute-url
  [url]
  (if (nil? @a-atom)
    (reset! a-atom (.createElement js/document "a")))
  (aset @a-atom "href" url)
  (aget @a-atom "href")
  )

(defn get-data
  [url f]
  (let [url (get-absolute-url url)]
    (js/goog.net.XhrIo.send url
                (fn [e]
                  (let [xhr (aget e "target")]
                    (f (.getResponseText xhr)))))
    ))

(defn get-text
  [url text-atom]
  (get-data url
            (fn [txt]
             (reset! text-atom txt))))

(defn get-edn
  [url text-atom]
  (get-data url
            (fn [txt]
             (reset! text-atom (reader/read-string txt)))))
