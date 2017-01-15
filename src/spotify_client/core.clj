(ns spotify-client.core
  (:gen-class)
  (:require
   [clj-spotify.core :as sptfy]
   [clojure.data.json :as json]
   [clj-http.client :as client]
   [clojure.data.codec.base64 :as b64]
   ))

(def enc-auth-string
  (str "Basic "
       (->
        (str (System/getenv "SPOTIFY_CLIENT_ID") ":" (System/getenv "SPOTIFY_SECRET_TOKEN"))
        (.getBytes)
        (b64/encode)
        (String. "UTF-8"))))

(defonce spotify-oauth-token (->
                              "https://accounts.spotify.com/api/token"
                              (client/post {:form-params {:grant_type "client_credentials"} :headers {:Authorization enc-auth-string}})
                              :body
                              (json/read-str :key-fn keyword)
                              :access_token))

(defn -main
  [& args]
  (dorun
   (let
       [album (sptfy/get-an-album
               {:id "0sNOF9WDwhWunNAHPD3Baj"}
               spotify-oauth-token)]
     (map
      println
      (map
       (fn [track]
         (str (:name (first (:artists album)))
              " - "
              (:name track)))
       (:items (:tracks album)))))))
