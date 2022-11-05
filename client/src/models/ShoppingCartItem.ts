// import { BookItem } from "@/types";
import { ShopItem } from "@/types";

export class ShoppingCartItem {
  readonly product: ShopItem;
  quantity: number;

  constructor(theItem: ShopItem) {
    this.product = theItem;
    this.quantity = 1;
  }
}
