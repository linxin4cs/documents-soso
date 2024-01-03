<template>
  <div class="user_block_container">
    <div
      class="user_info_container"
      @click="state.isShowDownList = !state.isShowDownList"
    >
      <n-icon size="36" color="#66bb6a" :component="UserCircle" />
      <div class="user_id">
        {{ globalStore.userInfo.isAdmin ? "管理员" : "用户" }}
        {{ globalStore.userInfo.name }}
      </div>
    </div>
    <div class="user_block_down_list" v-if="state.isShowDownList">
      <div
        class="manage_upload_button list_item"
        v-if="globalStore.userInfo.isAdmin"
      >
        上传文档管理
      </div>
      <div
        class="upload_button list_item"
        v-else
        @click="uploadButtonClickHandler"
      >
        上传文档
      </div>
      <!--      <div class="logout_button list_item">退出登录</div>-->
    </div>
  </div>
</template>

<script setup>
import { UserCircle } from "@vicons/fa";
import { useGlobalStore } from "@/stores/global";
import { reactive } from "vue";
import { useRouter } from "vue-router";

const globalStore = useGlobalStore();
const router = useRouter();
const state = reactive({
  isShowDownList: false,
});

function uploadButtonClickHandler() {
  router.push("/manage");
}
</script>

<style scoped>
.user_block_container {
  background-color: #fff;
  display: flex;
  flex-direction: column;
  position: relative;
}
.user_info_container {
  display: flex;
  flex-direction: row;
  align-items: center;
  border: 2px solid #adb5bd;
  padding: 5px 10px;
  border-radius: 5px;
  cursor: pointer;
}
.user_id {
  color: #383838;
  font-size: 18px;
  margin-left: 6px;
}
.user_block_down_list {
  position: absolute;
  top: 50px;
}
.list_item {
  padding: 5px 10px;
  color: #343a40;
  cursor: pointer;
}
.list_item:hover {
  background-color: #e9ecef;
}
.user_block_down_list {
  border: 2px solid #adb5bd;
  width: 100%;
  border-radius: 2px 2px 5px 5px;
  background-color: #fff;
  box-sizing: border-box;
}
</style>
