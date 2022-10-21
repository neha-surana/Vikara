<script setup lang="ts">
import { provide } from "vue";
import { BookItem } from "@/types";
import CategoryFetchBooks from "../components/CategoryFetchBooks.vue";
import CategoryBookList from "@/components/CategoryBookList.vue";
import CategoryBox from "@/components/CategoryBox.vue";
</script>

<style scoped>
.hero-image-category {
  display: flex;
  justify-content: space-between;
  width: 100%;
  min-height: calc(100vh - 100px);
  background-image: url("../assets/images/site/hero-image.jpg");
  background-position: center center;
  background-repeat: no-repeat;
  background-size: cover;
  background-attachment: fixed;
  padding: 50px;
}
</style>

<template>
  <div class="category-page">
    <div class="hero-image-category">
      <section>
        <category-box></category-box>
      </section>
      <section class="category-book-list">
        <category-fetch-books></category-fetch-books>
      </section>
    </div>
  </div>
</template>
