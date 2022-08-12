using System;

namespace DPS.Orders.Desktop.Models.Orders
{
    public class OrderHeaderModel
    {
        public string FirstName { get; set; } = string.Empty;
        public string LastName { get; set; } = string.Empty;
        public DateTime DateOfBirth { get; set; }
    }
}
