<script setup lang="ts">
import HeaderDropdown from "@/components/HeaderDropdown.vue";
</script>

<style scoped>
.who_section {
  width: 100%;
  float: left;
  background-image: url("../assets/images/vikara/green-banner.jpg");
  height: auto;
  padding-bottom: 55px;
  background-size: 100%;
}
.who_taital {
  width: 100%;
  float: left;
  font-size: 36px;
  color: #ffffff;
  text-align: center;
  text-transform: uppercase;
  font-weight: 500;
}
.designer_text {
  width: 100%;
  float: left;
  font-size: 18px;
  color: #ffffff;
  text-align: center;
  text-transform: uppercase;
}
.lorem_ipsum_text {
  width: 100%;
  float: left;
  font-size: 22px;
  color: #ffffff;
  text-align: center;
  margin-left: 0px;
  font-weight: 400;
  line-height: 35px;
}
.get_bt_main {
  width: 13%;
  margin: 0 auto;
  text-align: center;
}
.get_bt {
  width: 100%;
  float: left;
  margin-top: 70px;
}
.get_bt a {
  width: 100%;
  float: left;
  font-size: 18px;
  color: #ffffff;
  background-color: black;
  text-align: center;
  padding: 10px 0px;
  border-radius: 10px;
  text-transform: uppercase;
}
.get_bt a:hover {
  color: #000;
  background-color: #ffffff;
}
</style>

<template>
  <div class="who_section layout_padding">
    <div class="container">
      <h1 class="who_taital">who we are ?</h1>
      <p class="lorem_ipsum_text">
        We at Vikara aim towards fostering positivity and productivity amongst
        our users by providing them with a one-stop platform for their emotional
        and mental well-being. We want to help our users manage their emotions
        and help them get a better sense of awareness about their mental health
        so that we can provide them with the best resources to make them feel
        better again.
      </p>
    </div>
    <div class="get_bt_main">
      <div class="get_bt"><a href="#">Know More</a></div>
    </div>
  </div>
</template>
