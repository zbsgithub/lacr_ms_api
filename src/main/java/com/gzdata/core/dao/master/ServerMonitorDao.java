
                                                                

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
import com.gzdata.core.model.ServerMonitor;

/**
 * 
 *  说明：对象的数据访问类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2019年07月24日
 */
public interface ServerMonitorDao extends BaseDAOInterface<ServerMonitor> {

	 	
	/**
	 * 
	 * 功能描述：保存
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月24日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Insert({ "insert into server_monitor ( id,host,cpu,mem,disk,monitor_time,remark)  values (#{id,jdbcType=INTEGER},#{host,jdbcType=VARCHAR},#{cpu,jdbcType=VARCHAR},#{mem,jdbcType=VARCHAR},#{disk,jdbcType=VARCHAR},#{monitorTime,jdbcType=TIMESTAMP},#{remark,jdbcType=VARCHAR})" })
	@Override
	 	@Options(useGeneratedKeys = true, keyProperty = "id")
		public void insert(ServerMonitor entity);

	/**
	 * 
	 * 功能描述：选择字段保存
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月24日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Insert({
			"<script>"
			+"insert into server_monitor "
		    +"<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"host != null\" > host, </if> <if test=\"cpu != null\" > cpu, </if> <if test=\"mem != null\" > mem, </if> <if test=\"disk != null\" > disk, </if> <if test=\"monitorTime != null\" > monitor_time, </if> <if test=\"remark != null\" > remark, </if>  </trim> "
		    +" <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=INTEGER}, </if> <if test=\"host != null\" > #{host,jdbcType=VARCHAR}, </if> <if test=\"cpu != null\" > #{cpu,jdbcType=VARCHAR}, </if> <if test=\"mem != null\" > #{mem,jdbcType=VARCHAR}, </if> <if test=\"disk != null\" > #{disk,jdbcType=VARCHAR}, </if> <if test=\"monitorTime != null\" > #{monitorTime,jdbcType=TIMESTAMP}, </if> <if test=\"remark != null\" > #{remark,jdbcType=VARCHAR}, </if> </trim>"
		    +"</script>" 
			})
	@Override
	 	@Options(useGeneratedKeys = true, keyProperty = "id")
		public void insertSelective(ServerMonitor entity);
	
	

	/**
	 * 
	 * 功能描述：根据ID删除
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月24日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Delete({ "delete from server_monitor where id = #{id,jdbcType=INTEGER}" })
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
	 * @since 2019年07月24日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Delete({
			"<script>"
			+"delete from server_monitor where id in "
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
	 * @since 2019年07月24日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Update({ "update server_monitor set id= #{id,jdbcType=INTEGER},host= #{host,jdbcType=VARCHAR},cpu= #{cpu,jdbcType=VARCHAR},mem= #{mem,jdbcType=VARCHAR},disk= #{disk,jdbcType=VARCHAR},monitor_time= #{monitorTime,jdbcType=TIMESTAMP},remark= #{remark,jdbcType=VARCHAR} where id = #{id,jdbcType=INTEGER} " })
	@Override
	public void update(ServerMonitor entity);
	
	

	/**
	 * 
	 * 功能描述：选择字段更新
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月24日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Update({
			"<script>"
			+"update server_monitor "
			+"<set > <if test=\"id != null\" > id = #{id,jdbcType=INTEGER}, </if> <if test=\"host != null\" > host = #{host,jdbcType=VARCHAR}, </if> <if test=\"cpu != null\" > cpu = #{cpu,jdbcType=VARCHAR}, </if> <if test=\"mem != null\" > mem = #{mem,jdbcType=VARCHAR}, </if> <if test=\"disk != null\" > disk = #{disk,jdbcType=VARCHAR}, </if> <if test=\"monitorTime != null\" > monitor_time = #{monitorTime,jdbcType=TIMESTAMP}, </if> <if test=\"remark != null\" > remark = #{remark,jdbcType=VARCHAR}, </if>  </set> "
			+"where id = #{id,jdbcType=INTEGER}"
			+"</script>" 
			})
	@Override
	public void updateSelective(ServerMonitor entity);

	
	/**
	 * 
	 * 功能描述：查询所有
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月24日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({ "select * from server_monitor" })
	@Results({@Result(column = "id", property = "id" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "host", property = "host" , jdbcType = JdbcType.VARCHAR ),@Result(column = "cpu", property = "cpu" , jdbcType = JdbcType.VARCHAR ),@Result(column = "mem", property = "mem" , jdbcType = JdbcType.VARCHAR ),@Result(column = "disk", property = "disk" , jdbcType = JdbcType.VARCHAR ),@Result(column = "monitor_time", property = "monitorTime" , jdbcType = JdbcType.TIMESTAMP ),@Result(column = "remark", property = "remark" , jdbcType = JdbcType.VARCHAR ) })
	@Override
	public List<ServerMonitor> findAll();

	/**
	 * 
	 * 功能描述：查询总数
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月24日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({ "select count(id) from server_monitor" })
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
	 * @since 2019年07月24日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({ "select * from server_monitor where id = #{id,jdbcType=INTEGER}" })
	@Results({@Result(column = "id", property = "id" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "host", property = "host" , jdbcType = JdbcType.VARCHAR ),@Result(column = "cpu", property = "cpu" , jdbcType = JdbcType.VARCHAR ),@Result(column = "mem", property = "mem" , jdbcType = JdbcType.VARCHAR ),@Result(column = "disk", property = "disk" , jdbcType = JdbcType.VARCHAR ),@Result(column = "monitor_time", property = "monitorTime" , jdbcType = JdbcType.TIMESTAMP ),@Result(column = "remark", property = "remark" , jdbcType = JdbcType.VARCHAR ) })
	@Override
	public ServerMonitor findById(Serializable id);

	/**
	 * 
	 * 功能描述：根据查询对象查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月24日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({
			"<script>"
			+"select * from server_monitor "
			+"<where> 1 = 1 "
			+"<if test=\"id != null\" > and id = #{id,jdbcType=INTEGER} </if><if test=\"host != null\" > and host = #{host,jdbcType=VARCHAR} </if><if test=\"cpu != null\" > and cpu = #{cpu,jdbcType=VARCHAR} </if><if test=\"mem != null\" > and mem = #{mem,jdbcType=VARCHAR} </if><if test=\"disk != null\" > and disk = #{disk,jdbcType=VARCHAR} </if><if test=\"monitorTime != null\" > and monitor_time = #{monitorTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
			+"</where> order by id </script>" 
			})
	@Results({@Result(column = "id", property = "id" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "host", property = "host" , jdbcType = JdbcType.VARCHAR ),@Result(column = "cpu", property = "cpu" , jdbcType = JdbcType.VARCHAR ),@Result(column = "mem", property = "mem" , jdbcType = JdbcType.VARCHAR ),@Result(column = "disk", property = "disk" , jdbcType = JdbcType.VARCHAR ),@Result(column = "monitor_time", property = "monitorTime" , jdbcType = JdbcType.TIMESTAMP ),@Result(column = "remark", property = "remark" , jdbcType = JdbcType.VARCHAR ) })
	@Override
	public List<ServerMonitor> findList(QueryInterface query);

	/**
	 * 
	 * 功能描述：根据查询对象查询记录数
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月24日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({
			"<script>"
			+"select count(id) from server_monitor "
			+"<where> 1 = 1 "
			+"<if test=\"id != null\" > and id = #{id,jdbcType=INTEGER} </if><if test=\"host != null\" > and host = #{host,jdbcType=VARCHAR} </if><if test=\"cpu != null\" > and cpu = #{cpu,jdbcType=VARCHAR} </if><if test=\"mem != null\" > and mem = #{mem,jdbcType=VARCHAR} </if><if test=\"disk != null\" > and disk = #{disk,jdbcType=VARCHAR} </if><if test=\"monitorTime != null\" > and monitor_time = #{monitorTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
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
	 * @since 2019年07月24日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({
			"<script>"
			+"select * from server_monitor "
			+"<where> 1 = 1 "
			+"<if test=\"id != null\" > and id = #{id,jdbcType=INTEGER} </if><if test=\"host != null\" > and host = #{host,jdbcType=VARCHAR} </if><if test=\"cpu != null\" > and cpu = #{cpu,jdbcType=VARCHAR} </if><if test=\"mem != null\" > and mem = #{mem,jdbcType=VARCHAR} </if><if test=\"disk != null\" > and disk = #{disk,jdbcType=VARCHAR} </if><if test=\"monitorTime != null\" > and monitor_time = #{monitorTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
			+"</where> order by id "
			+"<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+"</script>" 
			})
	@Results({@Result(column = "id", property = "id" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "host", property = "host" , jdbcType = JdbcType.VARCHAR ),@Result(column = "cpu", property = "cpu" , jdbcType = JdbcType.VARCHAR ),@Result(column = "mem", property = "mem" , jdbcType = JdbcType.VARCHAR ),@Result(column = "disk", property = "disk" , jdbcType = JdbcType.VARCHAR ),@Result(column = "monitor_time", property = "monitorTime" , jdbcType = JdbcType.TIMESTAMP ),@Result(column = "remark", property = "remark" , jdbcType = JdbcType.VARCHAR ) })
	@Override
	public List<ServerMonitor> findPaginationDataByCondition(QueryInterface query);
	
	
	@Delete(" TRUNCATE server_monitor; ")
	public int truncateTable();

}

