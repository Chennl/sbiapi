package com.swirebev.dao.generic;

import java.io.Serializable;
import java.util.List;
/*void delete(Object entity)：删除指定持久化实例

Ø  deleteAll(Collection entities)：删除集合内全部持久化类实例

Ø  find(String queryString)：根据HQL查询字符串来返回实例集合

Ø  findByNamedQuery(String queryName)：根据命名查询返回实例集合

Ø  get(Class entityClass, Serializable id)：根据主键加载特定持久化类的实例

Ø  save(Object entity)：保存新的实例

Ø  saveOrUpdate(Object entity)：根据实例状态，选择保存或者更新

Ø  update(Object entity)：更新实例的状态，要求entity是持久状态

Ø  setMaxResults(int maxResults)：设置分页的大小

*/

public interface GenericDao<T> {
	 /**
     * Create entity
     * @param entity
     */
    void save(T entity);
    
    /**
     * Update entity
     * @param entity
     */
    void update(T entity);
    
    /**
     * Create or Update entity
     * @param entity POJO
     */
    void saveOrUpdate(T entity);
    
    /**
     * Delete entity
     * @param entity
     */
    void delete(T entity);
    
    /**
     * Delete entity
     * @param entity
     */
    void deleteById(Serializable id);
    
    /**
     * Find entity by id
     * @param id ID
     * @return Entity
     */
    T getById(Serializable id);
    
    /**
     * Find all
     */
    List<T> findAll();
    
    /**
     * Find 
     * @return
     */
    List<T> find(String  queryString);
    
  


}
