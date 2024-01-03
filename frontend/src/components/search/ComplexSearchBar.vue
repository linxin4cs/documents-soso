<template>
  <div class="complex_search_bar_container">
    <PureSearchBar
      placeholder="搜索文档"
      :on-focus-handler="onFocusHandler"
      :on-blur-handler="onBlurHandler"
      :input-style="props.inputStyle"
    />
    <!--    <DownList-->
    <!--      v-if="props.listItems.length !== 0 && state.isShowHistory"-->
    <!--      :items="props.listItems"-->
    <!--      :list-style="globalConstants.STYLE.HEADER_SEARCH_LIST_STYLE"-->
    <!--      ><slot></slot-->
    <!--    ></DownList>-->
  </div>
</template>

<script setup>
import PureSearchBar from "@/components/search/PureSearchBar.vue";
import { reactive } from "vue";
import DownList from "@/components/DownList.vue";
import globalConstants from "@/constants/global.js";

const props = defineProps(["inputStyle", "listItems"]);

const state = reactive({
  isShowHistory: false,
});

function onFocusHandler() {
  state.isShowHistory = true;
}
function onBlurHandler() {
  state.isShowHistory = false;
}
</script>

<style scoped>
.complex_search_bar_container {
  position: relative;
}
</style>
