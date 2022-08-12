using DPS.Orders.Core.Entities.Orders;
using DPS.Orders.Core.Interfaces.Orders;
using System.Linq;
using System.Threading.Tasks;

namespace DPS.Orders.Core.Services.Orders
{
    public class OrderHeaderService : IOrderHeaderService
    {
        private readonly IOrderHeaderRepository _orderHeaderRepository;


        public OrderHeaderService(IOrderHeaderRepository orderHeaderRepository)
        {
            _orderHeaderRepository = orderHeaderRepository;
        }


        public async Task<OrderHeader> Load()
        {
            var allOrderHeaders = await _orderHeaderRepository.GetAllAsync();
            return allOrderHeaders.FirstOrDefault();
        }

        public async Task Save(OrderHeader orderHeader)
        {
            if (orderHeader.Id > 0)
            {
                await _orderHeaderRepository.UpdateAsync(orderHeader);
            }
            else
            {
                await _orderHeaderRepository.AddAsync(orderHeader);
            }
        }
    }
}
