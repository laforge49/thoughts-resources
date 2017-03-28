(ns resource.core)

(def a-atom (atom nil))

(defn getAbsoluteUrl
  [url]
  (if (nil? @a-atom)
    (reset! a-atom (.createElement js/document "a")))
  (aset @a-atom "href" url)
  (aget @a-atom "href")
  )
