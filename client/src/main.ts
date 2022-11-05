import { createApp } from "vue";
import "@/assets/css/global.css"; // imports the global CSS before all other CSS files
import "../src/assets/bootstrap/dist/css/bootstrap.css";
import "@/assets/css/style.css";
import "@/assets/css/vikara.css";
import App from "./App.vue";
import router from "./router";
import { createPinia } from "pinia";

const app = createApp(App);
const pinia = createPinia();
app.use(router);
app.use(pinia);
app.mount("#app");
