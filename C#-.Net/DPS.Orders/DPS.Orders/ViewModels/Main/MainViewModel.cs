using AutoMapper;
using DPS.Orders.Core.Entities.Orders;
using DPS.Orders.Core.Entities.Products;
using DPS.Orders.Core.Interfaces.Export;
using DPS.Orders.Core.Interfaces.Orders;
using DPS.Orders.Core.Services.Products;
using DPS.Orders.Desktop.Models.Orders;
using DPS.Orders.Desktop.Models.Products;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DPS.Orders.Desktop.ViewModels.Main
{
    public class MainViewModel : IViewModel
    {
        private readonly IMapper _mapper;
        private readonly IProductService _productService;
        private readonly IOrderHeaderService _orderHeaderService;
        private readonly IXMLOrderExportService _xMLOrderExportService;
        private int _localIdCounter;

        private List<ProductModel> _productsToDelete;
        public List<ProductModel> ProductsToDelete { get => _productsToDelete; set => _productsToDelete = value; }

        private BindingList<ProductModel> _products;
        public BindingList<ProductModel> Products { get => _products; set => _products = value; }

        private ProductModel _selectedProduct;
        public ProductModel SelectedProduct { get => _selectedProduct; set => _selectedProduct = value; }

        private OrderHeaderModel _orderHeader;
        public OrderHeaderModel OrderHeader { get => _orderHeader; set => _orderHeader = value; }


        private AddOrEditProductForm _addOrEditProductForm;

        public int GenerateLocalIdForProduct()
        {
            _localIdCounter++;
            return _localIdCounter;
        }

        public MainViewModel(IMapper mapper, IProductService productService, IOrderHeaderService orderHeaderService, IXMLOrderExportService  xMLOrderExportService)
        {
            _mapper = mapper;
            _productService = productService;
            _orderHeaderService = orderHeaderService;
            _xMLOrderExportService = xMLOrderExportService;
        }

        public async Task OnInitialize()
        {
            Products = new BindingList<ProductModel>();
            ProductsToDelete = new List<ProductModel>();

            await LoadProducts();
            await LoadOrderHeader();
        }


        private async Task LoadProducts()
        {
            try
            {
                Products = new BindingList<ProductModel>(_mapper.Map<List<ProductModel>>(await _productService.GetAll()));
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.ToString());
            }
        }

        private async Task LoadOrderHeader()
        {
            try
            {
                OrderHeader = _mapper.Map<OrderHeaderModel>(await _orderHeaderService.Load());

                if(OrderHeader == null)
                {
                    OrderHeader = new OrderHeaderModel();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.ToString());
            }
        }

        private async Task SaveOrderHeader()
        {
            try
            {
                await _orderHeaderService.Save(_mapper.Map<OrderHeader>(OrderHeader));
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.ToString());
            }
        }

        public void ExportToXML()
        {
            try
            {
                using var dialog = new FolderBrowserDialog();
                DialogResult result = dialog.ShowDialog();

                if (result == DialogResult.OK)
                {
                    _xMLOrderExportService.Export(_mapper.Map<OrderHeader>(OrderHeader), _mapper.Map<List<Product>>(Products), dialog.SelectedPath);
                    MessageBox.Show("Zamówienie zostało zapisane pomyślnie do pliku XML !");
                }
            }
            catch(Exception ex)
            {
                MessageBox.Show(ex.ToString());
            }
        }

        public async Task SaveChanges()
        {
            if(ProductsToDelete.Count > 0)
            {
                await DeleteUnnecessaryProducts();
            }

            var newProducts = Products.Where(prp => prp.Id == 0).ToList();

            if(newProducts.Count > 0)
            {
                await AddNewProducts(newProducts);
            }

            var productsToUpdates = Products.Where(prp => prp.Id != 0 && prp.WasEdited).ToList();

            if(productsToUpdates.Count > 0)
            {
                await UpdateExistingProducts(productsToUpdates);
            }

            await SaveOrderHeader();

            MessageBox.Show("Zmiany zostały zapisane !");
        }

        private async Task DeleteUnnecessaryProducts()
        {
            try
            {
                await _productService.DeleteRange(_mapper.Map<List<Product>>(ProductsToDelete));
            }
            catch(Exception ex)
            {
                MessageBox.Show(ex.ToString());
            }
        }

        private async Task UpdateExistingProducts(List<ProductModel> updatedProducts)
        {
            try
            {
                await _productService.UpdateMany(_mapper.Map<List<Product>>(updatedProducts));

                foreach (var product in updatedProducts)
                {
                    var localProduct = Products.FirstOrDefault(prp => prp.Id == product.Id);

                    if (localProduct != null)
                    {
                        localProduct.WasEdited = false;
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.ToString());
            }
        }

        private async Task AddNewProducts(List<ProductModel> products)
        {
            try
            {
                var newProducts = _mapper.Map<List<ProductModel>>(await _productService.AddRange(_mapper.Map<List<Product>>(products)));

                foreach (var localProduct in products)
                {
                    Products.Remove(localProduct);
                }

                foreach (var newProduct in newProducts)
                {
                    Products.Add(newProduct);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.ToString());
            }
        }

        public void ShowEditProductFrom()
        {
            if (SelectedProduct == null)
            {
                MessageBox.Show("Proszę wybrać produkt do zmiany.");
                return;
            }

            ShowAddOrEditProductForm(SelectedProduct.Clone(), true);
        }

        public void ShowAddProductFrom()
        {
            ShowAddOrEditProductForm(new ProductModel() { LocalId = GenerateLocalIdForProduct() }, false);
        }
      
        public void DeleteProduct()
        {
            if (SelectedProduct == null)
            {
                MessageBox.Show("Proszę wybrać produkt do usuniecia.");
                return;
            }

            if (SelectedProduct.Id != 0)
            {
                ProductsToDelete.Add(SelectedProduct);
            }

            Products.Remove(SelectedProduct);    
        }

        private void ShowAddOrEditProductForm(ProductModel productModel, bool isEditing)
        {
            if (_addOrEditProductForm != null)
            {
                _addOrEditProductForm.WindowState = FormWindowState.Normal;
                _addOrEditProductForm.Focus();
            }
            else
            {
                _addOrEditProductForm = new AddOrEditProductForm(productModel, isEditing);

                _addOrEditProductForm.OnSave += () =>
                {
                    if (!_addOrEditProductForm.IsEditing)
                    {
                        Products.Add(_addOrEditProductForm.ProductModel);
                    }
                    else
                    {
                        _addOrEditProductForm.ProductModel.WasEdited = true;
                        var oldProduct = Products.FirstOrDefault(prp => prp.Id != 0 && prp.Id == productModel.Id || prp.LocalId != 0 && prp.LocalId == productModel.LocalId);
                        var index = Products.IndexOf(oldProduct);
                        Products.Remove(oldProduct);
                        Products.Insert(index, _addOrEditProductForm.ProductModel);
                    }
                };

                _addOrEditProductForm.FormClosed += (o, ea) =>
                {
                    _addOrEditProductForm = null;
                };

                _addOrEditProductForm.Show();
            }
        }
    }
}
