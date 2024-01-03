<template>
  <div class="pure_search_container">
    <n-input
      :style="props.inputStyle"
      :placeholder="props.placeholder"
      maxlength="100"
      size="large"
      rows="1"
      :on-focus="props.onFocusHandler"
      :on-blur="props.onBlurHandler"
      v-model:value="searchStore.inputValue"
      @keyup.enter="enterEventHandler"
    >
    </n-input>
    <n-button
      text
      style="font-size: 50px"
      @click="searchButtonClickHandler"
    >
      <template #icon>
        <n-icon size="50" :component="IosSearch" color="#999999" />
      </template>
    </n-button>
  </div>
</template>

<script setup>
import { IosSearch } from "@vicons/ionicons4";
import { defineComponent } from "vue";
import { useSearchStore } from "@/stores/search";
import {useRouter} from "vue-router";

defineComponent({
  components: {
    IosSearch,
  },
});

const props = defineProps([
  "placeholder",
  "onFocusHandler",
  "onBlurHandler",
  "inputStyle",
]);
const searchStore = useSearchStore();
const router = useRouter();

function enterEventHandler() {
  router.push("/search/doc/" + searchStore.inputValue);
}

function searchButtonClickHandler() {
  router.push("/search/doc/" + searchStore.inputValue);
}
</script>

<style>
.pure_search_container {
  display: flex;
  align-items: center;
}
.n-input__input {
  display: flex;
  align-items: center;
}
</style>
