<script setup lang="ts">
import { watch } from "vue";
import CategoryNav from "@/components/CategoryNav.vue";
import CategoryProductList from "@/components/CategoryProductList.vue";
import { useRoute } from "vue-router";
import { useItemStore } from "@/stores/ItemStore";
const route = useRoute();
const itemStore = useItemStore();

watch(
  () => route.params.name,
  (newName) => {
    itemStore.fetchItems(newName as string);
  },
  { immediate: true }
);
</script>

<style scoped>
.itemCategory-page {
  display: flex;
  min-height: calc(100vh - 300px);
  width: 100%;
  background-image: url("@/assets/images/hero2.jpg");
  padding: 20px;
  gap: 20px;
}
</style>

<template>
  <div class="itemCategory-page">
    <CategoryNav></CategoryNav>
    <CategoryProductList> </CategoryProductList>
  </div>
</template>
