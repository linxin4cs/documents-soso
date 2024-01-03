import { defineStore } from "pinia";
import { reactive } from "vue";
import globalConstants from "@/constants/global";

export const useGlobalStore = defineStore("global", () => {
  const userInfo = reactive({
    isLogin: false,
    isAdmin: false,
    name: "",
  });

  const pageStatus = reactive({
    isManagementPage: false,
    isPreviewPage: false,
  });

  const docStatus = reactive({
    isActivated: false,
    id:"",
    name: "",
    type: "",
    size: "",
    uploadDate: "",
    uploadUser: "",
  });

  return { userInfo, docStatus, pageStatus };
});
