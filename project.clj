(defproject scramblies "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [ring "1.9.3"]
                 [compojure "1.6.2"]]
  :main ^:skip-aot scramblies.core
  :target-path "target/%s"
  :profiles {:uberjar {:dev
                       {:main scramblies.core/-dev-main}
                       :aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
