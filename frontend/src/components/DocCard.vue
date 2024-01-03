<template>
  <div
    class="doc_card_container"
    @mouseover="docCardMouseOverHandler"
    @mouseout="docCardMouseOutHandler"
    @click="docCardClickHandler"
  >
    <img
      class="doc_card_icon"
      :src="
        props.docItem.type === globalConstants.DOC_TYPE.DOC ||
        props.docItem.type === globalConstants.DOC_TYPE.DOCX
          ? 'src/assets/icons/icon_doc.png'
          : 'src/assets/icons/icon_pdf.png'
      "
    />
    <div class="doc_name">{{ props.docItem.name }}</div>
  </div>
</template>

<script setup>
import { useGlobalStore } from "@/stores/global";
import globalConstants from "@/constants/global.js";
import { useRouter } from "vue-router";

const globalStore = useGlobalStore();
const props = defineProps(["docItem"]);
const router = useRouter();

function docCardMouseOverHandler() {
  globalStore.docStatus.isActivated = true;
  globalStore.docStatus.id = props.docItem.id;
  globalStore.docStatus.name = props.docItem.name;
  globalStore.docStatus.type = props.docItem.type;
  globalStore.docStatus.size = props.docItem.size;
  globalStore.docStatus.uploadDate = props.docItem.upload_date;
  globalStore.docStatus.uploadUser = props.docItem.upload_user;
  console.log("docCardMouseOverHandler");
}
function docCardMouseOutHandler() {
  globalStore.docStatus.isActivated = false;
}

function docCardClickHandler(event) {
  // globalStore.docStatus.isActivated = false;
  console.log(event);
  router.push("/preview/" + globalStore.docStatus.id + "." + globalStore.docStatus.type);
}
</script>
<style scoped>
.doc_card_container {
  display: flex;
  flex-direction: column;
  align-items: center;
  align-content: center;
  text-align: center;
  font-size: 18px;
  cursor: pointer;
  margin: 0 40px 40px 0px;
  width: 140px;
  height: auto;
}
.doc_card_container:hover {
  background-color: #e9ecef;
}
.doc_card_icon {
  width: 120px;
  height: 120px;
}
</style>
