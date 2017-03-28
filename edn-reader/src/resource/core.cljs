(ns resource.core)

(def a-atom (atom nil))

(defn getAbsoluteUrl
  [url]
  (if (nil? @a-atom)
    (reset! a-atom (.createElement js/document "a")))
  (aset @a-atom "href" url)
  (aget @a-atom "href")
  )

(defn getData
  [url f]
  (let [url (getAbsoluteUrl url)]
    (js/goog.net.XhrIo.send url
                (fn [e]
                  (let [xhr (aget e "target")]
                    (f (.getResponseText xhr)))))
    ))

(defn getText
  [url text-atom]
  (getData url
           (fn [txt]
             (reset! text-atom txt))))
