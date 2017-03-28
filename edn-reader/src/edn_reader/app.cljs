(ns edn-reader.app
  (:require [reagent.core :as reagent :refer [atom]]
            [resource.core :as resource]))

(defn something
  []
  (.log js/console
        (resource/getAbsoluteUrl "config.edn")))

(defn some-component []
  [:div
   [:h3 "I am a component!"]
   [:p.someclass
    "I have " [:strong "bold"]
    [:span {:style {:color "red"}} " and red"]
    " text."]
   [:input {:type "button" :value "Click me!"
            :on-click something}]])

(defn calling-component []
  (fn []
  [:div "Parent component"
   [some-component]]))

(defn init []
  (reagent/render-component [calling-component]
                            (.getElementById js/document "container")))
