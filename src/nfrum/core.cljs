(ns nfrum.core
    (:require [rum.core :as rum]))

(enable-console-print!)

(println "This text is printed from src/nfrum/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!"}))
(def     tv-state (atom {:tiles
                        [ {:title "Fusion Power Imminent"
                           :contents "Horne Technologies has developed a working Plasma Containment Prototype for furthering Fusion"
                           :priority 1}
                          {:title "Let's Put Sun Panels on the Roof"
                           :contents "Put a powerplant on your home and be free of your electric bill"
                           :priority 2}
                          {:title "Tonsky/rum is excellent for cljs"
                           :contents "the best way to be the best"
                           :priority 3}]}))


(rum/defc hello-world []
  [:div
   [:h1 (:text @app-state)]
   [:h3 "Edit this and watch it change!"]
   [:h4 "Nonforum lives again!"]])

(rum/defc top-bar []
  [:div#topbar
   [:ol.topbar
    [:li [:a {:href "/"} "nonforum"]]
    [:li [:a {:href "/top"} "top"]]
    [:li [:a {:href "/latest"} "latest"]]
    [:li [:a {:href "/submit"} "submit"]]
    [:li [:a {:href "/feed"}] "feed"]]])

(rum/defc side-bar []
  [:div#sidebar
   [:ol.sidebar
    [:li [:a {:href "/profile"} "profile"]]
    [:li [:a {:href "/settings"} "settings"]]
    [:li [:a {:href "/feedback"} "feedback"]]
    [:li [:a {:href "/logout"} "logout"]]]])

(rum/defc login-bar []
  [:div#loginbar
   [:ol.loginbar
    [:li [:a {:href "/facebook"} "fb login"]]
    [:li [:a {:href "/gogole"} "gogole loign"]]
    [:li [:a {:href "/nflogin"} "nonforum login"]]]])

(rum/defc tv-cell [td]
  [:li [:div.tile
        [:div.heading (:title td)]
        [:div.contents (:contents td)]
        [:div.priority (:priority td)]]])

(rum/defc television []
  [:div#tv
   [:ol.tv
    (map tv-cell (:tiles @tv-state))]])


(rum/defc all []
  [:div#maincontain
   (top-bar)
   (side-bar)
   (login-bar)
   (television)
   (hello-world)])

(rum/mount (all)
           (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
