<template>
  <div :style="props.listStyle">
    <ul class="list_container">
      <li class="list_item" v-for="item in props.items" :key="item.id">
        <a :href="item.url">{{ item.value }}</a>
      </li>
    </ul>
    <slot></slot>
  </div>
</template>

<script setup>
const props = defineProps(["listStyle", "items", "listStyle"]);
</script>

<style scoped>
ul {
  list-style: none;
  padding: 0;
  margin: 0;
}
li {

}
li:hover {
  background-color: #f1f3f5;
}

a {
  text-decoration: none;
  color: #495057;
  display: flex;
  padding: 3px 15px;
}
</style>
