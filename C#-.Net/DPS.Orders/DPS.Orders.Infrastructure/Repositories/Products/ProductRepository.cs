using DPS.Orders.Core.Entities.Products;
using DPS.Orders.Infrastructure.Repositories.Data;
using DPS.Orders.Core.Interfaces.Products;

namespace DPS.Orders.Infrastructure.Repositories.Products
{
    public class ProductRepository : Repository<Product>, IProductRepository
    {
        public ProductRepository(AppDbContext appDbContext) : base(appDbContext)
        {

        }
    }
}
