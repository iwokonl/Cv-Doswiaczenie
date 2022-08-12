using System.Collections.Generic;
using System.Threading.Tasks;

namespace DPS.Orders.Core.Interfaces.Base
{
    public interface IRepository<TEntity> where TEntity : class, new()
    {

        Task<List<TEntity>> GetAllAsync();
        Task<List<TEntity>> AddRangeAsync(List<TEntity> entities);
        Task DeleteRangeAsync(List<TEntity> entities);
        Task<List<TEntity>> UpdateRangeAsync(List<TEntity> entities);
        Task<TEntity> UpdateAsync(TEntity entity);
        Task<TEntity> AddAsync(TEntity entity);
    }
}
