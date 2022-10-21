<script setup lang="ts">
import { inject } from "vue";
const categoryList = inject("categoryList");
</script>

<style scoped>
.category-filter:hover .category-dropdown {
  display: block;
}

.category-dropdown {
  position: absolute;
  display: none;
  background-color: #ff8a00;
  z-index: 1;
  transform: translate(-10px, 150px);
  min-width: 300px;
  border-radius: 10px;
}

ul a {
  color: #111111;
  padding: 15px 20px;
  display: block;
}

.category-dropdown a:hover {
  background-color: bisque;
  border-radius: 10px;
}
</style>
<template>
  <div class="category-dropdown">
    <ul>
      <li v-for="category in categoryList" :key="category.categoryId">
        <router-link :to="'../category/' + category.name">
          {{ category.name }}
        </router-link>
      </li>
    </ul>
  </div>
</template>
