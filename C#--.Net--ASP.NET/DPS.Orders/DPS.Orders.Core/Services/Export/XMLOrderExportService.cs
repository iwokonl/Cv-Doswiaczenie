using DPS.Orders.Core.Entities.Orders;
using DPS.Orders.Core.Entities.Products;
using DPS.Orders.Core.Interfaces.Export;
using System.Collections.Generic;
using System.Xml;

namespace DPS.Orders.Core.Services.Export
{
    public class XMLOrderExportService : IXMLOrderExportService
    {
        public void Export(OrderHeader orderHeader, List<Product> products, string destinationPath)
        {
            XmlDocument document = new();

            var root = document.CreateElement("Root");
            document.AppendChild(root);

            var orderHeaderElement = document.CreateElement("OrderHeader");
            root.AppendChild(orderHeaderElement);
            var firstNameElement = document.CreateElement("FirstName");
            firstNameElement.InnerText = orderHeader.FirstName;
            orderHeaderElement.AppendChild(firstNameElement);

            var lastNameElement = document.CreateElement("LastName");
            lastNameElement.InnerText = orderHeader.LastName;
            orderHeaderElement.AppendChild(lastNameElement);

            var dateOfBirthElement = document.CreateElement("DateOfBirth");
            dateOfBirthElement.InnerText = orderHeader.DateOfBirth.ToShortDateString();
            orderHeaderElement.AppendChild(dateOfBirthElement);

            var productsElement = document.CreateElement("Products");
            root.AppendChild(productsElement);

            foreach(var product in products)
            {
                var productElement = document.CreateElement("Product");
                var productNameElement = document.CreateElement("Name");
                productNameElement.InnerText = product.Name;
                productElement.AppendChild(productNameElement);

                var productPriceElement = document.CreateElement("Price");
                productPriceElement.InnerText = product.Price.ToString();
                productElement.AppendChild(productPriceElement);

                var productQuantityElement = document.CreateElement("Quantity");
                productQuantityElement.InnerText = product.Quantity.ToString();
                productElement.AppendChild(productQuantityElement);

                productsElement.AppendChild(productElement);
            }

            document.Save(destinationPath + "/zamówienie.xml");
        }
    }
}
