using Microsoft.EntityFrameworkCore;

namespace WebApplication1.Models
{
    public class AppDbContext:DbContext
    {
        public AppDbContext(DbContextOptions options): base(options) 
        { }
        public DbSet<Transaction> Transactions { get; set; }
        public DbSet<Category> Categories { get; set; }
    }
}
