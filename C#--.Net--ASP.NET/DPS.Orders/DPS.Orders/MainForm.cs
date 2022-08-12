using DPS.Orders.Core.Services.Products;
using DPS.Orders.Desktop;
using DPS.Orders.Desktop.Models.Products;
using DPS.Orders.Desktop.ViewModels.Main;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DPS.Orders
{
    public partial class MainForm : Form
    {
        private readonly MainViewModel _viewModel;

        
        public MainForm(MainViewModel mainViewModel)
        {
            _viewModel = mainViewModel;
            InitializeComponent();
            Initialize();
        }

        private async void Initialize()
        {
            await _viewModel.OnInitialize();
            OnInitialized();
        }

        private void OnInitialized()
        {
            ProductsGridView.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
            ProductsGridView.DataSource = _viewModel.Products;
            ProductsGridView.SelectionChanged += ProductsGridView_SelectionChanged;
            ProductsGridView.AllowUserToAddRows = false;
            ProductsGridView.CellClick += ProductsGridView_CellClick;

            FirstNameTextBox.DataBindings.Add("Text", _viewModel.OrderHeader, "FirstName");
            LastNameTextBox.DataBindings.Add("Text", _viewModel.OrderHeader, "LastName");
            DateOfBirth.DataBindings.Add("Value", _viewModel.OrderHeader, "DateOfBirth", true);
        }

        private void ProductsGridView_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            ProductsGridView.Rows[e.RowIndex].ReadOnly = true;

            if (ProductsGridView.Rows[e.RowIndex].Cells[e.ColumnIndex].Value == null)
            {
                ProductsGridView.Rows[e.RowIndex].ReadOnly = false;
            }
        }

        private void ProductsGridView_SelectionChanged(object sender, EventArgs e)
        {
            if (ProductsGridView.SelectedRows.Count == 0)
            {
                _viewModel.SelectedProduct = null;
            }
            else
            {
                var productModel = ProductsGridView.SelectedRows[0].DataBoundItem as ProductModel;

                _viewModel.SelectedProduct = productModel;
            }
        }

        private void EditProduct_Click(object sender, EventArgs e)
        {
            _viewModel.ShowEditProductFrom();
        }

        private  void AddProduct_Click(object sender, EventArgs e)
        {
            _viewModel.ShowAddProductFrom();
        }
        private void DeleteProduct_Click(object sender, EventArgs e)
        {
             _viewModel.DeleteProduct();
        }

        private async void SaveChanges_Click(object sender, EventArgs e)
        {
            await _viewModel.SaveChanges();
        }

        private void ExportToXML_Click(object sender, EventArgs e)
        {
             _viewModel.ExportToXML();
        }
    }
}
