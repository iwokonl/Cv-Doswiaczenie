using DPS.Orders.Core.Entities.Products;
using DPS.Orders.Core.Interfaces.Products;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace DPS.Orders.Core.Services.Products
{
    public class ProductService : IProductService
    {
        private readonly IProductRepository _productRepository;

        public ProductService(IProductRepository productRepository)
        {
            _productRepository = productRepository;
        }
        public async Task<List<Product>> AddRange(List<Product> products)
        {
           return await _productRepository.AddRangeAsync(products);
        }

        public async Task DeleteRange(List<Product> products)
        {
            await _productRepository.DeleteRangeAsync(products);
        }

        public async Task<List<Product>> GetAll()
        {
            return await _productRepository.GetAllAsync();
        }

        public  async Task<List<Product>> UpdateMany(List<Product> products)
        {
            return await _productRepository.UpdateRangeAsync(products);
        }
    }
}
