class Product {
    int id;
    int price;
    int discount;
    Product(int id, int price, int discount) {
        this.id = id;
        this.price = price;
        this.discount = discount;
    }
    int getDiscountedPrice() {
        return price - (price * discount / 100);
    }
}

