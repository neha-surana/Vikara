import { defineStore } from "pinia";
import { ItemCategory } from "@/types";
import { apiUrl } from "@/services/ApiService";

export const useCategoryStore = defineStore("CategoryStore", {
  state: () => ({
    categoryList: [] as ItemCategory[],
  }),
  actions: {
    async fetchCategories() {
      const url = apiUrl + "categories/";
      console.log("API URL: " + apiUrl);
      this.categoryList = await fetch(url).then((response) => response.json());
      console.log(
        "This is the category List: " + JSON.stringify(this.categoryList)
      );
    },
  },
  // getters
});
