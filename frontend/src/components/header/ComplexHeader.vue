<template>
  <div class="complex_header_container">
    <PureHeader>
      <div class="pure_header_slot_container">
        <ComplexSearchBar
          placeholder="搜索文档"
          :input-style="globalConstants.STYLE.HEADER_SEARCH_INPUT_STYLE"
          :list-items="state.listItems"
        >
          <!--          <div-->
          <!--            class="list_suffix_component"-->
          <!--            @mousedown="listSuffixComponentClickHandler"-->
          <!--          >-->
          <!--            清除历史记录-->
          <!--          </div>-->
        </ComplexSearchBar>
        <LoginAndRegisterBlock v-if="!globalStore.userInfo.isLogin"/>
        <UserBlock v-else></UserBlock>
      </div>
    </PureHeader>
    <n-modal
      v-model:show="state.isShowClearHistoryDialog"
      preset="dialog"
      title="确认清除历史记录？"
      positive-text="确认"
      @positive-click="positiveTextClickHandler"
    />
  </div>
</template>

<script setup>
import PureHeader from "@/components/header/PureHeader.vue";
import ComplexSearchBar from "@/components/search/ComplexSearchBar.vue";
import globalConstants from "@/constants/global.js";
import { reactive } from "vue";
import LoginAndRegisterBlock from "@/components/header/LoginAndRegisterBlock.vue";
import UserBlock from "@/components/header/UserBlock.vue";
import {useGlobalStore} from "@/stores/global";

const state = reactive({
  isShowClearHistoryDialog: false,
  listItems: [
    {
      id: "123",
      value: "20大报告",
      url: "www.baidu.com",
    },
    {
      id: "123",
      value: "20大报告",
      url: "www.baidu.com",
    },
    {
      id: "123",
      value: "20大报告",
      url: "www.baidu.com",
    },
  ],
});
const globalStore = useGlobalStore();

function listSuffixComponentClickHandler() {
  state.isShowClearHistoryDialog = true;
}

function positiveTextClickHandler() {}
</script>

<style scoped>
.complex_header_container {
  position: fixed;
  width: 100%;
}
.list_suffix_component {
  display: flex;
  color: #a19f9d;
  padding: 3px 15px;
  font-weight: bold;
  cursor: pointer;
}
.pure_header_slot_container {
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100%;
}
</style>
