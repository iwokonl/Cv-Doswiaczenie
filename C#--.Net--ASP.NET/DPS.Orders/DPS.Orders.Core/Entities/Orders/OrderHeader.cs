using System;

namespace DPS.Orders.Core.Entities.Orders
{
    public class OrderHeader : BaseEntity
    {
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public DateTime DateOfBirth { get; set; }
    }
}
