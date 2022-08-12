using DPS.Orders.Core.Entities.Orders;
using DPS.Orders.Core.Interfaces.Orders;
using DPS.Orders.Infrastructure.Repositories.Data;

namespace DPS.Orders.Infrastructure.Repositories.Orders
{
    public class OrderHeaderRepository : Repository<OrderHeader>, IOrderHeaderRepository
    {
        public OrderHeaderRepository(AppDbContext appDbContext) : base(appDbContext)
        {

        }
    }
}