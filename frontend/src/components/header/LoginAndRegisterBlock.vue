<template>
  <div class="login_block_container">
    <div class="login_button button" @click="loginButtonClickHandler">登录</div>
    <div class="line_separator"></div>
    <div class="register_button button" @click="registerButtonClickHandler">
      注册
    </div>
    <n-modal v-model:show="state.isShowLoginModal">
      <div class="login_modal_container modal_container">
        <div class="modal_title">文档SOSO</div>
        <n-input
          type="text"
          placeholder="用户名"
          :maxlength="20"
          v-model:value="state.loginInput.name"
        />
        <div class="space_separator"></div>
        <n-input
          type="password"
          show-password-on="click"
          placeholder="密码"
          :maxlength="8"
          v-model:value="state.loginInput.password"
        />
        <div
          class="login_confirm_button confirm_button"
          @click="loginConfirmButtonClickHandler"
        >
          登录
        </div>
      </div>
    </n-modal>
    <n-modal v-model:show="state.isShowRegisterModal">
      <div class="register_modal_container modal_container">
        <div class="modal_title">文档SOSO</div>
        <n-input
          type="password"
          show-password-on="click"
          placeholder="密码"
          :maxlength="8"
          v-model:value="state.registerInput.password"
        />
        <div
          class="register_confirm_button confirm_button"
          @click="registerConfirmButtonClickHandler"
        >
          注册
        </div>
      </div>
    </n-modal>
    <n-modal
      v-model:show="state.infoModal.isShowInfoModal"
      preset="dialog"
      :title="state.infoModal.title"
      :content="state.infoModal.content"
      positive-text="好的"
    />
  </div>
</template>

<script setup>
import { reactive } from "vue";
import { useGlobalStore } from "@/stores/global";
import axios from "axios";
import { useMessage } from "naive-ui";

const state = reactive({
  isShowLoginModal: false,
  isShowRegisterModal: false,
  registerInput: {
    password: "",
  },
  loginInput: {
    name: "",
    password: "",
  },
  infoModal: {
    title: "",
    content: "",
    isShowInfoModal: false,
  },
});
const globalStore = useGlobalStore();
const message = useMessage();
function loginButtonClickHandler() {
  state.isShowLoginModal = true;
}
function registerButtonClickHandler() {
  state.isShowRegisterModal = true;
}
function registerConfirmButtonClickHandler() {
  axios
    .post("/api/users/register", {
      name: "",
      password: state.registerInput.password,
    })
    .then((res) => {
      console.log(res);
      state.infoModal.title = "注册成功！";
      state.infoModal.content = "请牢记您的用户名：" + res.data;
      state.infoModal.isShowInfoModal = true;
      globalStore.userInfo.name = res.data;
      globalStore.userInfo.isLogin = true;
      success("注册成功！");
    });
}
function loginConfirmButtonClickHandler() {
  const name = state.loginInput.name;

  axios
    .post("/api/users/login", {
      name: state.loginInput.name,
      password: state.loginInput.password,
    })
    .then((res) => {
      if (res.data == 0) {
        globalStore.userInfo.name = name;
        globalStore.userInfo.isLogin = true;
        success("登录成功！");
      } else {
        state.infoModal.title = "抱歉！";
        state.infoModal.content = "用户不存在或密码错误！";
        state.infoModal.isShowInfoModal = true;
      }
    });
}

function success(content) {
  message.success(content);
}
</script>

<style scoped>
.login_block_container {
  display: flex;
  flex-direction: row;
  align-items: center;
  font-size: 20px;
  color: #505050;
  font-weight: bold;
}
.button {
  margin: 10px;
  cursor: pointer;
}
.line_separator {
  width: 2px;
  height: 30px;
  background-color: #999999;
}
.modal_container {
  background-color: #fff;
  display: flex;
  flex-direction: column;
  align-items: center;
  border-radius: 5px;
  border: 1px solid #868e96;
  padding: 10px 20px 10px 20px;
  /*box-shadow: 0 0 5px 0 #495057;*/
  position: relative;
}
.modal_title {
  font-size: 30px;
  color: #66bb6a;
  font-weight: bold;
  margin-bottom: 10px;
}
.confirm_button {
  margin-top: 10px;
  border: 1px #f1f3f5 solid;
  border-radius: 3px;
  background-color: #66bb6a;
  color: #fff;
  font-size: 16px;
  padding: 3px 10px;
  cursor: pointer;
}
.space_separator {
  height: 10px;
  width: 1px;
}
</style>
