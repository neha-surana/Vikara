<script setup lang="ts">
import { useItemStore } from "@/stores/ItemStore";
const itemStore = useItemStore();
console.log(
  "This is the products list in category products list: : " +
    JSON.stringify(itemStore.itemList)
);
import CategoryProductListItem from "@/components/CategoryProductListItem.vue";
</script>

<style scoped>
ul {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
  padding: 1em;
  gap: 2em;
  width: 100%;
}
</style>

<template>
  <ul>
    <template v-for="shopItem in itemStore.itemList" :key="shopItem.item_id">
      <CategoryProductListItem :shop="shopItem"></CategoryProductListItem>
    </template>
  </ul>
</template>
