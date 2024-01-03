<template>
  <div class="search_doc_container">
    <div class="title">
      <div class="title_text">搜索结果</div>
    </div>
    <div class="cards_container" v-if="state.docsResult.length !== 0">
      <DocCard v-for="doc in state.docsResult" :doc-item="doc" />
    </div>
    <div class="no_result" v-if="state.isShowNoResult">抱歉，暂无结果！</div>
  </div>
</template>

<script setup>
import DocCard from "@/components/DocCard.vue";
import { onMounted, reactive } from "vue";
import axios from "axios";
import { useRoute } from "vue-router";

const state = reactive({ docsResult: [], isShowNoResult: false });
const route = useRoute();

onMounted(() => {
  axios.get("/api/documents/search/" + route.params.keyWord).then((res) => {
    state.docsResult = res.data;
    setTimeout(() => {
      if (res.data.length === 0) {
        state.isShowNoResult = true;
      }
    }, 1000);
  });
});
</script>

<style scoped>
.search_doc_container {
  position: fixed;
  top: 115px;
  left: 0px;
  width: 1502px;
  height: 100%;
  padding: 20px 100px 0 24px;
  box-sizing: border-box;
}
.title {
  font-size: 20px;
  color: #adb5bd;
  display: flex;
  flex-direction: row;
  align-items: center;
}
.title_text {
  margin-right: 5px;
}
.cards_container {
  display: flex;
  flex-direction: row;
  align-items: start;
  align-content: start;
  justify-content: start;
  flex-wrap: wrap;
  padding-top: 20px;
}
.no_result {
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
