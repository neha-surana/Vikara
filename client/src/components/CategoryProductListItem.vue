<script setup lang="ts">
import { ShopItem } from "@/types";
import { useCartStore } from "@/stores/CartStore";
const cartStore = useCartStore();
import { defineProps } from "vue";
const props = defineProps<{ shop: ShopItem }>();

const getProductImageUrl = function (shop: ShopItem): string {
  let filename = shop.product_name.toLowerCase();
  filename = filename.replace(/ /g, "-");
  filename = filename.replace(/'/g, "");
  filename = filename.replace(/\?/g, "");
  filename = filename + ".jpg";
  try {
    return require("@/assets/images/products/" + filename);
  } catch (_) {
    return require("@/assets/images/products/matcha.jpg");
  }
};
</script>

<style scoped>
.shop-box {
  display: flex;
  background: rgba(255, 255, 255, 0.8);
  padding: 1em;
  gap: 0.5em;
  width: 300px;
  color: #022643;
  height: fit-content;
  min-height: 250px;
  min-width: 400px;
  max-width: 500px;
  justify-content: center;
}

.featured-shop {
  background-color: #022643;
  border: 5px solid darkgoldenrod;
  color: whitesmoke;
}

.shop-image {
  position: relative;
  height: 216px;
}

.shop-image img {
  height: 200px;
  width: 150px;
  border: #111111 solid 2px;
}

.shop-details {
  display: flex;
  flex-direction: column;
  width: 100%;
  text-align: center;
  font-size: 20px;
}

.shop-title {
  padding: 8px;
  font-weight: bold;
  line-height: 28px;
}

.shop-author {
  padding: 8px;
  font-style: italic;
  line-height: 28px;
}

.shop-price {
  padding: 8px;
}

.add-button {
  cursor: pointer;
  gap: 10px;
  margin: auto;
  margin-bottom: 0;
  width: max-content;
  justify-self: center;
  background: maroon;
  box-shadow: 0px 4px 4px rgb(0 0 0 / 25%);
  border-radius: 10px;
  display: flex;
  padding: 10px;
  align-self: center;
  color: white;
  border: none;
}
.add-button:hover {
  background-color: darkgoldenrod;
}
.add-icon {
  align-self: center;
  cursor: pointer;
}

.hide-read-button {
  display: none;
}

.shop-image i {
  position: absolute;
  bottom: 8%;
  right: 5%;
  background-color: antiquewhite;
  border-color: black;
  color: maroon;
  border-radius: 50%;
  padding: 10px;
  cursor: pointer;
  font-size: 30px;
}
.shop-image i:hover {
  background-color: #ee9b00;
  color: #022643;
}
</style>

<template>
  <li class="shop-box" :class="{ 'featured-shop': shop.is_featured }">
    <div class="shop-image-parent">
      <div class="shop-image">
        <img :src="getProductImageUrl(shop)" :alt="shop.product_name" />
        <i
          class="fa-solid fa-shop-open-reader"
          :class="[{ 'hide-read-button': shop.is_public === false }]"
        ></i>
      </div>
    </div>
    <div class="shop-details">
      <div class="shop-title">{{ shop.product_name }}</div>
      <div class="shop-author">by {{ shop.description }}</div>
      <div class="shop-price">${{ shop.price.toFixed(2) }}</div>
      <button class="add-button" @click="cartStore.addToCart(shop)">
        <i class="fas fa-cart-plus add-icon"></i>Add
      </button>
    </div>
  </li>
</template>
