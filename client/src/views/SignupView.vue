<script setup lang="ts">
async function handleFormSubmit(event) {
  console.log("hi");
  event.preventDefault();

  const data = new FormData(event.target);

  const formJSON = Object.fromEntries(data.entries());
  console.log({ formJSON });
  const response = await fetch(
    "http://localhost:8080/VikaraSetup/api/create/user",
    {
      mode: "cors",
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: `{
    "username":"temp11",
    "password":"temp11",
    "confirmPassword":"temp11",
    "firstName":"temp1",
    "middleName":"temp1",
    "lastName":"temp1",
    "address1":"temp1",
    "address2":"temp1",
    "city":"temp1",
    "state":"temp1",
    "zipcode":"12365",
    "category_id":1001
    }`,
    }
  );
  console.log(response);
  response.json().then((data) => {
    console.log(data);
  });
}
console.log("HEREEEEEEEEEEEE");
const form = document.querySelector("form");
form.addEventListener("submit", handleFormSubmit);
</script>

<style scoped>
/*$primary*/
/*hexcode:  #b69de6*/
/*rgb: rgb(182,157,230);*/

.body {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: calc(100vh - 100px);
  /*background: #007bff;*/
  /*background: linear-gradient(to right, #0062e6, #33aeff);*/
}

.card {
  align-content: center;
  justify-content: center;
}

.card-body {
  background-color: lightgoldenrodyellow;
  text-align: center;
}

.card-body h1 {
  margin-bottom: 10px;
}

.row {
  margin-top: 10px;
  min-width: 300px;
  width: 800px;
  background-color: white;
  border-radius: 10px;
  padding: 10px;
  margin-bottom: 10px;
}

.btn-login {
  font-size: 0.9rem;
  letter-spacing: 0.05rem;
  padding: 0.75rem 1rem;
}

.btn-google {
  color: white !important;
  background-color: #ea4335;
}

.btn-facebook {
  color: white !important;
  background-color: #3b5998;
}

.card-body form {
  display: inline-block;
  width: 500px;
}

.form-floating {
  display: flex;
  justify-content: space-between;
  margin-bottom: 10px;
}

/*.fieldLabel {*/
/*  min-width: 100px;*/
/*  width: 180px;*/
/*  text-align: right;*/
/*}*/

/*.fieldInput {*/
/*  min-width: 100px;*/
/*  width: 245px;*/
/*}*/

/*.fieldInput select {*/
/*  width: inherit;*/
/*}*/
</style>

<template>
  <!-- This snippet uses Font Awesome 5 Free as a dependency. You can download it at fontawesome.io! -->
  <div class="body">
    <!--    <div>-->
    <div class="row">
      <div class="card-body">
        <h1 class="card-title text-center">Register</h1>
        <form>
          <div class="form-floating">
            <div class="fieldLabel">
              <label for="floatingInputUsername">Username</label>
            </div>
            <div class="fieldInput">
              <input
                type="text"
                class="form-control"
                id="floatingInputUsername"
                placeholder="username"
                required
                autofocus
              />
            </div>
          </div>

          <div class="form-floating">
            <div class="fieldLabel">
              <label for="floatingInputEmail">Email address</label>
            </div>
            <div class="field">
              <input
                type="email"
                class="form-control"
                id="floatingInputEmail"
                placeholder="name@example.com"
              />
            </div>
          </div>

          <hr />

          <div class="form-floating">
            <div class="fieldLabel">
              <label for="floatingPassword">Password</label>
            </div>
            <div class="fieldInput">
              <input
                type="password"
                class="form-control"
                id="floatingPassword"
                placeholder="Password"
              />
            </div>
          </div>

          <div class="form-floating">
            <div class="fieldLabel">
              <label for="floatingPasswordConfirm">Confirm Password</label>
            </div>
            <div class="fieldInput">
              <input
                v-model="password"
                type="password"
                class="form-control"
                id="floatingPasswordConfirm"
                placeholder="Confirm Password"
              />
            </div>
          </div>

          <div class="form-floating">
            <div class="fieldLabel">
              <label for="floatingPasswordConfirm">First Name</label>
            </div>
            <div class="fieldInput">
              <input
                type="text"
                class="form-control"
                placeholder="First Name"
              />
            </div>
          </div>
          <div class="form-floating">
            <div class="fieldLabel">
              <label for="floatingPasswordConfirm">Middle Name</label>
            </div>
            <div class="fieldInput">
              <input
                type="text"
                class="form-control"
                placeholder="Middle Name"
              />
            </div>
          </div>
          <div class="form-floating">
            <div class="fieldLabel">
              <label for="floatingPasswordConfirm">Last Name</label>
            </div>
            <div class="fieldInput">
              <input type="text" class="form-control" placeholder="Last Name" />
            </div>
          </div>
          <div class="form-floating">
            <div class="fieldLabel">
              <label for="floatingPasswordConfirm">Address 1</label>
            </div>
            <div class="fieldInput">
              <input type="text" class="form-control" placeholder="Address 1" />
            </div>
          </div>
          <div class="form-floating">
            <div class="fieldLabel">
              <label for="floatingPasswordConfirm">Address 2</label>
            </div>
            <div class="fieldInput">
              <input type="text" class="form-control" placeholder="Address 2" />
            </div>
          </div>
          <div class="form-floating">
            <div class="fieldLabel">
              <label for="floatingPasswordConfirm">City</label>
            </div>
            <div class="fieldInput">
              <input type="text" class="form-control" placeholder="City" />
            </div>
          </div>
          <div class="form-floating">
            <div class="fieldLabel">
              <label for="floatingPasswordConfirm">State</label>
            </div>
            <div class="fieldInput">
              <input type="text" class="form-control" placeholder="State" />
            </div>
          </div>
          <div class="form-floating">
            <div class="fieldLabel">
              <label for="floatingPasswordConfirm">ZipCode</label>
            </div>
            <div class="fieldInput">
              <input type="text" class="form-control" placeholder="ZipCode" />
            </div>
          </div>
          <div class="form-floating">
            <div class="fieldLabel">
              <label for="security question">Security Question</label>
            </div>
            <div class="fieldInput">
              <select id="dropdown">
                <option value="question">Question 1</option>
                <option value="question">Question 2</option>
                <option value="question">Question 3</option>
                <option value="question">Question 4</option>
              </select>
            </div>
          </div>
          <div class="form-floating">
            <div class="fieldInput">
              <input type="text" class="form-control" placeholder="Answer" />
            </div>
          </div>

          <div class="d-grid mb-2">
            <button
              class="btn btn-lg btn-primary btn-login fw-bold text-uppercase"
              type="submit"
            >
              Register
            </button>
          </div>

          <a class="d-block text-center mt-2 small" href="#"
            >Have an account? Sign In</a
          >

          <hr class="my-4" />

          <div class="d-grid mb-2">
            <button
              class="btn btn-lg btn-google btn-login fw-bold text-uppercase"
              type="submit"
            >
              <i class="fab fa-google me-2"></i> Sign up with Google
            </button>
          </div>

          <div class="d-grid">
            <button
              class="btn btn-lg btn-facebook btn-login fw-bold text-uppercase"
              type="submit"
            >
              <i class="fab fa-facebook-f me-2"></i> Sign up with Facebook
            </button>
          </div>
        </form>
      </div>
    </div>
  </div>
  <!--  </div>-->
  <!--  </div>-->
</template>
