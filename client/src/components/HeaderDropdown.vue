<script setup lang="ts">
import { inject } from "vue";
const categoryList = inject("categoryList");
</script>

<style scoped>
.hamburger {
  padding-top: 7px;
  min-width: 143px;
  border-radius: 10px;
  background-color: #ff8a00;
  align-items: center;
  font-size: 30px;
  margin-left: 25px;
  margin-right: 10px;
  position: relative;
  display: inline-block;
  cursor: pointer;
  text-align: center;
}

.category-list {
  padding: 5px;
  background-color: #ff8a00;
  color: #111111;
  font-size: 20px;
  /*height: max-content;*/
  font-weight: bolder;
}

/*.hamburger-dropdown {*/
/*  text-align: left;*/
/*  font-style: var(--title-font-family);*/
/*  position: absolute;*/
/*  !*display: none;*!*/
/*  !*background-color: #ff8a00;*!*/
/*  margin-top: 8px;*/
/*  z-index: 1;*/
/*  right: 0;*/
/*  min-width: 100px;*/
/*  border-radius: 5px;*/
/*}*/

/*.hamburger:hover ul {*/
/*  background-color: #ff8a00;*/
/*  max-height: 0;*/
/*  transition: max-height 0.5s ease-out;*/
/*}*/

/*.hamburger:hover ul {*/
/*  background-color: #ff8a00;*/
/*  max-height: 260px;*/
/*  transition: max-height 0.5s ease-in;*/
/*  border-radius: 10px;*/
/*}*/

/*.hamburger-dropdown a {*/
/*  color: #111111;*/
/*  width: inherit;*/
/*  height: inherit;*/
/*}*/

/*.hamburger-dropdown li {*/
/*  padding: 15px;*/
/*  align-items: center;*/
/*}*/

/*.hamburger-dropdown li:hover {*/
/*  background-color: bisque;*/
/*  border-radius: 5px;*/
/*}*/

/*--------------------------------------------------------------*/

.hamburger ul {
  background-color: #ff8a00;
  position: absolute;
  z-index: 1;
  max-height: 0;
  overflow: hidden;
  transition: max-height 0.5s ease-out;
  border-radius: 10px;
}

.hamburger:hover ul {
  /*background-color: #ff8a00;*/
  max-height: 260px;
  transition: max-height 0.5s ease-in;
  /*border-radius: 10px;*/
  /*overflow: visible;*/
}

ul a {
  padding: 15px;
  text-decoration: none;
  display: block;
  color: #111111;
}

ul a:hover {
  background-color: bisque;
  border-radius: 5px;
}

/*.hamburger:hover a {*/
/*  color: #111111;*/
/*  !*width: inherit;*!*/
/*  !*height: inherit;*!*/
/*}*/

/*.hamburger:hover li {*/
/*  padding: 15px;*/
/*  align-items: center;*/
/*}*/

/*.hamburger:hover li:hover {*/
/*  background-color: bisque;*/
/*  border-radius: 5px;*/
/*}*/

/*--------------------------------------------------------------*/
/*.hamburger:hover .hamburger-dropdown {*/
/*  !*display: block;*!*/
/*  border-radius: 10px;*/
/*}*/

.hamburger:hover .arrow-down {
  display: inline;
}

.hamburger:hover .arrow-up {
  display: none;
}

.hamburger .arrow-down {
  display: none;
}

.hamburger .arrow-up {
  display: inline;
}
</style>

<template>
  <div class="hamburger">
    <!--    <i class="fa-sharp fa-solid fa-bars"></i>-->
    <div class="category-list">
      Categories
      <i class="fa-solid fa-caret-down arrow-down"></i>
      <i class="fa-solid fa-caret-up arrow-up"></i>
    </div>
    <ul>
      <li v-for="category in categoryList" :key="category.categoryId">
        <router-link :to="'../category/' + category.name">
          {{ category.name }}
        </router-link>
      </li>
    </ul>
    <!--    <div class="hamburger-dropdown">-->
    <!--      <ul>-->
    <!--        <li v-for="category in categoryList" :key="category.categoryId">-->
    <!--          <router-link :to="'../category/' + category.name">-->
    <!--            {{ category.name }}-->
    <!--          </router-link>-->
    <!--        </li>-->
    <!--      </ul>-->
    <!--    </div>-->
  </div>
</template>
