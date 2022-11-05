import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import HomeView from "../views/HomeView.vue";
import CategoryView from "../views/CategoryView.vue";
import IndexView from "../views/IndexView.vue";
import SurveyView from "../views/SurveyView.vue";
import LoginView from "../views/LoginView.vue";
import CartView from "../views/CartView.vue";
import CheckoutView from "../views/CheckoutView.vue";
import SignupView from "../views/SignupView.vue";
import AboutUs from "../views/AboutUsView.vue";
import SpeechToText from "../views/SpeechToText.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/survey",
    name: "survey-view",
    component: SurveyView,
  },
  {
    path: "/itemCategory/:name",
    name: "category-view",
    component: CategoryView,
    props: true,
  },
  {
    path: "/cart",
    name: "cart-view",
    component: CartView,
  },
  {
    path: "/checkout",
    name: "checkout-view",
    component: CheckoutView,
  },
  {
    path: "/",
    name: "index-view",
    component: IndexView,
  },
  {
    path: "/login",
    name: "login-view",
    component: LoginView,
  },
  {
    path: "/signup",
    name: "signup-view",
    component: SignupView,
  },
  {
    path: "/aboutus",
    name: "about-us",
    component: AboutUs,
  },
  // {
  //   path: "/speechtotext",
  //   name: "speech-to-text",
  //   component: SpeechToText,
  // },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
