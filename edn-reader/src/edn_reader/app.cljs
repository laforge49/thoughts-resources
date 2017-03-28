(ns edn-reader.app
  (:require [reagent.core :as reagent :refer [atom]]
            [resource.core :as resource]))

(def edn-atom (atom nil))

(defn something
  []
  (resource/get-edn "config.edn" edn-atom)
  "")

(defn some-component []
  [:div
   [:h3 "I am a component!"]
   [:p.someclass
    "I have " [:strong "bold"]
    [:span {:style {:color "red"}} " and red"]
    " text."]])

(defn calling-component []
  (fn []
  [:div (:string @edn-atom)
   (something)
   [some-component]]))

(defn init []
  (reagent/render-component [calling-component]
                            (.getElementById js/document "container")))
