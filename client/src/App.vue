<script setup lang="ts">
import AppHeader from "@/components/AppHeader.vue";
import AppFooter from "@/components/AppFooter.vue";
</script>

<style></style>

<template>
  <div id="app">
    <!--    <Suspense>-->

    <AppHeader></AppHeader>

    <router-view></router-view>
    <app-footer></app-footer>

    <!--    <app-header></app-header>-->
    <!--    <router-view></router-view>-->
    <!--    <app-footer></app-footer>-->
    <!--    </Suspense>-->
  </div>
</template>
