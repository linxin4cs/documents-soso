<script setup>
import ComplexHeader from "@/components/header/ComplexHeader.vue";
import Aside from "@/components/Aside.vue";
</script>

<template>
  <n-message-provider>
    <ComplexHeader />
    <Aside />
    <router-view></router-view>
  </n-message-provider>
</template>

<style scoped></style>
