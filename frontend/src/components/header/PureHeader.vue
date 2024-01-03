<template>
  <div class="pure_header_container">
    <div class="header_text" @click="headerTextClickHandler">文档SOSO</div>
    <slot></slot>
  </div>
</template>

<script setup>
import {useRouter} from "vue-router";
const router = useRouter();
function headerTextClickHandler() {
  router.push("/");
}
</script>

<style scoped>
.pure_header_container {
  border-bottom: solid #e5e5e5 1px;
  box-shadow: 0 1px 5px 0 #ced4da;
  background-color: #fff;
  padding: 21px 40px 21px 21px;
  display: flex;
  flex-direction: row;
  align-items: center;
}
.header_text {
  display: block;
  color: #66bb6a;
  font-size: 45px;
  flex-shrink: 0;
  margin-right: 22px;
  font-weight: bold;
  cursor: pointer;
}
</style>
