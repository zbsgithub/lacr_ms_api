
                            

package com.gzdata.core.dao.master;

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
import com.gzdata.core.model.RolePermiInfo;

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
public interface RolePermiInfoDao extends BaseDAOInterface<RolePermiInfo> {

	 	
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
	@Insert({ "insert into role_permi_info ( role_permi_id,role_id,permi_id)  values (#{rolePermiId,jdbcType=INTEGER},#{roleId,jdbcType=INTEGER},#{permiId,jdbcType=INTEGER})" })
	@Override
	 	@Options(useGeneratedKeys = true, keyProperty = "rolePermiId")
		public void insert(RolePermiInfo entity);

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
			+"insert into role_permi_info "
		    +"<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"rolePermiId != null\" > role_permi_id, </if> <if test=\"roleId != null\" > role_id, </if> <if test=\"permiId != null\" > permi_id, </if>  </trim> "
		    +" <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"rolePermiId != null\" > #{rolePermiId,jdbcType=INTEGER}, </if> <if test=\"roleId != null\" > #{roleId,jdbcType=INTEGER}, </if> <if test=\"permiId != null\" > #{permiId,jdbcType=INTEGER}, </if> </trim>"
		    +"</script>" 
			})
	@Override
	 	@Options(useGeneratedKeys = true, keyProperty = "rolePermiId")
		public void insertSelective(RolePermiInfo entity);
	
	

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
	@Delete({ "delete from role_permi_info where role_permi_id = #{id,jdbcType=INTEGER}" })
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
			+"delete from role_permi_info where role_permi_id in "
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
	@Update({ "update role_permi_info set role_permi_id= #{rolePermiId,jdbcType=INTEGER},role_id= #{roleId,jdbcType=INTEGER},permi_id= #{permiId,jdbcType=INTEGER} where role_permi_id = #{rolePermiId,jdbcType=INTEGER} " })
	@Override
	public void update(RolePermiInfo entity);
	
	

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
			+"update role_permi_info "
			+"<set > <if test=\"rolePermiId != null\" > role_permi_id = #{rolePermiId,jdbcType=INTEGER}, </if> <if test=\"roleId != null\" > role_id = #{roleId,jdbcType=INTEGER}, </if> <if test=\"permiId != null\" > permi_id = #{permiId,jdbcType=INTEGER}, </if>  </set> "
			+"where role_permi_id = #{rolePermiId,jdbcType=INTEGER}"
			+"</script>" 
			})
	@Override
	public void updateSelective(RolePermiInfo entity);

	
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
	@Select({ "select * from role_permi_info" })
	@Results({@Result(column = "role_permi_id", property = "rolePermiId" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "role_id", property = "roleId" , jdbcType = JdbcType.INTEGER ),@Result(column = "permi_id", property = "permiId" , jdbcType = JdbcType.INTEGER ) })
	@Override
	public List<RolePermiInfo> findAll();

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
	@Select({ "select count(role_permi_id) from role_permi_info" })
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
	@Select({ "select * from role_permi_info where role_permi_id = #{id,jdbcType=INTEGER}" })
	@Results({@Result(column = "role_permi_id", property = "rolePermiId" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "role_id", property = "roleId" , jdbcType = JdbcType.INTEGER ),@Result(column = "permi_id", property = "permiId" , jdbcType = JdbcType.INTEGER ) })
	@Override
	public RolePermiInfo findById(Serializable id);

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
			+"select * from role_permi_info "
			+"<where> 1 = 1 "
			+"<if test=\"rolePermiId != null\" > and role_permi_id = #{rolePermiId,jdbcType=INTEGER} </if><if test=\"roleId != null\" > and role_id = #{roleId,jdbcType=INTEGER} </if><if test=\"permiId != null\" > and permi_id = #{permiId,jdbcType=INTEGER} </if> "
			+"</where> order by role_permi_id </script>" 
			})
	@Results({@Result(column = "role_permi_id", property = "rolePermiId" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "role_id", property = "roleId" , jdbcType = JdbcType.INTEGER ),@Result(column = "permi_id", property = "permiId" , jdbcType = JdbcType.INTEGER ) })
	@Override
	public List<RolePermiInfo> findList(QueryInterface query);

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
			+"select count(role_permi_id) from role_permi_info "
			+"<where> 1 = 1 "
			+"<if test=\"rolePermiId != null\" > and role_permi_id = #{rolePermiId,jdbcType=INTEGER} </if><if test=\"roleId != null\" > and role_id = #{roleId,jdbcType=INTEGER} </if><if test=\"permiId != null\" > and permi_id = #{permiId,jdbcType=INTEGER} </if> "
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
			+"select * from role_permi_info "
			+"<where> 1 = 1 "
			+"<if test=\"rolePermiId != null\" > and role_permi_id = #{rolePermiId,jdbcType=INTEGER} </if><if test=\"roleId != null\" > and role_id = #{roleId,jdbcType=INTEGER} </if><if test=\"permiId != null\" > and permi_id = #{permiId,jdbcType=INTEGER} </if> "
			+"</where> order by role_permi_id "
			+"<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+"</script>" 
			})
	@Results({@Result(column = "role_permi_id", property = "rolePermiId" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "role_id", property = "roleId" , jdbcType = JdbcType.INTEGER ),@Result(column = "permi_id", property = "permiId" , jdbcType = JdbcType.INTEGER ) })
	@Override
	public List<RolePermiInfo> findPaginationDataByCondition(QueryInterface query);

}

