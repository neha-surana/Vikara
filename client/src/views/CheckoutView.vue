<script>
export default {
  name: "CheckoutView",
};
</script>

<style scoped>
.checkout-page {
  display: flex;
  min-height: calc(100vh - 300px);
  width: 100%;
  background-image: url("@/assets/images/hero2.jpg");
  padding: 20px;
  gap: 20px;
  flex-direction: column;
}

.checkout-page p {
  font-size: 36px;
  text-align: center;
  padding: 10px 20px;
  background: #a55a33;
  width: -moz-max-content;
  width: max-content;
  margin: 0 auto;
  color: white;
}

.back-to-cart {
  margin: 0 auto;
  font-size: 35px;
  background: #ffffff;
  border: 2px solid #008080;
  color: #008080;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 12px;
  padding: 0.5rem 1rem;
  font-style: normal;
  font-weight: 400;
  width: fit-content;
  text-decoration: none;
  cursor: pointer;
  align-items: center;
  display: flex;
}

.back-to-cart:hover {
  background: #d2bba5;
  color: black;
  border-color: transparent;
}
</style>

<template>
  <div class="checkout-page">
    <p>Checkout View</p>
    <router-link to="../cart" class="back-to-cart">Back to Cart</router-link>
  </div>
</template>
