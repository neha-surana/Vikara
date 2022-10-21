<script setup lang="ts">
import AppFetchCategories from "@/components/AppFetchCategories.vue";
import AppHeader from "@/components/AppHeader.vue";
import AppFooter from "@/components/AppFooter.vue";
</script>

<style></style>

<template>
  <div id="app">
    <!--    <Suspense>-->
    <!--      <AppFetchCategories></AppFetchCategories>-->
    <app-header></app-header>
    <router-view></router-view>
    <app-footer></app-footer>
    <!--    </Suspense>-->
  </div>
</template>
