using DPS.Orders.Core.Entities;
using DPS.Orders.Core.Interfaces.Base;
using DPS.Orders.Infrastructure.Repositories.Data;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace DPS.Orders.Infrastructure.Repositories
{
    public class Repository<TEntity> : IRepository<TEntity> where TEntity : BaseEntity, new()
    {
        protected AppDbContext _dbContext;

        public Repository(AppDbContext dbContext)
        {
            _dbContext = dbContext;
        }


        public async Task<List<TEntity>> GetAllAsync()
        {
            try
            {
                _dbContext = new AppDbContext();
      
                return await _dbContext.Set<TEntity>().AsNoTracking().ToListAsync();
            }
            catch (Exception ex)
            {
                throw;
            }
        }

        public async Task<List<TEntity>> AddRangeAsync(List<TEntity> entities)
        {
            if (entities == null)
            {
                throw new ArgumentNullException($"{nameof(AddRangeAsync)} entity must not be null");
            }

            try
            {
                foreach (var entity in entities)
                {
                    await _dbContext.AddAsync(entity);       
                }

                await _dbContext.SaveChangesAsync();

                foreach(var entity in entities)
                {
                    _dbContext.Entry(entity).State = EntityState.Detached;
                }
            }
            catch (Exception ex)
            {
                throw;
            }

            return entities;
        }

        public async Task<List<TEntity>> UpdateRangeAsync(List<TEntity> entities)
        {
            if (entities == null)
            {
                throw new ArgumentNullException($"{nameof(AddRangeAsync)} entity must not be null");
            }

            try
            {
                foreach (var entity in entities)
                {
                    _dbContext.Update(entity);
                }

                await _dbContext.SaveChangesAsync();

                foreach (var entity in entities)
                {
                    _dbContext.Entry(entity).State = EntityState.Detached;
                }
            }
            catch (Exception ex)
            {
                throw;
            }

            return entities;
        }

        public async Task<TEntity> UpdateAsync(TEntity entity)
        {
            if (entity == null)
            {
                throw new ArgumentNullException($"{nameof(AddRangeAsync)} entity must not be null");
            }

            try
            {
                _dbContext.Update(entity);

                await _dbContext.SaveChangesAsync();

                _dbContext.Entry(entity).State = EntityState.Detached;
            }
            catch (Exception ex)
            {
                throw;
            }

            return  entity;
        }

        public async Task<TEntity> AddAsync(TEntity entity)
        {
            if (entity == null)
            {
                throw new ArgumentNullException($"{nameof(AddRangeAsync)} entity must not be null");
            }

            try
            {
                await _dbContext.AddAsync(entity);

                await _dbContext.SaveChangesAsync();

                _dbContext.Entry(entity).State = EntityState.Detached;
            }
            catch (Exception ex)
            {
                throw;
            }

            return entity;
        }

        public async Task DeleteRangeAsync(List<TEntity> entities)
        {
            if (entities == null)
            {
                throw new ArgumentNullException($"{nameof(AddRangeAsync)} entities must not be null");
            }

            try
            {
                foreach (var entity in entities)
                {
                    _dbContext.Remove(entity);
                }

                await _dbContext.SaveChangesAsync();


                foreach (var entity in entities)
                {
                    _dbContext.Entry(entity).State = EntityState.Detached;
                }
            }
            catch (Exception ex)
            {
              
                throw;
            }
        }
    }
}
