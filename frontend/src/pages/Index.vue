<template>
  <div class="index_container">
    <div class="title">
      <div class="title_text">热门</div>
      <n-icon size="30" color="#e33c64" :component="FireAlt" />
    </div>
    <div class="cards_container">
      <DocCard v-for="doc in state.hotDocs" :doc-item="doc" />
    </div>
  </div>
</template>

<script setup>
import DocCard from "@/components/DocCard.vue";
import globalConstants from "@/constants/global";
import { FireAlt } from "@vicons/fa";
import { onMounted, reactive } from "vue";
import axios from "axios";

const state = reactive({ hotDocs: [] });

onMounted(() => {
  axios.get("/api/documents/hot").then((res) => {
    state.hotDocs = res.data;
  });
});
</script>

<style scoped>
.index_container {
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
</style>
