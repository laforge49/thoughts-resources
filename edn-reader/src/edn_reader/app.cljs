(ns edn-reader.app
  (:require [reagent.core :as reagent :refer [atom]]
            [resource.core :as resource]))

(def text-atom (atom "abc"))

(defn something
  []
  (resource/getText "config.edn" text-atom))

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
  [:div @text-atom
   [some-component]]))

(defn init []
  (reagent/render-component [calling-component]
                            (.getElementById js/document "container")))
