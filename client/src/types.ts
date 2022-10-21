// Contains all the custom types we want to use for our application
export interface BookItem {
  bookId: number;
  title: string;
  author: string;
  description: string;
  price: number;
  rating: number;
  isPublic: boolean;
  isFeatured: boolean;
}

export interface CategoryItem {
  categoryId: number;
  name: string;
}
