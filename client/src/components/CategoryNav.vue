<!--<script setup lang="ts">-->
<!--import { inject } from "vue";-->
<!--const categoryList = inject("categoryList");-->
<!--import { useRoute } from "vue-router";-->
<!--const route = useRoute();-->
<!--</script>-->

<!--<style scoped>-->
<!--.category-buttons {-->
<!--  display: flex;-->
<!--  flex-direction: row;-->
<!--  text-align: center;-->
<!--  background-color: var(&#45;&#45;neutral-color);-->
<!--}-->

<!--.button.selected-category-button {-->
<!--  background-color: var(&#45;&#45;primary-color);-->
<!--}-->

<!--.button.unselected-category-button,-->
<!--.button.unselected-category-button:visited {-->
<!--  background-color: var(&#45;&#45;neutral-color);-->
<!--}-->

<!--.button.unselected-category-button:hover,-->
<!--.button.unselected-category-button:active {-->
<!--  background-color: var(&#45;&#45;primary-color);-->
<!--}-->
<!--</style>-->

<!--<template>-->
<!--  <nav class="category-nav">-->
<!--    <ul class="category-buttons">-->
<!--      <li v-for="category in categoryList" :key="category.categoryId">-->
<!--        <router-link-->
<!--          :to="'../category/' + category.name"-->
<!--          class="button unselected-category-button"-->
<!--        >-->
<!--          {{ category.name }}-->
<!--        </router-link>-->
<!--      </li>-->
<!--    </ul>-->
<!--  </nav>-->
<!--</template>-->
