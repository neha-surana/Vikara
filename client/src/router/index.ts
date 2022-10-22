import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import HomeView from "../views/HomeView.vue";
import CategoryView from "../views/CategoryView.vue";
import IndexView from "../views/IndexView.vue";
import SurveyView from "../views/SurveyView.vue";
import LoginView from "../views/LoginView.vue";
import SignupView from "../views/SignupView.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/survey/",
    name: "survey-view",
    component: SurveyView,
  },
  {
    path: "/category/:name",
    name: "category-view",
    component: CategoryView,
    props: true,
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
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
