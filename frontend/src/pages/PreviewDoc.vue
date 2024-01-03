<template>
  <div class="preview_doc_container">
    <iframe
      :src="
        globalStore.docStatus.type === globalConstants.DOC_TYPE.PDF
          ? state.previewUrl
          : 'http://127.0.0.1:8012/onlinePreview?url=' +
            encodeURIComponent(
              Base64.encode(
                'http:localhost:8080/upload/' +
                  globalStore.docStatus.id +
                  '.' +
                  globalStore.docStatus.type
              )
            )
      "
    />
  </div>
</template>

<script setup>
import { onMounted, onUnmounted, reactive } from "vue";
import { useGlobalStore } from "@/stores/global";
import globalConstants from "@/constants/global";

import { useRoute, useRouter } from "vue-router";
import axios from "axios";
import { Base64 } from "js-base64";

const globalStore = useGlobalStore();
const route = useRoute();
const state = reactive({
  previewUrl: "api/upload/" + route.params.id,
});

onMounted(() => {
  globalStore.docStatus.isActivated = true;
  globalStore.pageStatus.isPreviewPage = true;

  axios.post(
    "api/documents/" + route.params.id.split(".")[0] + "/download_times"
  );
});

onUnmounted(() => {
  globalStore.docStatus.isActivated = false;
  globalStore.pageStatus.isPreviewPage = false;
});
</script>

<style scoped>
.preview_doc_container {
  position: fixed;
  top: 115px;
  left: 0px;
  width: 1502px;
  height: 100%;
  box-sizing: border-box;
}
iframe {
  width: 100%;
  height: 100%;
}
</style>
