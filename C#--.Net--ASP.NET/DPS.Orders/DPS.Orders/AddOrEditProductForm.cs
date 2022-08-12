using DPS.Orders.Desktop.Models.Products;
using System;
using System.Windows.Forms;

namespace DPS.Orders.Desktop
{
    public partial class AddOrEditProductForm : Form
    {
        private bool _isEditing;
        public bool IsEditing { get => _isEditing; private set => _isEditing = value; }

        private ProductModel _productModel;
        public ProductModel ProductModel { get => _productModel; private set => _productModel = value; }
        public Action OnSave { get; set; }

        public AddOrEditProductForm(ProductModel productModel, bool isEditing)
        {
            ProductModel = productModel;
            IsEditing = isEditing;
            this.ControlBox = false;
            this.Text = (IsEditing ? "Edytuj" : "Dodaj") + " Produkt";

            InitializeComponent();
            textBox1.DataBindings.Add("Text", productModel, "Name");
            textBox2.DataBindings.Add("Text", productModel, "Quantity");
            textBox3.DataBindings.Add("Text", productModel, "Price");
        }

        private void CancelButton_Click(object sender, System.EventArgs e)
        {
            Close();
        }

        private void SaveButton_Click(object sender, System.EventArgs e)
        {
            OnSave?.Invoke();
            Close();
        }
    }
}
