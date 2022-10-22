<script></script>

<style scoped>
.survey-page {
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}

.survey-fields {
  align-self: center;
  margin: 10px;
  width: 800px;
  min-width: 600px;
}

.field-container {
  display: flex;
  justify-content: space-between;
}
body {
  font-family: "Anaheim";
  font-size: 1.2em;
}

#outside {
  background-color: lightgoldenrodyellow;
  padding-top: 25px;
  padding-bottom: 25px;
}

h1 {
  font-size: 1.5em;
  text-align: center;
  text-transform: capitalize;
}

form {
  /* Just to center the form on the page */
  margin: 0 auto;
  width: 70%;
  /* To see the limits of the form */
  padding: 1em;
  border: 1px solid #ccc;
  border-radius: 1em;
}
#survey-form {
  background-color: white;
}

fieldset {
  border: 1px solid lightgray;
  margin: 10px;
}

legend {
  font-weight: 700;
}

#number {
  width: 150px;
}

div + div {
  margin-top: 1em;
}

input,
textarea {
  width: 200px;
  border: 1px solid #999;
}

input:focus,
textarea:focus {
  border-color: OrangeRed;
}

textarea {
  vertical-align: top;
  height: 5em;
  resize: vertical;
}

.button {
  padding-left: 90px;
}

button {
  margin: 0.5em;
  font-size: 1em;
  text-transform: capitalize;
  background-color: red;
  color: white;
  border: none;
  padding: 5px;
  border-radius: 2px;
}

#submitbutton {
  display: flex;
  justify-content: center;
}
</style>

