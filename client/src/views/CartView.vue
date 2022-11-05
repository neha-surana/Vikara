<script>
import CartTable from "@/components/CartTable";
export default {
  name: "CartView",
  components: { CartTable },
};
</script>

<style scoped>
.cart-page {
  min-height: calc(100vh - 300px);
  background-image: url("@/assets/images/hero2.jpg");
  padding: 20px;
}
</style>

<template>
  <div class="cart-page">
    <cart-table></cart-table>
  </div>
</template>
