using AutoMapper;
using DPS.Orders.Core.Entities.Orders;
using DPS.Orders.Core.Entities.Products;
using DPS.Orders.Desktop.Models.Orders;
using DPS.Orders.Desktop.Models.Products;

namespace DPS.Orders.Desktop.Extentions
{
    public class AutoMapperProfile : Profile
    {
        public AutoMapperProfile()
        {
            CreateMap<Product, ProductModel>();
            CreateMap<ProductModel, Product>();

            CreateMap<OrderHeader, OrderHeaderModel>();
            CreateMap<OrderHeaderModel, OrderHeader>();
        }
    }
}
