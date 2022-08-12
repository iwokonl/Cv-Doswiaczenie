using System.ComponentModel;

namespace DPS.Orders.Desktop.Models.Products
{
    public class ProductModel
    { 
        [Browsable(false)]
        public int Id { get; set; }

        [Browsable(false)]
        public int LocalId { get; set; }
        public string Name { get; set; }
        public int Quantity { get; set; }
        public double Price { get; set; }
       
        [Browsable(false)]
        public bool WasEdited { get; set; }
        public ProductModel Clone()
        {
            return (ProductModel)this.MemberwiseClone();
        }
    }
}
