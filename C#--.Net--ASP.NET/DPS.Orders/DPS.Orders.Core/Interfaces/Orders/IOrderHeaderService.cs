using DPS.Orders.Core.Entities.Orders;
using System.Threading.Tasks;

namespace DPS.Orders.Core.Interfaces.Orders
{
    public interface IOrderHeaderService
    {
        Task<OrderHeader> Load();
        Task Save(OrderHeader orderHeader);
    }
}
