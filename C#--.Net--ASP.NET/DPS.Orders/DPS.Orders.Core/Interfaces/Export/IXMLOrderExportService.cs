using DPS.Orders.Core.Entities.Orders;
using DPS.Orders.Core.Entities.Products;
using System.Collections.Generic;

namespace DPS.Orders.Core.Interfaces.Export
{
    public interface IXMLOrderExportService
    {
        void Export(OrderHeader orderHeader, List<Product> products, string destinationPath);
    }
}
