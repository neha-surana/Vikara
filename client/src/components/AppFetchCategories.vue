<script setup lang="ts">
import { provide } from "vue";
import { CategoryItem } from "@/types";
import AppHeader from "@/components/AppHeader.vue";
import AppFooter from "@/components/AppFooter.vue";

const url = "http://localhost:8080/HetBookstoreFetch/api/categories";
const categoryList: CategoryItem[] = await fetch(url).then((response) =>
  response.json()
);
console.log(categoryList[0]);

provide("categoryList", categoryList);
</script>

<style></style>

<template>
  <div id="app-fetch-categories">
    <app-header></app-header>
    <router-view></router-view>
    <app-footer></app-footer>
  </div>
</template>
