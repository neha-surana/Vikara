<script setup lang="ts">
import { inject } from "vue";
const categoryList = inject("categoryList");
import { useRoute } from "vue-router";
const route = useRoute();
import CategoryFilters from "@/components/CategoryFilters.vue";
</script>

<style scoped>
.category-box {
  margin-top: 10px;
  min-width: 300px;
  border-radius: 20px;
  padding: 10px;
  overflow: auto;
  background-color: var(--card-background-color);
}

.filter {
  color: #ff8a00;
  font-size: 60px;
  position: relative;
  z-index: 10;
}

.category-box > * + * {
  margin-top: 30px;
}

.category-filter {
  padding: 10px;
  margin: 25px;
  display: flex;
  align-items: center;
  height: 50px;
  width: 300px;
  background-color: var(--primary-color);
  border-radius: 10px;
  cursor: pointer;
}
.category-filter:hover {
  background-color: bisque;
}

.category-filter > div {
  font-size: 25px;
  font-family: var(--title-font-family);
  text-transform: uppercase;
  font-style: bold;
}

.category-filter > i {
  margin-left: auto;
  margin-right: 10px;
}
</style>

<template>
  <div class="category-box">
    <!-- <div></div> -->
    <div class="filter"><i class="fa-solid fa-filter"></i></div>
    <div class="category-filter">
      <div class="category-type">{{ route.params.name }}</div>
      <category-filters></category-filters>
      <i class="fa-sharp fa-solid fa-caret-down"></i>
    </div>

    <div class="category-filter">
      <div>SORT : LOW To High</div>
      <i class="fa-sharp fa-solid fa-caret-down"></i>
    </div>
    <div class="category-filter">
      <div>&lt; 100 $</div>
      <i class="fa-sharp fa-solid fa-caret-down"></i>
    </div>
    <div class="category-filter">
      <div>BESTSELLERS</div>
      <i class="fa-sharp fa-solid fa-caret-down"></i>
    </div>
  </div>
</template>
