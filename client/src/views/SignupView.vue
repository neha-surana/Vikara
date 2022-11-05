<script>
import router from "../router";
export default {
  name: "SurveyView",
  data() {
    return {
      posts: {
        gender: "1",
        country: "1",
      },
    };
  },
  methods: {
    async handleFormSubmit(event) {
      let usernameInput = document
        .getElementById("floatingInputUsername")
        .value.trim();
      let useremailInput = document
        .getElementById("floatingInputEmail")
        .value.trim();
      let passInput = document.getElementById("floatingPassword").value.trim();
      console.log("password: " + passInput);
      var confirmPassInput = document
        .getElementById("floatingPasswordConfirm")
        .value.trim();
      console.log("confirm password: " + confirmPassInput);
      var address = document.getElementById("address").value.trim();
      var state = document.getElementById("state").value.trim();
      var country = document.getElementById("country").value.trim();
      var zipcode = document.getElementById("zipcode").value.trim();
      var emailFormat = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
      var passwordFormat = "^(.{0,7}|[^0-9]|[^A-Z]|[^a-z]|[a-zA-Z0-9])$";

      event.preventDefault();
      if (usernameInput == "") {
        alert("Username field can not be empty!");
      } else if (await doesUsernameAlreadyExist()) {
        alert(
          "Username " +
            usernameInput +
            " already exists!! Please enter another username."
        );
      } else if (useremailInput == "") {
        alert("Email field can not be empty!");
      } else if (!useremailInput.match(emailFormat)) {
        alert("Please enter a valid email!");
      } else if (passInput == "") {
        alert("Password field can not be empty!");
      } else if (!passInput.match(passwordFormat)) {
        alert(
          "Password field must contain atleast 1 letter, 1 number and minimum 8 characters!! "
        );
      } else if (passInput != confirmPassInput) {
        alert("Confirm Password field must match Password field!!");
      } else if (address == "") {
        alert("Address field can not be empty!");
      } else if (state == "") {
        alert("State field can not be empty!");
      } else if (country == "") {
        alert("Country field can not be empty!");
      } else if (zipcode == "") {
        alert("Zipcode field can not be empty!");
      } else {
        const data = new FormData(event.target);

        const formJSON = Object.fromEntries(data.entries());
        console.log("Printing form values");
        console.log({ formJSON });
        console.log(JSON.stringify(formJSON));

        console.log("INVOKING CREATE USER");

        const response = await fetch(
          "http://localhost:8080/VikaraSetup/api/create/user",
          {
            mode: "cors",
            method: "POST",
            headers: {
              Accept: "application/json",
              "Content-Type": "application/json",
            },
            body: JSON.stringify(formJSON),
          }
        );
        console.log(response);
        if (response.ok) {
          sessionStorage.setItem("user", "abcd");
          router.push("/login");
        } else console.log("There is some error in the field");

        response.json().then((data) => {
          console.log(data);
        });
      }
    },
  },
};

async function doesUsernameAlreadyExist() {
  console.log("IN FUNCTION");
  console.log(
    "http://localhost:8080/VikaraSetup/api/check/user/" +
      document.getElementById("floatingInputUsername").value.trim()
  );

  const response = await fetch(
    "http://localhost:8080/VikaraSetup/api/check/user/" +
      document.getElementById("floatingInputUsername").value.trim()
  ).then((response) => response.json());
  console.log("JSON string: " + JSON.stringify(response));
  console.log(response);
  return response.exitsts;
}
</script>

<style scoped></style>

<template>
  <div class="contact_section layout_padding">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <h1 class="contact_text">Welcome to Vikara</h1>
          <form id="signup" @submit="handleFormSubmit" method="post">
            <div class="mail_sectin">
              <input
                type="text"
                class="input-button"
                name="username"
                id="floatingInputUsername"
                placeholder="UserName"
                required
                autofocus
              />
              <input
                type="email"
                class="input-button"
                placeholder="Email Address"
                name="email"
                id="floatingInputEmail"
                required
                autofocus
              />
              <input
                type="password"
                class="input-button"
                name="password"
                id="floatingPassword"
                placeholder="Password"
                required
                autofocus
              />
              <input
                type="password"
                class="input-button"
                name="confirm_password"
                id="floatingPasswordConfirm"
                placeholder="Confirm Password"
                required
                autofocus
              />
              <input
                type="text"
                class="input-button"
                name="address"
                id="address"
                placeholder="Address"
              />
              <input
                type="text"
                class="input-button"
                name="state"
                id="state"
                placeholder="State"
              />
              <input
                type="text"
                class="input-button"
                name="country"
                id="country"
                placeholder="Country"
              />
              <input
                type="text"
                class="input-button"
                name="zipcode"
                id="zipcode"
                placeholder="Zipcode"
              />
              <div class="submit-row">
                <router-link to="/login">
                  <button class="sign-in">Back to Login</button>
                </router-link>
                <button class="sign-up" type="submit">Signup</button>
              </div>
            </div>
          </form>
        </div>
        <div class="col-md-6">
          <div class="loginImg">
            <img src="../assets/images/vikara/side_login.jpg" />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
