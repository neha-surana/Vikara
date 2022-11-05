import { defineStore } from "pinia";
// import { BookItem } from "@/types";
import { ShopItem } from "@/types";
import { apiUrl } from "@/services/ApiService";
import { useCategoryStore } from "@/stores/CategoryStore";

export const useItemStore = defineStore("ItemStore", {
  state: () => ({
    itemList: [] as ShopItem[],
  }),
  actions: {
    async fetchItems(categoryName: string) {
      console.log("This is the required category: " + categoryName);
      const categoryStore = useCategoryStore();
      const selectedCategory =
        categoryStore.categoryList?.find(
          (category) => category.name === categoryName
        ) || categoryStore.categoryList[0];
      console.log("This is the selected Category: " + selectedCategory.name);
      //localStorage.setItem("PREV_CATEGORY", selectedCategory.name);
      const url =
        apiUrl + "categories/name/" + selectedCategory.name + "/items/";
      console.log("API URL: " + url);
      this.itemList = await fetch(url).then((response) => response.json());
      console.log("Hereeee" + JSON.stringify(this.itemList));
      console.log(typeof this.itemList);
    },
  },
  // getters
});

//
// Hereeee[{"item_id":1013,
//   "product_name":"Kindle Paperwhite",
//   "description":"Purpose-built for reading – With a flush-front design and 300 ppi glare-free display that reads like real paper, even in bright
//   "price":19,
//   "rating":0,
//   "is_public":true,
//   "is_featured":false,
//   "itemCategory_id":0},
