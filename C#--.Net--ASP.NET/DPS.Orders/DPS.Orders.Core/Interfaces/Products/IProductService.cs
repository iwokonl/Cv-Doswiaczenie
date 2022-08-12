using DPS.Orders.Core.Entities.Products;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace DPS.Orders.Core.Services.Products
{
    public interface IProductService
    {
        Task<List<Product>> GetAll();
        Task<List<Product>> UpdateMany(List<Product> products);
        Task<List<Product>> AddRange(List<Product> products);
        Task DeleteRange(List<Product> products);
    }
}
