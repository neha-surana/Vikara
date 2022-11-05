<script setup lang="ts">
import WhoAreWe from "../components/WhoAreWeSection.vue";
import SlideCard from "../components/SlideCard.vue";
</script>

<!--&lt;!&ndash;<script src="js/jquery.min.js"></script>&ndash;&gt;-->
<!--&lt;!&ndash;<script src="js/popper.min.js"></script>&ndash;&gt;-->
<!--&lt;!&ndash;<script src="js/bootstrap.bundle.min.js"></script>&ndash;&gt;-->
<!--&lt;!&ndash;<script src="js/jquery-3.0.0.min.js"></script>&ndash;&gt;-->
<!--&lt;!&ndash;<script src="js/plugin.js"></script>&ndash;&gt;-->
<!--&lt;!&ndash;&lt;!&ndash; sidebar &ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>&ndash;&gt;-->
<!--&lt;!&ndash;<script src="js/custom.js"></script>&ndash;&gt;-->
<!--&lt;!&ndash;&lt;!&ndash; javascript &ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;<script src="js/owl.carousel.js"></script>&ndash;&gt;-->
<!--<script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>-->

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
    <!--    <SlideCard></SlideCard>-->
    <!-- header section end -->
    <!-- banner section start -->
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
              <!--                     <img src="../../assets/images/vikara/site/mental-health-1.jpg">-->
              <div class="features-image">
                <img src="../assets/images/vikara/mood-survey-features-1.png" />
              </div>
              <div class="contact_bt_main">
                <div class="contact_bt">
                  <router-link to="/survey">Take Survey</router-link>
                  <!--                  <router-link to="/speechtotext">Take Survey</router-link>-->
                </div>
              </div>
            </div>
            <div class="carousel-item">
              <h3 class="furniture_text">
                Explore a handful of Soulful Products
              </h3>
              <p class="there_text">
                We offer a little retail therapy right here at Vikara! Research
                has shown that making shopping decisions can help reinforce a
                sense of personal control over our environment and help in
                gaining an emotional boost. We have partnered with local vendors
                who provide high quality, sustainable and environment friendly
                products which will definitely soothe your mind, heart and soul!
              </p>
              <div class="features-image">
                <img src="../assets/images/vikara/products-features-1.png" />
              </div>
              <div class="contact_bt_main">
                <div class="contact_bt">
                  <a href="contact.html">Products</a>
                </div>
              </div>
            </div>
            <div class="carousel-item">
              <h1 class="furniture_text">
                A secure place to express your thoughts
              </h1>
              <p class="there_text">
                We offer you a place to share your thoughts and feelings. You
                can maintain your own mood journal, read motivational blogs or
                share your experiences with other users on our platform. We have
                a strong community of users who support each other right here at
                Vikara. We have an aggregation of resources for almost
                everything you may need to better understand mental health.
              </p>
              <div class="features-image">
                <img src="../assets/images/vikara/blogs-features.png" />
              </div>
              <div class="contact_bt_main">
                <div class="contact_bt"><a href="contact.html">Blogs</a></div>
              </div>
            </div>
            <div class="carousel-item">
              <h1 class="furniture_text">Indulge yourself in fun events</h1>
              <p class="there_text">
                There’s nothing wrong with setting it aside temporarily to focus
                on something that makes you feel good instead. Give your mood a
                little jump start, explore a range of fun events taking place
                near you! Book events right here at Vikara.
              </p>
              <div class="features-image">
                <img src="../assets/images/vikara/events-features-1.png" />
              </div>
              <div class="contact_bt_main">
                <div class="contact_bt"><a href="contact.html">Events</a></div>
              </div>
            </div>
            <div class="carousel-item">
              <h1 class="furniture_text">Videos to calm yourself instantly</h1>
              <p class="there_text">
                If you are looking for a way to relax, unwind, and clear your
                mind. We will provide you a personalized list of relaxing videos
                to help you calm yourself.
              </p>
              <div class="features-image">
                <img src="../assets/images/vikara/video-feature.png" />
              </div>
              <div class="contact_bt_main">
                <div class="contact_bt"><a href="contact.html">Videos</a></div>
              </div>
            </div>
          </div>
          <a
            class="carousel-control-prev"
            href="#costum_slider"
            role="button"
            data-slide="prev"
          >
            <i class=""><img src="../assets/images/vikara/left-arrow.png" /></i>
          </a>
          <a
            class="carousel-control-next"
            href="#costum_slider"
            role="button"
            data-slide="next"
          >
            <i class=""
              ><img src="../assets/images/vikara/right-arrow.png"
            /></i>
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
                "Mental health…is not a destination, but a process. It’s about
                how you drive, not where you’re going." — Noam Shpancer
              </p>
              <div class="clients_section2 layout_padding">
                <div class="client_1">
                  <div class="row">
                    <div class="col-sm-3">
                      <div class="blog-image">
                        <img
                          src="../assets/images/vikara/mental-health-1.jpg"
                        />
                      </div>
                    </div>
                    <div class="col-sm-9">
                      <h1 class="blog_title">The Happiness of Not Thinking</h1>
                      <p class="blog_text">
                        Our culture overvalues thinking. Thought should be a
                        tool that we can pick up when we need it and then set
                        down again.
                      </p>
                    </div>
                  </div>
                </div>
                <div class="client_2">
                  <div class="row">
                    <div class="col-sm-3">
                      <div class="blog-image">
                        <img
                          src="../assets/images/vikara/mental-health-2.png"
                        />
                      </div>
                    </div>
                    <div class="col-sm-9">
                      <h1 class="blog_title">
                        The Importance of Not Being Who You Think You Are
                      </h1>
                      <p class="blog_text">
                        Are you feeling psychologically or physically
                        distressed? A little ego-dissolution could go a long
                        way.
                      </p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="carousel-item">
              <h1 class="client_text">Featured Blogs</h1>
              <p class="ipsum_text">
                "Vulnerability sounds like truth and feels like courage. Truth
                and courage aren’t always comfortable, but they're never
                weakness." — Brené Brown
              </p>
              <div class="clients_section2 layout_padding">
                <div class="client_1">
                  <div class="row">
                    <div class="col-sm-3">
                      <div class="blog-image">
                        <img
                          src="../assets/images/vikara/mental-health-3.png"
                        />
                      </div>
                    </div>
                    <div class="col-sm-9">
                      <h1 class="blog_title">
                        Here’s How You Can Overcome Insomnia
                      </h1>
                      <p class="blog_text">
                        The importance of getting enough good-quality sleep
                        cannot be understated—it is a biological necessity, just
                        like food and water.
                      </p>
                    </div>
                  </div>
                </div>
                <div class="client_2">
                  <div class="row">
                    <div class="col-sm-3">
                      <div class="blog-image">
                        <img
                          src="../assets/images/vikara/mental-health-4.jpg"
                        />
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
                really have to love yourself to get anything done in this
                world." – Lucille Ball
              </p>
              <div class="clients_section2 layout_padding">
                <div class="client_1">
                  <div class="row">
                    <div class="col-sm-3">
                      <div class="blog-image">
                        <img
                          src="../assets/images/vikara/mental-health-5.png"
                        />
                      </div>
                    </div>
                    <div class="col-sm-9">
                      <h1 class="blog_title">
                        The Science of Evolutionary Psychology
                      </h1>
                      <p class="blog_text">
                        Evolutionary psychology seeks to explain how our
                        emotions and other aspects of being human served as
                        advantages to our ancestors.
                      </p>
                    </div>
                  </div>
                </div>
                <div class="client_2">
                  <div class="row">
                    <div class="col-sm-3">
                      <div class="blog-image">
                        <img
                          src="../assets/images/vikara/mental-health-6.jpg"
                        />
                      </div>
                    </div>
                    <div class="col-sm-9">
                      <h1 class="blog_title">
                        How I am learning to Love Myself
                      </h1>
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
    <WhoAreWe></WhoAreWe>
    <!-- client section end -->
    <!-- who section start -->
    <!--    <div class="who_section layout_padding">-->
    <!--      <div class="container">-->
    <!--        <h1 class="who_taital">who we are ?</h1>-->
    <!--        <p class="lorem_ipsum_text">-->
    <!--          We at Vikara aim towards fostering positivity and productivity amongst-->
    <!--          our users by providing them with a one-stop platform for their-->
    <!--          emotional and mental well-being. We want to help our users manage-->
    <!--          their emotions and help them get a better sense of awareness about-->
    <!--          their mental health so that we can provide them with the best-->
    <!--          resources to make them feel better again.-->
    <!--        </p>-->
    <!--      </div>-->
    <!--      <div class="get_bt_main">-->
    <!--        <div class="get_bt"><a href="#">Know More</a></div>-->
    <!--      </div>-->
    <!--    </div>-->
    <!-- who section end -->
    <!-- projects section start -->

    <!-- projects section end -->

    <!-- copyright section start -->
    <!--    <div class="copyright_section">-->
    <!--      <div class="container">-->
    <!--        <div class="social_icon">-->
    <!--          <ul>-->
    <!--            <li>-->
    <!--              <a href="#"><img src="../assets/images/vikara/fb-icon.png" /></a>-->
    <!--            </li>-->
    <!--            <li>-->
    <!--              <a href="#"-->
    <!--                ><img src="../assets/images/vikara/twitter-icon.png"-->
    <!--              /></a>-->
    <!--            </li>-->
    <!--            <li>-->
    <!--              <a href="#"-->
    <!--                ><img src="../assets/images/vikara/instagram-icon.png"-->
    <!--              /></a>-->
    <!--            </li>-->
    <!--            <li>-->
    <!--              <a href="#"-->
    <!--                ><img src="../assets/images/vikara/linkedin-icon.png"-->
    <!--              /></a>-->
    <!--            </li>-->
    <!--          </ul>-->
    <!--        </div>-->
    <!--        <p class="copyright_text">2022 All Rights Reserved. Vikara</p>-->
    <!--      </div>-->
    <!--    </div>-->
  </div>
  <!-- copyright section end -->
  <!-- Javascript files-->
</template>
