<script setup lang="ts">
import HeaderDropdown from "@/components/HeaderDropdown.vue";
</script>

<style scoped>
header {
  display: flex;
  background-color: black;
  align-items: center;
  justify-content: space-between;
}

.text-logo {
  font-size: 45px;
  font-family: var(--title-font-family);
}

.bookstore-logo {
  display: inline-flex;
  align-items: center;
  font-size: 20px;
  font-style: var(--title-font-family);
}

.bookstore-logo a {
  margin-right: 10px;
}

.searchbar {
  min-width: 250px;
  width: 350px;
  height: 50px;
  border-radius: 30px;
  background-color: #ff8a00;
  display: flex;
  align-self: center;
  align-items: center;
  padding: 10px;
  position: center;
  justify-content: center;
}

.searchbar > i {
  font-size: 25px;
  color: black;
  font-display: var(--default-text-color);
}

.searchbar input {
  flex: 1;
  margin-left: 10px;
  font-size: 20px;
  border: none;
  outline: none;
  height: 40px;
}

.searchbar input::placeholder {
  font-size: 25px;
  font-weight: bolder;
  color: #111111;
}

.image {
  min-width: 100px;
}

.logo {
  margin-left: 10px;
  height: 60px;
}

.logo-image {
  border: 2px solid #ffa500;
}

.cart-profile-category {
  display: inline-flex;
}

.cart {
  min-width: 60px;
  min-height: 50px;
  cursor: pointer;
}

.shop-cart p {
  color: black;
  font-size: 15px;
  font-weight: bolder;
  position: absolute;
  top: 3px;
  left: 20px;
}

.cart i {
  margin: 10px;
  color: #ff8a00;
  font-size: 40px;
  position: absolute;
}

.profile {
  width: 50px;
  height: 50px;
  background-color: #ff8a00;
  align-content: center;
  border-radius: 30px;
  margin-left: 25px;
  font-size: 20px;
  text-align: center;
  cursor: pointer;
}

.profile > p {
  margin: 10px;
}
</style>

<template>
  <header class="container">
    <section class="bookstore-logo">
      <router-link class="image" to="/">
        <img
          class="logo-image logo"
          src="../assets/images/site/logo.png"
          alt="OG Bookstore Logo"
        />
      </router-link>
      <router-link to="/">
        <div class="text-logo" alt="OG Bookstore Logo">Vikara</div>
      </router-link>
    </section>
    <section class="title-and-search-bar">
      <div class="searchbar">
        <i class="fa fa-search" aria-hidden="true"></i>
        <input type="text" placeholder="Search" />
      </div>
    </section>
    <section class="cart-profile-category">
      <div class="cart">
        <i class="fa-solid fa-cart-shopping shop-cart"><p>2</p></i>
      </div>
      <div class="profile"><p>HV</p></div>
      <header-dropdown></header-dropdown>
    </section>
  </header>
</template>
