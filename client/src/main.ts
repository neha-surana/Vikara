import { createApp } from "vue";
import "@/assets/css/global.css"; // imports the global CSS before all other CSS files
import App from "./App.vue";
import router from "./router";

createApp(App).use(router).mount("#app");
