import { createApp } from "vue";
import App from "./App.vue";
import { createPinia } from "pinia";
import { createRouter, createWebHashHistory } from "vue-router";
import Index from "@/pages/Index.vue";
import SearchDoc from "@/pages/SearchDoc.vue";
import ManageDocs from "@/pages/manageDocs.vue";
import PreviewDoc from "@/pages/PreviewDoc.vue";
import Empty from "@/pages/Empty.vue";

const routes = [
  {
    path: "/",
    component: Index,
  },
  {
    path: "/search/doc/:keyWord",
    component: SearchDoc,
  },
  {
    path: "/manage",
    component: ManageDocs,
  },
  {
    path: "/preview/:id",
    component: PreviewDoc,
  },
  {
    path:"/empty",
    component:Empty
  }
];

const pinia = createPinia();
const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

createApp(App).use(pinia).use(router).mount("#app");
