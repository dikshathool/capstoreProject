export class Product {
    constructor(
    public productId: number,
    public productName: string,
    public productPrice: string,
    public productQuantity: string,
    public productCategory: string,
    public productImage: string,
    public productDiscount: number,
    public productDiscountExpiryDate: string,
    public productBrandName: string,
    public email: string
    ) { }
}
