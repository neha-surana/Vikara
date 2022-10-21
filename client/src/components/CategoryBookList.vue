<script setup lang="ts">
import { defineProps } from "vue"; // needed if you don't want an error below
import { BookItem } from "@/types";
import CategoryBookListItem from "@/components/CategoryBookListItem.vue";
const props = defineProps<{
  bookList: BookItem[];
}>();
</script>

<style scoped>
#book-boxes {
  display: flex;
  flex-wrap: wrap;
  padding: 1em;
  gap: 1em;
}
</style>

<template>
  <ul id="book-boxes">
    <template v-for="book in bookList" :key="book.bookId">
      <category-book-list-item :book="book"></category-book-list-item>
    </template>
  </ul>
</template>
