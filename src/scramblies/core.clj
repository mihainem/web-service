(ns scramblies.core
  (:require [clojure.string :as str]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]])
  (:gen-class))

(defn scramble?
  [scramblies word]
  (if (and (> (count word) 0)
           (str/includes? scramblies (str (first word))))
    (recur (str/replace-first scramblies (first word) "")
           (str/replace-first word (str (first word)) ""))
    (= (count word) 0)))


(defn check-scramble
  [request]
  (let [a (str (get-in request [:route-params :a]))
        b (str (get-in request [:route-params :b]))]
    
    {:status 200
     :body (str (scramble? a b))
     :headers{}}))

(defn welcome [request]
  {:status 200
   :body "<h1>Hello hfgghfgf</h1>"
   :headers {}})

(defroutes app
  (GET "/" [] welcome)
  (GET "/scramble/:a/:b" [] check-scramble)
  (not-found "<h1> The page you were looking for does not exist here"))

(defn -main
  [port-number]
  (jetty/run-jetty
   app
   {:port (Integer. port-number)}))

(defn -dev-main
  [port-number]
  (jetty/run-jetty
   (wrap-reload #'app)
   {:port (Integer. port-number)}))