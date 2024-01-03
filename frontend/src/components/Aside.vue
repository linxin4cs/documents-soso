<template>
  <div class="aside_container">
    <div
      class="document_info_container"
      v-if="globalStore.docStatus.isActivated"
    >
      <div class="doc_name">{{ globalStore.docStatus.name }}</div>
      <div class="doc_other_info_container">
        <div class="doc_other_info">
          文档类型&nbsp {{ globalStore.docStatus.type }}
        </div>
        <div class="doc_other_info">
          文档大小&nbsp {{ globalStore.docStatus.size }}
        </div>
        <div class="doc_other_info">
          上传日期&nbsp {{ globalStore.docStatus.uploadDate }}
        </div>
        <div class="doc_other_info">
          上传用户&nbsp {{ globalStore.docStatus.uploadUser }}
        </div>
      </div>
    </div>
    <div
      class="download_button button"
      v-if="globalStore.pageStatus.isPreviewPage"
      @click="downloadButtonClickHandler"
    >
      下载
    </div>
    <n-upload
      action="/api/documents"
      name="documentFile"
      :data="{ user_name: globalStore.userInfo.name }"
      @before-upload="beforeUpload"
      :show-file-list="false"
      @finish="finish"
    >
      <div
        class="upload_button button"
        v-if="globalStore.pageStatus.isManagementPage"
      >
        上传文档
      </div>
    </n-upload>
  </div>
</template>

<script setup>
import { useGlobalStore } from "@/stores/global";
import { useMessage } from "naive-ui";
import { useRouter } from "vue-router";

const globalStore = useGlobalStore();
window.$message = useMessage();
const router = useRouter();

async function beforeUpload(data) {
  console.log(data.file.file?.type);
  if (
    data.file.file?.type !== "application/pdf" &&
    data.file.file?.type !==
      "application/vnd.openxmlformats-officedocument.wordprocessingml.document" &&
    data.file.file?.type !== "application/msword"
  ) {
    window.$message.error("只能上传 DOC | DOCX | PDF 格式的文档，请重新上传！");
    return false;
  }
  return true;
}

function finish() {
  window.$message.success("文档上传成功！");
  router.replace({ path: "/empty" });
}

function downloadButtonClickHandler() {
  window.open(
    "http://localhost:8080/upload/" +
      globalStore.docStatus.id +
      "." +
      globalStore.docStatus.type
  );
}
</script>

<style scoped>
.aside_container {
  position: fixed;
  top: 115px;
  right: 0;
  height: 100%;
  width: 546px;
  box-sizing: border-box;
  border-left: 2px solid #ced4da;
  padding: 20px;
  display: flex;
  align-items: start;
  display: flex;
  flex-direction: column;
}
.document_info_container {
  margin: 45px 0px 0px 10px;
  width: 100%;
}
.doc_name {
  font-size: 18px;
  margin-bottom: 5px;
}
.doc_other_info {
  font-size: 14px;
  color: #495057;
  margin: 5px 0;
}
.button {
  font-size: 18px;
  font-weight: bold;
  color: #fff;
  cursor: pointer;
  padding: 5px 10px;
  background-color: #66bb6a;
  border: 1px solid #adb5bd;
  border-radius: 5px;
}
.download_button {
  margin: 20px 10px;
}
</style>
