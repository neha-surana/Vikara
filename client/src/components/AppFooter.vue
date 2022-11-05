<script setup lang="ts"></script>

<style scoped>
.social_icon {
  width: 100%;
  margin: 0 auto;
  text-align: center;
  padding-top: 30px;
}
.social_icon ul {
  margin: 0px;
  padding: 0px;
  display: inline-flex;
}
.social_icon li {
  float: left;
  padding-right: 15px;
}

.copyright_section {
  width: 100%;
  float: left;
  background-color: #ffffff;
  height: auto;
}

.copyright_text {
  width: 100%;
  float: left;
  color: #000;
  text-align: center;
  font-size: 16px;
  margin-left: 0px;
}
.copyright_text a {
  color: #000;
}
.copyright_text a:hover {
  color: #fdbe28;
}
</style>

<template>
  <footer class="container">
    <div class="copyright_section">
      <div class="container">
        <div class="social_icon">
          <ul>
            <li>
              <a href="#"><img src="../assets/images/vikara/fb-icon.png" /></a>
            </li>
            <li>
              <a href="#"
                ><img src="../assets/images/vikara/twitter-icon.png"
              /></a>
            </li>
            <li>
              <a href="#"
                ><img src="../assets/images/vikara/instagram-icon.png"
              /></a>
            </li>
            <li>
              <a href="#"
                ><img src="../assets/images/vikara/linkedin-icon.png"
              /></a>
            </li>
          </ul>
        </div>
        <p class="copyright_text">2022 All Rights Reserved. Vikara</p>
      </div>
    </div>
  </footer>
</template>
