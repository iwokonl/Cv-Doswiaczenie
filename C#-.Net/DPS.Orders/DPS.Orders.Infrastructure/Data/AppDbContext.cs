using DPS.Orders.Core.Entities.Orders;
using DPS.Orders.Core.Entities.Products;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Design;

namespace DPS.Orders.Infrastructure.Repositories.Data
{
    public class AppDbContext : DbContext
    {
        public static readonly string ConnectionString = "Data Source=c:\\DPS\\DPS.db";

        public DbSet<Product> Products { get; set; }

        public DbSet<OrderHeader> OrderHeaders { get; set; }

        protected override void OnConfiguring(
           DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlite(
                ConnectionString);

            base.OnConfiguring(optionsBuilder);
        }
    }

    public class DesignTimeDbContextFactory : IDesignTimeDbContextFactory<AppDbContext>
    {
        public AppDbContext CreateDbContext(string[] args)
        {
            return new AppDbContext();
        }
    }
}
