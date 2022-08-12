using FullStack.API.Data;
using FullStack.API.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace FullStack.API.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class EmployeesController : Controller
    {
        private readonly FullStackDbContext _fullStackDbContext;
        public EmployeesController(FullStackDbContext fullStackDbContext)
        {
            _fullStackDbContext = fullStackDbContext;
        }
        [HttpGet]
        public async Task<IActionResult> GetAllEmployees()
        {
            var employees = await _fullStackDbContext.Employesses.ToListAsync();
            return Ok(employees);
        }
        [HttpPost]
        public async Task<IActionResult> AddEmployee([FromBody] Employess employeeRequest)
        {
            var employees = await _fullStackDbContext.Employesses.OrderByDescending(x => x.Id).ToListAsync();
            await _fullStackDbContext.Employesses.AddAsync(employeeRequest);
            await _fullStackDbContext.SaveChangesAsync();
            return Ok(employees);
        }
        [HttpGet]
        [Route("{id:int}")]
        public async Task<IActionResult> GetEmployee(int id)
        {
            var employee = await _fullStackDbContext.Employesses.FirstOrDefaultAsync(x => x.Id == id);

            if (employee == null)
            {
                return NotFound();
            }
            Console.WriteLine(employee);
            return Ok(employee);
        }
        [HttpPut]
        [Route("{id:int}")]
        public async Task<IActionResult> UpdateEmployee([FromRoute] int id, Employess updateEmployeeRequest)
        {
            var employee = await _fullStackDbContext.Employesses.FindAsync(id);
            if (employee == null)
            {
                return NotFound();
            }
            employee.FirstName = updateEmployeeRequest.FirstName;
            employee.LastName = updateEmployeeRequest.LastName;
            await _fullStackDbContext.SaveChangesAsync();

            return Ok(employee);

        }
        [HttpDelete]
        [Route("{id:int}")]
        public async Task<IActionResult> DeleteEmployee([FromRoute] int id)
        {
            var employee = await _fullStackDbContext.Employesses.FindAsync(id);
            if(employee == null)
            {
                return NotFound();
            }
            _fullStackDbContext.Employesses.Remove(employee);
            await _fullStackDbContext.SaveChangesAsync();
            return Ok(employee);
        }
    }
}