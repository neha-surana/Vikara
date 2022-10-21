<script setup lang="ts">
import { defineProps } from "vue";
import { BookItem } from "@/types";
const props = defineProps<{
  book: BookItem;
}>();
const bookImageFileName = function (book: BookItem): string {
  let name = book.title.toLowerCase();
  name = name.replace(/ /g, "-");
  name = name.replace(/'/g, "");
  name = name.toLowerCase();
  return `${name}.jpg`;
};
</script>
<style scoped>
.book-card {
  position: relative;
  text-align: center;
  width: 250px;
}

.book-box {
  display: flex;
  flex-direction: row;
  margin-left: 20px;
  width: 400px;
  height: 240px;
  border-radius: 20px;
  /*background-color: var(--card-background-color);*/
  padding: 1em;
  gap: 0.25em;
}

.is-featured {
  background-color: beige;
}

.not-is-featured {
  background-color: var(--card-background-color);
}

.book-box > div {
  display: inline-block;
}

.book-image {
  position: relative;
  width: 120px;
  height: auto;
}

.book-image img {
  width: 180px;
  height: 200px;
}

.readme-icon {
  border: 2px solid #ff8a00;
  background-color: #111111;
  border-radius: 25px;
  width: 60px;
  height: 60px;
  font-size: 30px;
  color: #ff8a00;
  position: absolute;
  top: 40%;
  left: 25%;
  cursor: pointer;
}

.readme-icon:hover {
  background-color: aliceblue;
}

.readme-icon > i {
  margin: 16px 9px 7px 11px;
  align-self: center;
}

.no-readme-icon {
  display: none;
}

.book-price {
  font-weight: bold;
  margin-left: 20px;
  margin-top: 10px;
  font-size: 25px;
  color: var(--primary-color);
}

.book-title {
  align-items: center;
  margin-left: 20px;
  font-weight: bold;
  font-size: 25px;
  color: var(--primary-color);
}

.book-author {
  word-wrap: normal;
  font-size: 20px;
  margin-left: 20px;
  margin-top: 10px;
  align-items: center;
  font-weight: bold;
  color: var(--primary-color);
}

.cart-button {
  border: 2px solid black;
  border-radius: 10px;
  left: 75px;
  bottom: 10px;
  width: 100px;
  height: 50px;
  background-color: #ff8a00;
  font-size: 20px;
  position: absolute;
  cursor: pointer;
  padding: 3px;
}

.cart-button:hover {
  background-color: darkgray;
}

.cart-button > div {
  font-size: 30px;
  font-family: var(--title-font-family);
  margin-top: 4px;
  color: black;
  justify-content: center;
  align-content: center;
  display: inline-block;
  font-weight: bolder;
}
</style>

<template>
  <li
    class="book-box"
    :class="book.isFeatured === true ? 'is-featured' : 'not-is-featured'"
  >
    <div class="book-image">
      <div :class="book.isPublic === false ? 'readme-icon' : 'no-readme-icon'">
        <i class="fa-brands fa-readme"></i>
      </div>
      <a href="#"
        ><img
          :src="require('@/assets/images/books/' + bookImageFileName(book))"
          :alt="book.title"
      /></a>
    </div>
    <div class="book-card">
      <div class="book-title">{{ book.title }}</div>
      <div class="book-author">By - {{ book.author }}</div>
      <div class="book-price">${{ (book.price / 100).toFixed(2) }}</div>
      <div class="cart-button">
        <div><i class="fa-solid fa-cart-plus"></i></div>
        <div>ADD</div>
      </div>
    </div>
  </li>
</template>
