<script setup lang="ts">
</script>

<style scoped>
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
  <div>
    <div class="banner_section layout_padding">
      <div class="container">
        <div id="costum_slider" class="carousel slide" data-ride="carousel">
          <div class="carousel-inner">
            <div class="carousel-item active">
              <h1 class="furniture_text">Evaluate your mood</h1>
              <p class="there_text">
                If you have ever found yourself feeling stressed, confused,
                anxious, sad or maybe just not right? With the help of a mood
                survey you can know exactly what you can do to feel better. We
                have trained our ML Models to detect any potential mental
                indisposition our user might have to help them be more self
                aware.
              </p>
              <div class="features-image">
                <img src="../assets/images/vikara/mood-survey-features-1.png" />
              </div>
              <div class="contact_bt_main">
                <div class="contact_bt">
                  <router-link to="/survey">Take Survey</router-link>
                </div>
              </div>
            </div>
          </div>
      </div>
    </div>
    <!-- banner section end -->
    <!-- services section start -->
  </div>
</template>
