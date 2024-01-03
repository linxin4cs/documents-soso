<template>
  <div class="manage_doc_container">
<!--    <div-->
<!--      class="no_docs"-->
<!--      v-if="!globalStore.userInfo.isAdmin && state.orders.length === 0"-->
<!--    >-->
<!--      抱歉，您暂无上传的文档！-->
<!--    </div>-->
    <n-data-table
      remote
      ref="table"
      :columns="columns"
      :data="state.data"
      :row-key="rowKey"
      :row-props="rowProps"
    />
  </div>
</template>

<script setup>
import { useGlobalStore } from "@/stores/global";
import { onMounted, onUnmounted, reactive } from "vue";
import axios from "axios";
import {useRouter} from "vue-router";

const globalStore = useGlobalStore();
const router = useRouter();

const columns = [
  {
    title: "ID",
    key: "id"
  },
  {
    title: "名称",
    key: "name",
  },
  {
    title: "类型",
    key: "type",
  },
  {
    title: "上传日期",
    key: "uploadDate",
  },
];

const rowProps = (row) => {
  return {
    style: 'cursor: pointer;',
    onClick: () => {
      globalStore.docStatus.id = row.id;
      globalStore.docStatus.name = row.name;
      globalStore.docStatus.type  = row.type;
      globalStore.docStatus.uploadDate = row.uploadDate;
      router.push("/preview/" + row.id + "." + row.type);
    }
  }
}

const state = reactive({
  data: [],
});

function rowKey(rowData) {
  return rowData.name;
}

onMounted(() => {
  globalStore.pageStatus.isManagementPage = true;
  axios
    .get("/api/documents/upload_user/" + globalStore.userInfo.name)
    .then((res) => {
      state.data = res.data.map((item) => ({
        name: item.name,
        type: item.type,
        uploadDate: item.upload_date,
        id: item.id,
      }))
    });
});

onUnmounted(() => {
  globalStore.pageStatus.isManagementPage = false;
});
</script>

<style scoped>
.manage_doc_container {
  position: fixed;
  top: 115px;
  left: 0px;
  width: 1502px;
  height: 100%;
  padding: 20px;
  box-sizing: border-box;
}

.no_docs {
  font-size: 36px;
  font-weight: bold;
  color: #495057;
  width: 100%;
  height: 60%;
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>
