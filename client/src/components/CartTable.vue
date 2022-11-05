<script setup lang="ts">
import { useCartStore } from "@/stores/CartStore";
const cartStore = useCartStore();
import { ShopItem } from "@/types";

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

const updateCart = function (shop: ShopItem, quantity: number) {
  cartStore.updateItemQuantity(shop, quantity);
};

const prevCategory = localStorage.getItem("PREV_CATEGORY") || "generic";

const PriceFormatter = new Intl.NumberFormat("en-US", {
  style: "currency",
  currency: "USD",
  minimumFractionDigits: 2,
});
</script>

<style scoped>
.cart-table {
  display: grid;
  grid-template-columns: max-content minmax(10em, 20em) repeat(3, max-content);
  row-gap: 1em;
  width: fit-content;
  margin: 0 auto;
  background-color: aliceblue;
  justify-items: center;
  align-items: center;
}

ul {
  display: contents;
}

ul > li {
  display: contents;
}

.table-heading {
  background-color: #333;
  color: white;
}

.table-heading > * {
  background-color: #333;
  padding: 0.5em;
}

.heading-shop {
  grid-column: 1 / 3;
  width: 100%;
  text-align: center;
}

.heading-price {
  grid-column: 3 / 5;
  text-align: center;
  width: 100%;
}

.heading-subtotal {
  text-align: center;
  grid-column: -2 / -1;
  width: 100%;
}

.cart-shop-image {
  padding: 0 1em;
}

.cart-shop-image > * {
  margin-left: auto;
  margin-right: 0;
}

img {
  display: block;
  width: 110px;
  height: 150px;
}

.cart-shop-price {
  padding-left: 1em;
  text-align: right;
}

.cart-shop-title {
  justify-self: flex-start;
}

.cart-shop-quantity {
  padding-left: 1em;
  padding-right: 1em;
}

.cart-shop-subtotal {
  text-align: center;
  padding-left: 1em;
  padding-right: 1em;
  width: 100%;
}

.line-sep {
  display: block;
  height: 2px;
  background-color: gray;
  grid-column: 1 / -1;
  width: 100%;
}

.icon-button {
  border: none;
  cursor: pointer;
  font-size: 1.5rem;
  background: transparent;
}

.inc-button:hover {
  color: green;
}

.dec-button:hover {
  color: red;
}

.cart-final-subtotal {
  text-align: center;
  grid-column: -2 / -1;
  width: 100%;
  padding: 10px;
  padding-top: 0;
}

.checkout-button {
  background: linear-gradient(0deg, rgba(0, 0, 0, 0.2), rgba(0, 0, 0, 0.2)),
    #008080;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25), 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 12px;
  padding: 1rem 4rem;
  font-style: normal;
  font-weight: 400;
  font-size: 35px;
  width: fit-content;
  color: white;
  text-decoration: none;
  align-items: center;
  display: flex;
}

.checkout-button:hover {
  background: darkolivegreen;
}

.clear-cart-row {
  grid-column: 1 / -1;
  width: 100%;
  justify-content: center;
  padding: 10px;
  display: flex;
}

.clear-cart {
  /*background: #993d00;*/
  /*box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);*/
  /*border-radius: 12px;*/
  padding: 0.5rem 1rem;
  font-style: normal;
  font-weight: 400;
  font-size: 20px;
  width: fit-content;
  /*color: white;*/
  text-decoration: none;
  cursor: pointer;
  align-items: center;
  display: flex;
  color: darkgoldenrod;
  border: none;
  background: transparent;
  border: solid darkgoldenrod 3px;
  border-radius: 10px;
}

.clear-cart:hover {
  background-color: darkgoldenrod;
  color: white;
}

.continue-shopping {
  background: #ffffff;
  border: 2px solid #008080;
  color: #008080;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 12px;
  padding: 10px;
  font-style: normal;
  font-weight: 200;
  font-size: 20px;
  width: fit-content;
  text-decoration: none;
  cursor: pointer;
  align-items: center;
  display: flex;
  margin-left: 45px;
}

.empty-cart {
  display: flex;
  flex-direction: column;
  gap: 30px;
  padding: 20px;
}

.empty-cart p {
  font-size: 36px;
  text-align: center;
  padding: 10px 20px;
  background: #a55a33;
  width: -moz-max-content;
  width: max-content;
  margin: 0 auto;
  color: white;
}

.empty-cart .continue-shopping {
  margin: 0 auto;
  font-size: 35px;
}

.cart-buttons {
  grid-column: 1 / -1;
  width: 100%;
  display: flex;
  justify-content: space-between;
  padding: 10px;
}

.continue-shopping:hover {
  background: #d2bba5;
  color: black;
  border-color: transparent;
}

.remove-display {
  display: none;
}
</style>

<template>
  <div class="empty-cart" :class="{ 'remove-display': cartStore.count !== 0 }">
    <p>Your cart is empty</p>
    <router-link
      :to="'../itemCategory/' + prevCategory"
      class="continue-shopping"
      >Continue Shopping</router-link
    >
  </div>
  <div class="cart-table" :class="{ 'remove-display': cartStore.count === 0 }">
    <ul>
      <li class="table-heading">
        <div class="heading-shop">Item</div>
        <div class="heading-price">Price / Quantity</div>
        <div class="heading-subtotal">Amount</div>
      </li>

      <template
        v-for="item in cartStore.cart.items"
        :key="item.product.item_id"
      >
        <li>
          <div class="cart-shop-image">
            <img
              :src="getProductImageUrl(item.product)"
              :alt="item.product.product_name"
            />
          </div>
          <div class="cart-shop-title">{{ item.product.product_name }}</div>
          <div class="cart-shop-price">
            ${{ item.product.price.toFixed(2) }}
          </div>
          <div class="cart-shop-quantity">
            <button
              class="icon-button dec-button"
              @click="updateCart(item.product, item.quantity - 1)"
            >
              <i class="fa-solid fa-circle-minus"></i>
            </button>
            &nbsp;<span class="quantity">{{ item.quantity }}</span
            >&nbsp;
            <button
              class="icon-button inc-button"
              @click="updateCart(item.product, item.quantity + 1)"
            >
              <i class="fa-solid fa-circle-plus"></i>
            </button>
          </div>
          <div class="cart-shop-subtotal">
            {{ PriceFormatter.format(item.quantity * item.product.price) }}
          </div>
        </li>
        <li class="line-sep"></li>
      </template>
      <li>
        <div class="heading-shop"></div>
        <div class="heading-price"></div>
        <div class="cart-final-subtotal">
          Subtotal({{ cartStore.count }}
          {{ cartStore.count == 1 ? "Item" : "Items" }}):
          {{ PriceFormatter.format(cartStore.cart.subtotal) }}
        </div>
      </li>
      <li class="cart-buttons">
        <router-link
          :to="'../itemCategory/' + prevCategory"
          class="continue-shopping"
          >Continue Shopping</router-link
        >
        <router-link to="../checkout" class="checkout-button"
          >Checkout</router-link
        >
      </li>
      <li class="clear-cart-row">
        <button class="clear-cart" @click="cartStore.clearCart()">
          Clear Cart
        </button>
      </li>
    </ul>
  </div>
</template>
