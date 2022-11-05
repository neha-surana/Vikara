<script setup lang="ts">
// const login = document.querySelector(".login");
// login.addEventListener("click", handleLogin);
//
// async function handleLogin(event) {
//   var usernameInput = document.getElementById("username").value.trim();
//
//   var passInput = document.getElementById("password").value.trim();
//
//   if (usernameInput == "") {
//     alert("Username field can not be empty!");
//   } else if (await !doesUsernameAlreadyExist()) {
//     alert("no such user exists! Try signing up first");
//   } else if (passInput == "") {
//     alert("Password field can not be empty!");
//   } else {
//     try {
//       console.log("INVOKING CREATE USER");
//       const response = await getUser();
//       console.log(response.password);
//       if (response.password == passInput) {
//         alert("Login Successful");
//         window.location.replace(
//           "http://localhost:8080/VikaraSetup/survey.html"
//         );
//       } else alert("Invalid username or password");
//     } catch (e) {
//       console.log(e);
//     }
//   }
// }
//
// async function doesUsernameAlreadyExist() {
//   console.log("Inside check username!!\n");
//   console.log(
//     "http://localhost:8080/VikaraSetup/api/check/user/" +
//       document.getElementById("username").value.trim()
//   );
//   const response = await fetch(
//     "http://localhost:8080/VikaraSetup/api/check/user/" +
//       document.getElementById("username").value.trim()
//   ).then((response) => response.json());
//   console.log("After check function call!!\n");
//   console.log("JSON string: " + JSON.stringify(response));
//   console.log(response);
//   return response.exitsts;
// }
//
// async function getUser() {
//   const response = await fetch(
//     "http://localhost:8080/VikaraSetup/api/user/username/" +
//       document.getElementById("username").value.trim()
//   ).then((response) => response.json());
//   console.log("JSON string: " + JSON.stringify(response));
//   console.log(response);
//   return response;
// }
</script>

<style scoped>
html,
body {
  height: 100vh;
  width: 100vw;
  margin: 0 0;
  display: flex;
  align-items: flex-start;
  justify-content: flex-start;
  background: #f3f2f2;
}
h4 {
  font-size: 24px;
  font-weight: 600;
  color: #000;
  opacity: 0.85;
}
label {
  font-size: 12.5px;
  color: #000;
  opacity: 0.8;
  font-weight: 400;
}

.login-Image {
  height: 350px;
  width: 300px;
  margin-left: 30px;
  margin-top: 90px;
}
</style>

<template>
  <div class="contact_section layout_padding">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <h1 class="contact_text">Welcome to Vikara</h1>
          <div class="login-section">
            <input
              type="text"
              class="input-button"
              id="username"
              placeholder="User Name"
              name="UserName"
            />

            <input
              type="password"
              class="input-button"
              id="password"
              placeholder="Password"
              name="Name"
            />
            <div class="submit-row">
              <router-link to="/signup">
                <button class="sign-up" type="submit">Signup</button>
              </router-link>
              <button class="sign-in">Login</button>
            </div>
          </div>
        </div>
        <div class="col-md-6">
          <div class="login-Image">
            <img src="../assets/images/vikara/login-image.jpg" />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
