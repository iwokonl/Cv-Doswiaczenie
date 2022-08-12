namespace DPS.Orders.Core.Entities.Products
{
    public class Product : BaseEntity
    {
        public string Name { get; set; }
        public double Price { get; set; }
        public double Quantity { get; set; }
    }
}
