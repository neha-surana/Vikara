// Contains all the custom types we want to use for our application
// export interface BookItem {
//   bookId: number;
//   title: string;
//   author: string;
//   price: number;
//   isPublic: boolean;
//   isFeatured: boolean;
//   rating: number;
//   description: string;
// }
//
// export interface CategoryItem {
//   categoryId: number;
//   name: string;
// }

export interface ShopItem {
  item_id: number;
  product_name: string;
  description: string;
  price: number;
  rating: number;
  is_public: boolean;
  is_featured: boolean;
}

export interface ItemCategory {
  itemCategory_id: number;
  name: string;
}
