
                                                

package com.gzdata.core.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.query.QueryInterface;
import com.gzdata.core.model.User;

/**
 * 
 *  说明：对象的数据访问类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2019年07月17日
 */
public interface UserDao extends BaseDAOInterface<User> {

	 	
	/**
	 * 
	 * 功能描述：保存
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月17日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Insert({ "insert into user ( id,user_name,password,eable_state,create_time,remark)  values (#{id,jdbcType=INTEGER},#{userName,jdbcType=VARCHAR},#{password,jdbcType=VARCHAR},#{eableState,jdbcType=VARCHAR},#{createTime,jdbcType=TIMESTAMP},#{remark,jdbcType=VARCHAR})" })
	@Override
	 	@Options(useGeneratedKeys = true, keyProperty = "id")
		public void insert(User entity);

	/**
	 * 
	 * 功能描述：选择字段保存
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月17日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Insert({
			"<script>"
			+"insert into user "
		    +"<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"userName != null\" > user_name, </if> <if test=\"password != null\" > password, </if> <if test=\"eableState != null\" > eable_state, </if> <if test=\"createTime != null\" > create_time, </if> <if test=\"remark != null\" > remark, </if>  </trim> "
		    +" <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=INTEGER}, </if> <if test=\"userName != null\" > #{userName,jdbcType=VARCHAR}, </if> <if test=\"password != null\" > #{password,jdbcType=VARCHAR}, </if> <if test=\"eableState != null\" > #{eableState,jdbcType=VARCHAR}, </if> <if test=\"createTime != null\" > #{createTime,jdbcType=TIMESTAMP}, </if> <if test=\"remark != null\" > #{remark,jdbcType=VARCHAR}, </if> </trim>"
		    +"</script>" 
			})
	@Override
	 	@Options(useGeneratedKeys = true, keyProperty = "id")
		public void insertSelective(User entity);
	
	

	/**
	 * 
	 * 功能描述：根据ID删除
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月17日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Delete({ "delete from user where id = #{id,jdbcType=INTEGER}" })
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
	 * @since 2019年07月17日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Delete({
			"<script>"
			+"delete from user where id in "
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
	 * @since 2019年07月17日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Update({ "update user set id= #{id,jdbcType=INTEGER},user_name= #{userName,jdbcType=VARCHAR},password= #{password,jdbcType=VARCHAR},eable_state= #{eableState,jdbcType=VARCHAR},create_time= #{createTime,jdbcType=TIMESTAMP},remark= #{remark,jdbcType=VARCHAR} where id = #{id,jdbcType=INTEGER} " })
	@Override
	public void update(User entity);
	
	

	/**
	 * 
	 * 功能描述：选择字段更新
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月17日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Update({
			"<script>"
			+"update user "
			+"<set > <if test=\"id != null\" > id = #{id,jdbcType=INTEGER}, </if> <if test=\"userName != null\" > user_name = #{userName,jdbcType=VARCHAR}, </if> <if test=\"password != null\" > password = #{password,jdbcType=VARCHAR}, </if> <if test=\"eableState != null\" > eable_state = #{eableState,jdbcType=VARCHAR}, </if> <if test=\"createTime != null\" > create_time = #{createTime,jdbcType=TIMESTAMP}, </if> <if test=\"remark != null\" > remark = #{remark,jdbcType=VARCHAR}, </if> </set> "
			+"where id = #{id,jdbcType=INTEGER}"
			+"</script>" 
			})
	@Override
	public void updateSelective(User entity);

	
	/**
	 * 
	 * 功能描述：查询所有
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月17日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({ "select * from user" })
	@Results({@Result(column = "id", property = "id" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "user_name", property = "userName" , jdbcType = JdbcType.VARCHAR ),@Result(column = "password", property = "password" , jdbcType = JdbcType.VARCHAR ),@Result(column = "eable_state", property = "eableState" , jdbcType = JdbcType.VARCHAR ),@Result(column = "create_time", property = "createTime" , jdbcType = JdbcType.TIMESTAMP ),@Result(column = "remark", property = "remark" , jdbcType = JdbcType.VARCHAR ) })
	@Override
	public List<User> findAll();

	/**
	 * 
	 * 功能描述：查询总数
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月17日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({ "select count(id) from user" })
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
	 * @since 2019年07月17日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({ "select * from user where id = #{id,jdbcType=INTEGER}" })
	@Results({@Result(column = "id", property = "id" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "user_name", property = "userName" , jdbcType = JdbcType.VARCHAR ),@Result(column = "password", property = "password" , jdbcType = JdbcType.VARCHAR ),@Result(column = "eable_state", property = "eableState" , jdbcType = JdbcType.VARCHAR ),@Result(column = "create_time", property = "createTime" , jdbcType = JdbcType.TIMESTAMP ),@Result(column = "remark", property = "remark" , jdbcType = JdbcType.VARCHAR ) })
	@Override
	public User findById(Serializable id);

	/**
	 * 
	 * 功能描述：根据查询对象查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月17日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({
			"<script>"
			+"select * from user "
			+"<where> 1 = 1 "
			+"<if test=\"id != null\" > and id = #{id,jdbcType=INTEGER} </if><if test=\"userName != null\" > and user_name = #{userName,jdbcType=VARCHAR} </if><if test=\"password != null\" > and password = #{password,jdbcType=VARCHAR} </if><if test=\"eableState != null\" > and eable_state = #{eableState,jdbcType=VARCHAR} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
			+"</where> order by id </script>" 
			})
	@Results({@Result(column = "id", property = "id" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "user_name", property = "userName" , jdbcType = JdbcType.VARCHAR ),@Result(column = "password", property = "password" , jdbcType = JdbcType.VARCHAR ),@Result(column = "eable_state", property = "eableState" , jdbcType = JdbcType.VARCHAR ),@Result(column = "create_time", property = "createTime" , jdbcType = JdbcType.TIMESTAMP ),@Result(column = "remark", property = "remark" , jdbcType = JdbcType.VARCHAR ) })
	@Override
	public List<User> findList(QueryInterface query);

	/**
	 * 
	 * 功能描述：根据查询对象查询记录数
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月17日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({
			"<script>"
			+"select count(id) from user "
			+"<where> 1 = 1 "
			+"<if test=\"id != null\" > and id = #{id,jdbcType=INTEGER} </if><if test=\"userName != null\" > and user_name = #{userName,jdbcType=VARCHAR} </if><if test=\"password != null\" > and password = #{password,jdbcType=VARCHAR} </if><if test=\"eableState != null\" > and eable_state = #{eableState,jdbcType=VARCHAR} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if> "
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
	 * @since 2019年07月17日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({
			"<script>"
			+"select * from user "
			+"<where> 1 = 1 "
			+"<if test=\"id != null\" > and id = #{id,jdbcType=INTEGER} </if><if test=\"userName != null\" > and user_name = #{userName,jdbcType=VARCHAR} </if><if test=\"password != null\" > and password = #{password,jdbcType=VARCHAR} </if><if test=\"eableState != null\" > and eable_state = #{eableState,jdbcType=VARCHAR} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
			+"</where> order by id "
			+"<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+"</script>" 
			})
	@Results({@Result(column = "id", property = "id" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "user_name", property = "userName" , jdbcType = JdbcType.VARCHAR ),@Result(column = "password", property = "password" , jdbcType = JdbcType.VARCHAR ),@Result(column = "eable_state", property = "eableState" , jdbcType = JdbcType.VARCHAR ),@Result(column = "create_time", property = "createTime" , jdbcType = JdbcType.TIMESTAMP ),@Result(column = "remark", property = "remark" , jdbcType = JdbcType.VARCHAR )})
	@Override
	public List<User> findPaginationDataByCondition(QueryInterface query);

	/**
	 * 
	 * 功能描述：根据用户名查找记录
	 *
	 * @param userName
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2019年7月17日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({" SELECT * from user u WHERE u.user_name = #{userName}; "})
	public User findByUserName(@Param("userName") String userName);
}

