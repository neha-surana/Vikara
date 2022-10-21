<script>
export default {
  name: "SurveyView",
};
</script>

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
}

.field-container {
  display: flex;
  justify-content: space-between;
}
</style>

<template>
  <div class="survey-page">
    <div class="survey-fields">
      <div class="field-container"></div>
    </div>
  </div>
</template>
