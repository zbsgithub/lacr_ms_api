
                            

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
import com.gzdata.core.model.UserRoleInfo;

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
public interface UserRoleInfoDao extends BaseDAOInterface<UserRoleInfo> {

	 	
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
	@Insert({ "insert into user_role_info ( user_role_id,user_id,role_id)  values (#{userRoleId,jdbcType=INTEGER},#{userId,jdbcType=INTEGER},#{roleId,jdbcType=INTEGER})" })
	@Override
	 	@Options(useGeneratedKeys = true, keyProperty = "userRoleId")
		public void insert(UserRoleInfo entity);

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
			+"insert into user_role_info "
		    +"<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"userRoleId != null\" > user_role_id, </if> <if test=\"userId != null\" > user_id, </if> <if test=\"roleId != null\" > role_id, </if>  </trim> "
		    +" <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"userRoleId != null\" > #{userRoleId,jdbcType=INTEGER}, </if> <if test=\"userId != null\" > #{userId,jdbcType=INTEGER}, </if> <if test=\"roleId != null\" > #{roleId,jdbcType=INTEGER}, </if> </trim>"
		    +"</script>" 
			})
	@Override
	 	@Options(useGeneratedKeys = true, keyProperty = "userRoleId")
		public void insertSelective(UserRoleInfo entity);
	
	

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
	@Delete({ "delete from user_role_info where user_role_id = #{id,jdbcType=INTEGER}" })
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
			+"delete from user_role_info where user_role_id in "
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
	@Update({ "update user_role_info set user_role_id= #{userRoleId,jdbcType=INTEGER},user_id= #{userId,jdbcType=INTEGER},role_id= #{roleId,jdbcType=INTEGER} where user_role_id = #{userRoleId,jdbcType=INTEGER} " })
	@Override
	public void update(UserRoleInfo entity);
	
	

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
			+"update user_role_info "
			+"<set > <if test=\"userRoleId != null\" > user_role_id = #{userRoleId,jdbcType=INTEGER}, </if> <if test=\"userId != null\" > user_id = #{userId,jdbcType=INTEGER}, </if> <if test=\"roleId != null\" > role_id = #{roleId,jdbcType=INTEGER}, </if>  </set> "
			+"where user_role_id = #{userRoleId,jdbcType=INTEGER}"
			+"</script>" 
			})
	@Override
	public void updateSelective(UserRoleInfo entity);

	
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
	@Select({ "select * from user_role_info" })
	@Results({@Result(column = "user_role_id", property = "userRoleId" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "user_id", property = "userId" , jdbcType = JdbcType.INTEGER ),@Result(column = "role_id", property = "roleId" , jdbcType = JdbcType.INTEGER ) })
	@Override
	public List<UserRoleInfo> findAll();

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
	@Select({ "select count(user_role_id) from user_role_info" })
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
	@Select({ "select * from user_role_info where user_role_id = #{id,jdbcType=INTEGER}" })
	@Results({@Result(column = "user_role_id", property = "userRoleId" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "user_id", property = "userId" , jdbcType = JdbcType.INTEGER ),@Result(column = "role_id", property = "roleId" , jdbcType = JdbcType.INTEGER ) })
	@Override
	public UserRoleInfo findById(Serializable id);

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
			+"select * from user_role_info "
			+"<where> 1 = 1 "
			+"<if test=\"userRoleId != null\" > and user_role_id = #{userRoleId,jdbcType=INTEGER} </if><if test=\"userId != null\" > and user_id = #{userId,jdbcType=INTEGER} </if><if test=\"roleId != null\" > and role_id = #{roleId,jdbcType=INTEGER} </if> "
			+"</where> order by user_role_id </script>" 
			})
	@Results({@Result(column = "user_role_id", property = "userRoleId" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "user_id", property = "userId" , jdbcType = JdbcType.INTEGER ),@Result(column = "role_id", property = "roleId" , jdbcType = JdbcType.INTEGER ) })
	@Override
	public List<UserRoleInfo> findList(QueryInterface query);

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
			+"select count(user_role_id) from user_role_info "
			+"<where> 1 = 1 "
			+"<if test=\"userRoleId != null\" > and user_role_id = #{userRoleId,jdbcType=INTEGER} </if><if test=\"userId != null\" > and user_id = #{userId,jdbcType=INTEGER} </if><if test=\"roleId != null\" > and role_id = #{roleId,jdbcType=INTEGER} </if> "
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
			+"select * from user_role_info "
			+"<where> 1 = 1 "
			+"<if test=\"userRoleId != null\" > and user_role_id = #{userRoleId,jdbcType=INTEGER} </if><if test=\"userId != null\" > and user_id = #{userId,jdbcType=INTEGER} </if><if test=\"roleId != null\" > and role_id = #{roleId,jdbcType=INTEGER} </if> "
			+"</where> order by user_role_id "
			+"<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+"</script>" 
			})
	@Results({@Result(column = "user_role_id", property = "userRoleId" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "user_id", property = "userId" , jdbcType = JdbcType.INTEGER ),@Result(column = "role_id", property = "roleId" , jdbcType = JdbcType.INTEGER ) })
	@Override
	public List<UserRoleInfo> findPaginationDataByCondition(QueryInterface query);

}

