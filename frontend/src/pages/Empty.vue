<template></template>

<script setup>
import { useRouter } from "vue-router";
import { onMounted } from "vue";

const router = useRouter();

onMounted(() => {
  router.replace({ path: "/manage" });
});
</script>

<style scoped></style>
