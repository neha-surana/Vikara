<script setup lang="ts">
import { useRoute } from "vue-router";
const route = useRoute();
import { useCategoryStore } from "@/stores/CategoryStore";
const categoryStore = useCategoryStore();
</script>

<style scoped>
.itemCategory-buttons {
  width: 230px;
  background: rgba(255, 255, 255, 0.8);
  height: fit-content;
  display: flex;
  flex-direction: row;
  text-align: start;
}

.itemCategory-buttons a {
  padding: 6px 8px 6px 16px;
  text-decoration: none;
  font-size: 35px;
  color: #022643;
  display: block;
  width: 100%;
}

.selected-itemCategory-button {
  border: 5px solid maroon;
  color: maroon !important;
}

.unselected-itemCategory-button:hover {
  color: chocolate;
}
</style>

<template>
  <div class="itemCategory-buttons">
    <ul style="width: 100%">
      <li
        v-for="itemCategory in categoryStore.categoryList"
        :key="itemCategory.itemCategory_id"
      >
        <router-link
          :to="'../itemCategory/' + itemCategory.name"
          class="itemCategory-button"
          :class="[
            itemCategory.name.toLowerCase() === route.params.name.toLowerCase()
              ? 'selected-itemCategory-button'
              : 'unselected-itemCategory-button',
          ]"
        >
          {{ itemCategory.name }}
        </router-link>
      </li>
    </ul>
  </div>
</template>
