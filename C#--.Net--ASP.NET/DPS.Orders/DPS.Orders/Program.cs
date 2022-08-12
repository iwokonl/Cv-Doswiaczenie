using DPS.Orders.Core.Services.Products;
using DPS.Orders.Desktop.ViewModels.Main;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using System;
using System.Windows.Forms;
using DPS.Orders.Core.Interfaces.Products;
using DPS.Orders.Infrastructure.Repositories.Products;
using System.IO;
using DPS.Orders.Infrastructure.Repositories.Data;
using Microsoft.EntityFrameworkCore;
using AutoMapper;
using DPS.Orders.Desktop.Extentions;
using DPS.Orders.Core.Interfaces.Orders;
using DPS.Orders.Core.Services.Orders;
using DPS.Orders.Infrastructure.Repositories.Orders;
using Microsoft.Extensions.Logging;
using DPS.Orders.Core.Interfaces.Export;
using DPS.Orders.Core.Services.Export;

namespace DPS.Orders
{
    static class Program
    {
        [STAThread]
        static void Main()
        {
            Application.SetHighDpiMode(HighDpiMode.SystemAware);
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);

            var host = CreateHostBuilder().Build();
            ServiceProvider = host.Services;

            Application.Run(ServiceProvider.GetRequiredService<MainForm>());
        }
        public static IServiceProvider ServiceProvider { get; private set; }
        static IHostBuilder CreateHostBuilder()
        {
            return Host.CreateDefaultBuilder()
                .ConfigureServices((context, services) =>
                {

                    if (!Directory.Exists("c:\\DPS"))
                        Directory.CreateDirectory("c:\\DPS");

                    AppDbContext _dbContext = new();
                    _dbContext.Database.EnsureCreated();

                    services.AddDbContext<AppDbContext>(options =>
                    options.UseSqlite(
                    AppDbContext.ConnectionString),
                    contextLifetime: ServiceLifetime.Transient,
                    optionsLifetime: ServiceLifetime.Singleton);

                    var mapperConfig = new MapperConfiguration(mc =>
                    {
                        mc.AddProfile(new AutoMapperProfile());
                    });

                    IMapper mapper = mapperConfig.CreateMapper();
                    services.AddSingleton(mapper);

                    services.AddTransient<MainViewModel>();
                    services.AddTransient<MainForm>();
                    services.AddTransient<IProductRepository, ProductRepository>();
                    services.AddTransient<IProductService, ProductService>();
                    services.AddTransient<IOrderHeaderRepository, OrderHeaderRepository>();
                    services.AddTransient<IOrderHeaderService, OrderHeaderService>();
                    services.AddTransient<IXMLOrderExportService, XMLOrderExportService>();
                });
        }
    }
}