<script setup lang="ts">
// @import("../assets/js/bootstrap.bundle");
</script>

<!--<script src="js/jquery.min.js"></script>-->
<!--<script src="js/popper.min.js"></script>-->
<!--<script src="js/bootstrap.bundle.min.js"></script>-->
<!--<script src="js/jquery-3.0.0.min.js"></script>-->
<!--<script src="js/plugin.js"></script>-->
<!--&lt;!&ndash; sidebar &ndash;&gt;-->
<!--<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>-->
<!--<script src="js/custom.js"></script>-->
<!--&lt;!&ndash; javascript &ndash;&gt;-->
<!--<script src="js/owl.carousel.js"></script>-->
<!--<script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>-->

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

.signup-button {
  margin-left: 10px;
  margin-right: 10px;
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
  <!--  <div class="index-page">-->
  <!--    <div class="user-input">-->
  <!--      <div class="survey-button user-input-common">-->
  <!--        <router-link to="../survey">Take Survey!!</router-link>-->
  <!--      </div>-->
  <!--      <div class="signup-button user-input-common">-->
  <!--        <router-link to="../signup">Sign Up</router-link>-->
  <!--      </div>-->
  <!--      <div class="login-button user-input-common">-->
  <!--        <router-link to="../login">Login!!</router-link>-->
  <!--      </div>-->
  <!--    </div>-->
  <!--  </div>-->

  <!-- basic -->
  <!--    <meta charset="utf-8">-->
  <!--    <meta http-equiv="X-UA-Compatible" content="IE=edge">-->
  <!--    <meta name="viewport" content="width=device-width, initial-scale=1">-->
  <!--    &lt;!&ndash; mobile metas &ndash;&gt;-->
  <!--    <meta name="viewport" content="width=device-width, initial-scale=1">-->
  <!--    <meta name="viewport" content="initial-scale=1, maximum-scale=1">-->
  <!--    &lt;!&ndash; site metas &ndash;&gt;-->
  <!--    <title>Built Better</title>-->
  <!--    <meta name="keywords" content="">-->
  <!--    <meta name="description" content="">-->
  <!--    <meta name="author" content="">-->
  <!--    &lt;!&ndash; bootstrap css &ndash;&gt;-->
  <!--    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">-->
  <!--    &lt;!&ndash; style css &ndash;&gt;-->
  <!--    <link rel="stylesheet" type="text/css" href="css/style.css">-->
  <!--    &lt;!&ndash; Responsive&ndash;&gt;-->
  <!--    <link rel="stylesheet" href="css/responsive.css">-->
  <!--    &lt;!&ndash; fevicon &ndash;&gt;-->
  <!--    <link rel="icon" href="../assets/images/site/fevicon.png" type="image/gif" />-->
  <!--    &lt;!&ndash; Scrollbar Custom CSS &ndash;&gt;-->
  <!--    <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">-->
  <!--    &lt;!&ndash; Tweaks for older IEs&ndash;&gt;-->
  <!--    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">-->
  <!--    &lt;!&ndash; owl stylesheets &ndash;&gt;-->
  <!--    <link rel="stylesheet" href="css/owl.carousel.min.css">-->
  <!--    <link rel="stylesheet" href="css/owl.theme.default.min.css">-->
  <!--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">-->
  <!--  -->
  <!--  -->
  <!--  <body>-->
  <!-- header section start -->

  <!-- copyright section end -->
  <!-- Javascript files-->

  <div class="header_section">
    <div class="container-fluid">
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="logo">
          <a href="index.html"
            ><img class="logo-img" src="../assets/images/site/logo.png"
          /></a>
        </div>
        <button
          class="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item">
              <a class="nav-link" href="contact.html">Helpline</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="products.html">Products</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="about.html">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="login.html">LOGIN</a>
            </li>
          </ul>
        </div>
      </nav>
    </div>
  </div>
  <!-- header section end -->
  <!-- banner section start -->
  <div class="banner_section layout_padding">
    <div class="container">
      <div id="costum_slider" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <h1 class="furniture_text">Our Services</h1>
            <p class="there_text">
              There are many variations of passages of Lorem Ipsum available,
              but the majority have suffered alteration in some fo
            </p>
            <div class="contact_bt_main">
              <div class="contact_bt">
                <a href="contact.html">Take Survey</a>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <h3 class="furniture_text">Our Services</h3>
            <p class="there_text">
              There are many variations of passages of Lorem Ipsum available,
              but the majority have suffered alteration in some fo
            </p>
            <div class="contact_bt_main">
              <div class="contact_bt"><a href="contact.html">Products</a></div>
            </div>
          </div>
          <div class="carousel-item">
            <h1 class="furniture_text">Our Services</h1>
            <p class="there_text">
              There are many variations of passages of Lorem Ipsum available,
              but the majority have suffered alteration in some fo
            </p>
            <div class="contact_bt_main">
              <div class="contact_bt"><a href="contact.html">Blogs</a></div>
            </div>
          </div>
          <div class="carousel-item">
            <h1 class="furniture_text">Our Services</h1>
            <p class="there_text">
              There are many variations of passages of Lorem Ipsum available,
              but the majority have suffered alteration in some fo
            </p>
            <div class="contact_bt_main">
              <div class="contact_bt"><a href="contact.html">Events</a></div>
            </div>
          </div>
        </div>
        <a
          class="carousel-control-prev"
          href="#costum_slider"
          role="button"
          data-slide="prev"
        >
          <i class=""><img src="../assets/images/site/left-arrow.png" /></i>
        </a>
        <a
          class="carousel-control-next"
          href="#costum_slider"
          role="button"
          data-slide="next"
        >
          <i class=""><img src="../assets/images/site/right-arrow.png" /></i>
        </a>
      </div>
    </div>
  </div>
  <!-- banner section end -->
  <!-- services section start -->

  <!-- furnitures section end -->
  <!-- client section start -->
  <div class="clients_section layout_padding">
    <div class="container">
      <div
        id="carouselExampleIndicators"
        class="carousel slide"
        data-ride="carousel"
      >
        <ol class="carousel-indicators">
          <li
            data-target="#carouselExampleIndicators"
            data-slide-to="0"
            class="active"
          ></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <h1 class="client_text">Featured Blogs</h1>
            <p class="ipsum_text">
              "Mental health…is not a destination, but a process. It’s about how
              you drive, not where you’re going." — Noam Shpancer
            </p>
            <div class="clients_section2 layout_padding">
              <div class="client_1">
                <div class="row">
                  <div class="col-sm-3">
                    <div class="blog-image">
                      <img src="../assets/images/site/mental-health-1.jpg" />
                    </div>
                  </div>
                  <div class="col-sm-9">
                    <h1 class="blog_title">The Happiness of Not Thinking</h1>
                    <p class="blog_text">
                      Our culture overvalues thinking. Thought should be a tool
                      that we can pick up when we need it and then set down
                      again.
                    </p>
                  </div>
                </div>
              </div>
              <div class="client_2">
                <div class="row">
                  <div class="col-sm-3">
                    <div class="blog-image">
                      <img src="../assets/images/site/mental-health-2.png" />
                    </div>
                  </div>
                  <div class="col-sm-9">
                    <h1 class="blog_title">
                      The Importance of Not Being Who You Think You Are
                    </h1>
                    <p class="blog_text">
                      Are you feeling psychologically or physically distressed?
                      A little ego-dissolution could go a long way.
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <h1 class="client_text">Featured Blogs</h1>
            <p class="ipsum_text">
              "Vulnerability sounds like truth and feels like courage. Truth and
              courage aren’t always comfortable, but they're never weakness." —
              Brené Brown
            </p>
            <div class="clients_section2 layout_padding">
              <div class="client_1">
                <div class="row">
                  <div class="col-sm-3">
                    <div class="blog-image">
                      <img src="../assets/images/site/mental-health-3.png" />
                    </div>
                  </div>
                  <div class="col-sm-9">
                    <h1 class="blog_title">
                      Here’s How You Can Overcome Insomnia
                    </h1>
                    <p class="blog_text">
                      The importance of getting enough good-quality sleep cannot
                      be understated—it is a biological necessity, just like
                      food and water.
                    </p>
                  </div>
                </div>
              </div>
              <div class="client_2">
                <div class="row">
                  <div class="col-sm-3">
                    <div class="blog-image">
                      <img src="../assets/images/site/mental-health-4.jpg" />
                    </div>
                  </div>
                  <div class="col-sm-9">
                    <h1 class="blog_title">
                      Breaking Down the New Anxiety Screening Guidelines for
                      Kids
                    </h1>
                    <p class="blog_text">
                      Children should get screened regardless of whether they
                      have a diagnosed anxiety disorder.
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <h1 class="client_text">Featured Blogs</h1>
            <p class="ipsum_text">
              "Love yourself first, and everything else falls in line. You
              really have to love yourself to get anything done in this world."
              – Lucille Ball
            </p>
            <div class="clients_section2 layout_padding">
              <div class="client_1">
                <div class="row">
                  <div class="col-sm-3">
                    <div class="blog-image">
                      <img src="../assets/images/site/mental-health-5.png" />
                    </div>
                  </div>
                  <div class="col-sm-9">
                    <h1 class="blog_title">
                      The Science of Evolutionary Psychology
                    </h1>
                    <p class="blog_text">
                      Evolutionary psychology seeks to explain how our emotions
                      and other aspects of being human served as advantages to
                      our ancestors.
                    </p>
                  </div>
                </div>
              </div>
              <div class="client_2">
                <div class="row">
                  <div class="col-sm-3">
                    <div class="blog-image">
                      <img src="../assets/images/site/mental-health-6.jpg" />
                    </div>
                  </div>
                  <div class="col-sm-9">
                    <h1 class="blog_title">How I am learning to Love Myself</h1>
                    <p class="blog_text">
                      Self-love means having a relationship with yourself that
                      has compassion, kindness, patience, tolerance, and
                      curiosity.
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- client section end -->
  <!-- who section start -->
  <div class="who_section layout_padding">
    <div class="container">
      <h1 class="who_taital">who we are ?</h1>
      <h4 class="designer_text">DESIGNERS & INNOVATORS</h4>
      <p class="lorem_ipsum_text">
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
        tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim
        veniam, quis nostrud exercitation ullamco laboris nisi utLorem ipsum
        dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor
        incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
        quis nostrud exercitation ullamco laboris nisi ut
      </p>
    </div>
    <div class="get_bt_main">
      <div class="get_bt"><a href="#">Know More</a></div>
    </div>
  </div>
  <!-- who section end -->
  <!-- projects section start -->

  <!-- projects section end -->

  <!-- copyright section start -->
  <div class="copyright_section">
    <div class="container">
      <div class="social_icon">
        <ul>
          <li>
            <a href="#"><img src="../assets/images/site/fb-icon.png" /></a>
          </li>
          <li>
            <a href="#"><img src="../assets/images/site/twitter-icon.png" /></a>
          </li>
          <li>
            <a href="#"
              ><img src="../assets/images/site/instagram-icon.png"
            /></a>
          </li>
          <li>
            <a href="#"
              ><img src="../assets/images/site/linkedin-icon.png"
            /></a>
          </li>
        </ul>
      </div>
      <p class="copyright_text">
        2020 All Rights Reserved. Design by
        <a href="https://html.design">Free html Templates</a>
      </p>
    </div>
  </div>
</template>
