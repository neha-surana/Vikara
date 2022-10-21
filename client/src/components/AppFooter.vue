<script setup lang="ts"></script>

<style scoped>
footer {
  background: black;
  display: flex;
  height: 100px;
  align-items: center;
  justify-content: space-between;
  gap: 1em;
}

.links {
  align-items: center;
  display: flex;
  font: bolder;
  font-size: 20px;
  font-family: "Roboto", serif;
  flex-direction: column;
  text-transform: uppercase;
}

.copyright {
  display: inline-flex;
  color: #ff8a00;
  font-size: 20px;
  vertical-align: middle;
}

.copyright-icon {
  margin-top: 5px;
  margin-right: 20px;
}

.social-media-icons {
  display: inline-flex;
  position: center;
  width: 50px;
  height: 45px;
  gap: 0.25em;
  font-size: larger;
}

.social-media-icons > div {
  padding-left: 25px;
  padding-top: 5px;
  padding-bottom: 5px;
  color: #ff8a00;
  font-size: 20px;
  font-family: var(--default-font-family);
}

.social-media-icons > i {
  margin-left: 20px;
  color: #ff8a00;
  font-size: 35px;
  cursor: pointer;
}

.links a {
  font-family: var(--footer-links);
}

.message {
  padding-left: 30px;
  color: #ff8a00;
}

.direction-contact-about {
  display: inline-flex;
}

.whatsapp {
  margin-right: 20px;
  margin-top: 45px;
  color: #ff8a00;
}

.whatsapp i {
  font-size: larger;
}
</style>

<template>
  <footer class="container">
    <section class="icons-message">
      <div class="social-media-icons">
        <i class="fa-brands fa-facebook"></i>
        <i class="fa-brands fa-twitter"></i>
        <i class="fa-brands fa-instagram"></i>
      </div>
      <div class="message">DO FOLLOW !!</div>
    </section>

    <section class="copyright">
      <div class="copyright-icon"><i class="fa-solid fa-copyright"></i></div>
      <div>
        <p style="font-family: var(--default-font-family)">
          OG BookStore 2022. All Rights Reserved
        </p>
      </div>
    </section>

    <section class="direction-contact-about">
      <div class="whatsapp"><i class="fa-brands fa-whatsapp"></i></div>
      <div class="links">
        <router-link to="/">About US</router-link>
        <router-link to="/">Directions</router-link>
        <router-link to="/">Customer Care</router-link>
      </div>
    </section>
  </footer>
</template>