<template>
  <div class="survey-page">
    <div class="survey-fields">
      <div class="field-container"></div>
      <div id="outside">
        <form id="survey-form" action="/my-handling-form-page" method="post">
          <h1 id="title">Tell us something about you!!</h1>
          <!--          <p id="description">-->
          <!--            <b>Note:</b> Form is to be completed at least 21 days prior to date-->
          <!--          </p>-->

          <!-- ------------------Personal Details---------------------------- -->
          <fieldset>
            <!-- groups of widgets that share the same purpose, for styling and semantic purposes -->
            <legend>Personal Details</legend>
            <!-- formally describes the purpose of the fieldset it is included inside. -->
            <div>
              <label id="name-label" for="age">Age:</label>
              <input
                type="text"
                required
                id="age"
                name="age"
                placeholder="Enter age here"
              />
            </div>
            <!--            <div>-->
            <!--              <label for="address-label">Address:</label>-->
            <!--              <input-->
            <!--                type="Address"-->
            <!--                id="address"-->
            <!--                name="Address"-->
            <!--                placeholder="Enter address here"-->
            <!--              />-->
            <!--            </div>-->
            <!--            <div>-->
            <!--              <label id="email-label" for="Email">Email:</label>-->
            <!--              <input-->
            <!--                type="email"-->
            <!--                required-->
            <!--                id="email"-->
            <!--                name="user_email"-->
            <!--                placeholder="Enter email here"-->
            <!--              />-->
            <!--            </div>-->
            <!--            <div>-->
            <!--              <label id="number-label" for="phone">Phone Number:</label>-->
            <!--              <input-->
            <!--                type="number"-->
            <!--                id="number"-->
            <!--                name="user_name"-->
            <!--                placeholder="Enter 10 digit number"-->
            <!--                min="1"-->
            <!--                max="9"-->
            <!--              />-->
            <!--            </div>-->
            <!--            <div>-->
            <!--              <label id="iq-label" for="iq">IQ:</label>-->
            <!--              <input-->
            <!--                type="number"-->
            <!--                id="iq"-->
            <!--                name="iq"-->
            <!--                placeholder="Enter IQ here"-->
            <!--              />-->
            <!--            </div>-->

            <!-- ------------------Radio Buttons-------------------------------- -->
            <div>
              <label for="Gender">Gender</label>
              <p>
                <input type="radio" name="gender" value="male" checked />
                Male<br />
                <input type="radio" name="gender" value="female" /> Female<br />
                <input type="radio" name="gender" value="other" /> Other
              </p>
            </div>
            <div>
              <label for="Remote work">Remote Work</label>
              <p>
                <input type="radio" name="workmodel" value="male" checked />
                Yes<br />
                <input type="radio" name="workmodel" value="female" /> No<br />
              </p>
            </div>
            <div>
              <label for="Tech Company">Tech Company</label>
              <p>
                <input type="radio" name="company" value="male" checked />
                Yes<br />
                <input type="radio" name="company" value="female" /> No<br />
              </p>
            </div>
            <!--            <label for="date-label">Date of Proposed Outing:</label>-->
            <div>
              <label for="Family History">Family History</label>
              <p>
                <input type="radio" name="history" value="male" checked />
                Yes<br />
                <input type="radio" name="history" value="female" /> No<br />
              </p>
            </div>
            <div>
              <label for="Mental vs Physical">Mental vs Physical</label>
              <p>
                <input type="radio" name="conditionType" value="male" checked />
                Mental<br />
                <input type="radio" name="conditionType" value="female" />
                Physical<br />
              </p>
            </div>
            <!--            <input type="date" name="bday" />-->
          </fieldset>
          <!-- ------------------Checkboxes-------------------------------- -->
          <fieldset>
            <!--            <label for="Gender">Check All That Apply</label>-->
            <!--            <p>-->
            <!--              <input type="checkbox" name="tattoo" value="tattoo" /> I have-->
            <!--              tattoos and/or piercings<br />-->
            <!--              <input type="checkbox" name="age" value="Car" /> I am more than 2-->
            <!--              years older than my daughter<br />-->
            <!--              <input type="checkbox" name="car" value="car" /> I own a panel van-->
            <!--              or V8 ute<br />-->
            <!--              <input type="checkbox" name="work" value="work" checked /> I work-->
            <!--              full-time<br />-->
            <!--              <input type="checkbox" name="rich" value="rich" checked /> My-->
            <!--              parents are rich<br />-->
            <!--              <input type="checkbox" name="loc" value="loc" checked /> Is the-->
            <!--              date at a well lit public location<br />-->
            <!--            </p>-->
            <div>
              <label id="benefits" for="age">Benefits</label>
              <input
                type="text"
                required
                name="benefits"
                placeholder="Enter benefits here"
              />
            </div>
            <div>
              <label id="careOptions" for="age">Care Options</label>
              <input
                type="text"
                required
                name="careoptions"
                placeholder="Enter care options here"
              />
            </div>
            <div>
              <label id="wellProgram" for="age">Well Program</label>
              <input
                type="text"
                required
                name="well program"
                placeholder="Enter Wellness Programs here"
              />
            </div>
            <div>
              <label id="seekHelp" for="age">Seek Help</label>
              <input
                type="text"
                required
                name="seek help"
                placeholder="Seek Help"
              />
            </div>
            <div>
              <label id="leave" for="age">Leave</label>
              <input type="text" required name="leave" placeholder="leave" />
            </div>
            <div>
              <label id="coworkers" for="age">Co Workers</label>
              <input
                type="text"
                required
                name="co workers"
                placeholder="Co workers"
              />
            </div>
            <div>
              <label id="supervisor" for="age">Supervisor</label>
              <input
                type="text"
                required
                name="supervisor"
                placeholder="Supervisor"
              />
            </div>
          </fieldset>

          <!-- -----------------Dropdown menus--------------------------------- -->

          <!--          <fieldset>-->
          <!--            <div>-->
          <!--              <label for="politics">Political Persuasion:</label>-->
          <!--              <select id="dropdown">-->
          <!--                <option value="left">Left Wing</option>-->
          <!--                <option value="right">Right Wing</option>-->
          <!--                <option value="conservative">Conservative</option>-->
          <!--                <option value="nazi">Nazi</option>-->
          <!--              </select>-->

          <!--              <label for="politics">Education Level Completed:</label>-->
          <!--              <select id="dropdown2">-->
          <!--                <option value="University">University</option>-->
          <!--                <option value="College">College</option>-->
          <!--                <option value="Secondary">High School</option>-->
          <!--                <option value="None">None</option>-->
          <!--              </select>-->
          <!--            </div>-->
          <!--          </fieldset>-->

          <!-- --------------------Text Areas------------------------------ -->

          <!--          <fieldset>-->
          <!--            <legend>Essay Section</legend>-->
          <!--            <div>-->
          <!--              <label for="msg"></label>-->
          <!--              <p>-->
          <!--                In 50 words or more explain why you want to date my daughter-->
          <!--              </p>-->
          <!--              <textarea-->
          <!--                id="msg"-->
          <!--                name="user_message"-->
          <!--                rows="4"-->
          <!--                cols="50"-->
          <!--                placeholder="Enter Text Here"-->
          <!--              ></textarea>-->
          <!--            </div>-->
          <!--            <div>-->
          <!--              <label for="msg"-->
          <!--                >Please upload contact details for 2 references</label-->
          <!--              ><br />-->
          <!--              <textarea-->
          <!--                id="msg2"-->
          <!--                name="user_message"-->
          <!--                rows="4"-->
          <!--                cols="50"-->
          <!--                placeholder="Enter Text Here"-->
          <!--              ></textarea>-->
          <!--            </div>-->
          <!--            <p>-->
          <!--              Upload Police Clearance Certificate, Bank Statement and Medical-->
          <!--              Certifiates here: <button>Attach Files</button>-->
          <!--            </p>-->
          <!--          </fieldset>-->

          <div id="submitbutton">
            <button type="submit" id="submit">Submit</button>
          </div>
        </form>
      </div>
    </div>
  </div>

  <!--  <script src="https://cdn.freecodecamp.org/testable-projects-fcc/v1/bundle.js"></script>-->
  <!-- head - Googlefonts link -->

  <!-- https://developer.mozilla.org/en-US/docs/Learn/HTML/Forms/Form_validation -->
</template>
