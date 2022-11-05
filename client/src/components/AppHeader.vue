<script setup lang="ts"></script>

<style scoped>
.container {
  max-width: 1640px;
}

.nav-link {
  display: block;
  padding: 0.5rem 1rem;
  color: black;
}
.nav-item {
  position: relative;
  padding: 30px;
}

.header_section {
  width: 100%;
  float: left;
  /*   background-image: url(../images/header-bg.png);*/
  background: white;
  height: auto;
  background-size: 100%;
}
.bg-light {
  background-color: transparent !important;
}
.logo {
  width: 25%;
  float: left;
}
</style>

<template>
  <header class="container">
    <div class="header_section">
      <div class="container-fluid">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <div class="logo">
            <router-link to="/"
              ><img
                class="logo-img"
                src="../assets/images/vikara/vikara-logo.png"
            /></router-link>
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
                <router-link class="nav-link" to="/login">Helpline</router-link>
              </li>
              <li class="nav-item">
                <router-link class="nav-link" to="/itemCategory/Insomnia"
                  >Products</router-link
                >
              </li>
              <li class="nav-item">
                <router-link class="nav-link" to="/aboutus">About</router-link>
              </li>
              <li class="nav-item">
                <router-link class="nav-link" to="/login">Login</router-link>
              </li>
            </ul>
          </div>
        </nav>
      </div>
    </div>
  </header>
</template>
