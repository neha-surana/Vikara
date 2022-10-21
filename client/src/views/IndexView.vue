<script setup lang="ts"></script>

<style scoped>
.home-page {
  display: flex;
}

/*.bodystyle {*/
/*  height: 100%;*/
/*  justify-content: center;*/
/*  display: flex;*/
/*  align-items: flex-end;*/
/*  padding-bottom: 150px;*/
/*}*/

/*.cta {*/
/*  border: 5px solid #111111;*/
/*  font-weight: bolder;*/
/*  height: 75px;*/
/*  border-radius: 10px;*/
/*  width: 250px;*/
/*  background-color: var(--primary-color);*/
/*  font-family: var(--cta-font);*/
/*  font-size: 30px;*/
/*  padding-left: 10px;*/
/*  padding-right: 10px;*/
/*  cursor: pointer;*/
/*}*/

/*.cta:hover {*/
/*  background-color: bisque;*/
/*}*/

/*.welcome-text {*/
/*  !*width: 20em;*!*/
/*  font-size: 60px;*/
/*  font-family: var(--title-font-family);*/
/*}*/

.index-page {
  display: flex;
  justify-content: center;
  align-items: center;
}

.user-input {
  display: flex;
  min-width: 400px;
  min-height: 400px;
  background-color: #ff8a00;
  border-radius: 10px;
  justify-content: space-between;
}

.user-input-common {
  background-color: white;
  text-align: center;
  align-self: center;
  min-width: 100px;
  min-height: 50px;
  padding: 10px;
  font-weight: bolder;
  font-size: 20px;
  border-radius: 5px;
}

.survey-button {
  margin-left: 10px;
}

.login-button {
  margin-right: 10px;
}

.survey-button a {
  display: block;
  color: #111111;
}

.login-button a {
  display: block;
  color: #111111;
}
</style>

<template>
  <!--  <div class="home-page">-->
  <!--    <div class="hero-image">-->
  <!--      <div class="welcome-text">Open your mind to endless possibilities...</div>-->
  <!--      <div class="bodystyle">-->
  <!--        <router-link to="/category/Fantasy">-->
  <!--          <button class="cta">BUY BOOKS !!</button></router-link-->
  <!--        >-->
  <!--      </div>-->
  <!--    </div>-->
  <!--  </div>-->
  <div class="index-page">
    <!--    <div>-->
    <div class="user-input">
      <div class="survey-button user-input-common">
        <router-link to="../survey">Take Survey!!</router-link>
      </div>
      <div class="login-button user-input-common">
        <router-link to="../login">Login!!</router-link>
      </div>
      <!--      </div>-->
    </div>
  </div>
</template>
