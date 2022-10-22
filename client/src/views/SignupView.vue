<script setup lang="ts"></script>

<style scoped>
/*$primary*/
/*hexcode:  #b69de6*/
/*rgb: rgb(182,157,230);*/

.body {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: calc(100vh - 100px);
  background: #007bff;
  background: linear-gradient(to right, #0062e6, #33aeff);
}

.card {
  align-content: center;
  justify-content: center;
}

.card-body {
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

.card-img-left {
  width: 45%;
  /* Link to your background image using in the property below! */
  background: scroll center
    url("https://source.unsplash.com/WEQbe2jBg40/414x512");
  background-size: cover;
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
  /*justify-content: space-between;*/
  display: inline-block;
  width: 500px;
}

.form-floating {
  display: flex;
  justify-content: space-between;
  margin-bottom: 10px;
}

.fieldLabel {
  min-width: 100px;
  width: 180px;
  text-align: right;
}

.fieldInput {
  min-width: 100px;
  width: 245px;
}

.fieldInput input {
  width: inherit;
}

/*.form-floating label {*/
/*  margin-right: 10px;*/
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
              <label for="floatingPasswordConfirm">Security Question</label>
            </div>
            <div class="fieldInput">
              <input
                type="text"
                class="form-control"
                placeholder="security question"
              />
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
