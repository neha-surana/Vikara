import { createApp } from "vue";
import "@/assets/css/global.css"; // imports the global CSS before all other CSS files
import "@/cssvikara/style.css";
// import "https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css";
// import "@https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js";
// import "@https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js";
// import "@https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js";
// import "@https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js";
// import "@https://cdnjs.cloudflare.com/ajax/libs/linkurious.js/1.5.1/plugins.min.js";

import "bootstrap";

import App from "./App.vue";
import router from "./router";

createApp(App).use(router).mount("#app");
