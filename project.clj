(defproject spotify-client "0.1.0-SNAPSHOT"
  :description "Print the tracks from a Cyndi Lauper album"
  :url "https://github.com/hughrawlinson/cyndi"
  :license {:name "MIT"
            :url "https://github.com/hughrawlinson/cyndi/blob/master/LICENSE.md"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [cheshire "5.6.1"]
                 [clj-spotify "0.1.2"]]
  :main ^:skip-aot spotify-client.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
