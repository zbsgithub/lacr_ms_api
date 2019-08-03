
                    

package com.gzdata.core.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.query.QueryInterface;
import com.gzdata.core.model.Role;

/**
 * 
 *  说明：对象的数据访问类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2019年07月23日
 */
public interface RoleDao extends BaseDAOInterface<Role> {

	 	
	/**
	 * 
	 * 功能描述：保存
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月23日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Insert({ "insert into role ( id,role_name)  values (#{id,jdbcType=INTEGER},#{roleName,jdbcType=VARCHAR})" })
	@Override
	 	@Options(useGeneratedKeys = true, keyProperty = "id")
		public void insert(Role entity);

	/**
	 * 
	 * 功能描述：选择字段保存
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月23日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Insert({
			"<script>"
			+"insert into role "
		    +"<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"roleName != null\" > role_name, </if>  </trim> "
		    +" <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=INTEGER}, </if> <if test=\"roleName != null\" > #{roleName,jdbcType=VARCHAR}, </if> </trim>"
		    +"</script>" 
			})
	@Override
	 	@Options(useGeneratedKeys = true, keyProperty = "id")
		public void insertSelective(Role entity);
	
	

	/**
	 * 
	 * 功能描述：根据ID删除
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月23日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Delete({ "delete from role where id = #{id,jdbcType=INTEGER}" })
	@Override
	public void deleteByID(Serializable id);

	/**
	 * 
	 * 功能描述：根据ID数组批量删除
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月23日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Delete({
			"<script>"
			+"delete from role where id in "
			+"<foreach  item=\"id\"  collection=\"array\" open=\"(\" separator=\",\" close=\")\" > #{id} </foreach>"
			+"</script>" 
			})
	@Override
	public void batchDelete(Serializable... ids);

	/**
	 * 
	 * 功能描述：更新
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月23日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Update({ "update role set id= #{id,jdbcType=INTEGER},role_name= #{roleName,jdbcType=VARCHAR} where id = #{id,jdbcType=INTEGER} " })
	@Override
	public void update(Role entity);
	
	

	/**
	 * 
	 * 功能描述：选择字段更新
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月23日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Update({
			"<script>"
			+"update role "
			+"<set > <if test=\"id != null\" > id = #{id,jdbcType=INTEGER}, </if> <if test=\"roleName != null\" > role_name = #{roleName,jdbcType=VARCHAR}, </if>  </set> "
			+"where id = #{id,jdbcType=INTEGER}"
			+"</script>" 
			})
	@Override
	public void updateSelective(Role entity);

	
	/**
	 * 
	 * 功能描述：查询所有
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月23日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({ "select * from role" })
	@Results({@Result(column = "id", property = "id" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "role_name", property = "roleName" , jdbcType = JdbcType.VARCHAR ) })
	@Override
	public List<Role> findAll();

	/**
	 * 
	 * 功能描述：查询总数
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月23日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({ "select count(id) from role" })
	@Override
	public int findTotalCount();

	/**
	 * 
	 * 功能描述：根据ID查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月23日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({ "select * from role where id = #{id,jdbcType=INTEGER}" })
	@Results({@Result(column = "id", property = "id" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "role_name", property = "roleName" , jdbcType = JdbcType.VARCHAR ) })
	@Override
	public Role findById(Serializable id);

	/**
	 * 
	 * 功能描述：根据查询对象查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月23日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({
			"<script>"
			+"select * from role "
			+"<where> 1 = 1 "
			+"<if test=\"id != null\" > and id = #{id,jdbcType=INTEGER} </if><if test=\"roleName != null\" > and role_name = #{roleName,jdbcType=VARCHAR} </if> "
			+"</where> order by id </script>" 
			})
	@Results({@Result(column = "id", property = "id" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "role_name", property = "roleName" , jdbcType = JdbcType.VARCHAR ) })
	@Override
	public List<Role> findList(QueryInterface query);

	/**
	 * 
	 * 功能描述：根据查询对象查询记录数
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月23日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({
			"<script>"
			+"select count(id) from role "
			+"<where> 1 = 1 "
			+"<if test=\"id != null\" > and id = #{id,jdbcType=INTEGER} </if><if test=\"roleName != null\" > and role_name = #{roleName,jdbcType=VARCHAR} </if> "
			+"</where></script>" 
			})
	@Override
	public int findTotalCountByCondition(QueryInterface query);

	/**
	 * 
	 * 功能描述：根据查询对象查询分页记录
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月23日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({
			"<script>"
			+"select * from role "
			+"<where> 1 = 1 "
			+"<if test=\"id != null\" > and id = #{id,jdbcType=INTEGER} </if><if test=\"roleName != null\" > and role_name = #{roleName,jdbcType=VARCHAR} </if> "
			+"</where> order by id "
			+"<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+"</script>" 
			})
	@Results({@Result(column = "id", property = "id" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "role_name", property = "roleName" , jdbcType = JdbcType.VARCHAR ) })
	@Override
	public List<Role> findPaginationDataByCondition(QueryInterface query);

}

