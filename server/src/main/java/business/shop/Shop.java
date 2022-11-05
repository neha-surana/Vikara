package business.shop;

public class Shop {

	/*
	 * TODO: Create private fields corresponding to the fields in the
	 * book table of your database. Generate a constructor that
	 * uses those fields. Generate getter methods for those fields,
	 * and generate a toString method that uses those fields.
	 */

	private long item_id;
	private String product_name, description;
	private int price, rating;

	private boolean is_public, is_featured;

	private long itemCategory_id;

	public Shop(long item_id, String product_name, String description, int price, int rating, boolean is_public, boolean is_featured, long categoryId) {
		this.item_id = item_id;
		this.product_name = product_name;
		this.description = description;
		this.price = price;
		this.rating = rating;
		this.is_public = is_public;
		this.is_featured = is_featured;
		this.itemCategory_id = itemCategory_id;
	}

	public long getItem_id() {
		return item_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public String getDescription() {
		return description;
	}

	public int getPrice() {
		return price;
	}

	public int getRating() {
		return rating;
	}

	public boolean isIs_public() {
		return is_public;
	}

	public void setIs_public(boolean is_public) {
		this.is_public = is_public;
	}

	public boolean isIs_featured() {
		return is_featured;
	}

	public void setIs_featured(boolean is_featured) {
		this.is_featured = is_featured;
	}

	public long getItemCategory_id() {
		return itemCategory_id;
	}

	public void setItemCategory_id(long itemCategory_id) {
		this.itemCategory_id = itemCategory_id;
	}

	@Override
	public String toString() {
		return "Item{" +
				"item_id=" + item_id +
				", product_name='" + product_name + '\'' +
				", description='" + description + '\'' +
				", price=" + price +
				", rating=" + rating +
				", is_public=" + is_public +
				", is_featured=" + is_featured +
				", itemCategory_id=" + itemCategory_id +
				'}';
	}
}
