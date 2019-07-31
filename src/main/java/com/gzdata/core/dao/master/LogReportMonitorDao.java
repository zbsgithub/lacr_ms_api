
                                                            

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
import com.gzdata.core.model.LogReportMonitor;

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
public interface LogReportMonitorDao extends BaseDAOInterface<LogReportMonitor> {

	 	
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
	@Insert({ "insert into log_report_monitor ( id,slave_node,report_state,report_time,remark,update_time)  values (#{id,jdbcType=INTEGER},#{slaveNode,jdbcType=VARCHAR},#{reportState,jdbcType=VARCHAR},#{reportTime,jdbcType=TIMESTAMP},#{remark,jdbcType=VARCHAR},#{updateTime,jdbcType=TIMESTAMP})" })
	@Override
	 	@Options(useGeneratedKeys = true, keyProperty = "id")
		public void insert(LogReportMonitor entity);

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
			+"insert into log_report_monitor "
		    +"<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"slaveNode != null\" > slave_node, </if> <if test=\"reportState != null\" > report_state, </if> <if test=\"reportTime != null\" > report_time, </if> <if test=\"remark != null\" > remark, </if> <if test=\"updateTime != null\" > update_time, </if>  </trim> "
		    +" <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=INTEGER}, </if> <if test=\"slaveNode != null\" > #{slaveNode,jdbcType=VARCHAR}, </if> <if test=\"reportState != null\" > #{reportState,jdbcType=VARCHAR}, </if> <if test=\"reportTime != null\" > #{reportTime,jdbcType=TIMESTAMP}, </if> <if test=\"remark != null\" > #{remark,jdbcType=VARCHAR}, </if> <if test=\"updateTime != null\" > #{updateTime,jdbcType=TIMESTAMP}, </if> </trim>"
		    +"</script>" 
			})
	@Override
	 	@Options(useGeneratedKeys = true, keyProperty = "id")
		public void insertSelective(LogReportMonitor entity);
	
	

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
	@Delete({ "delete from log_report_monitor where id = #{id,jdbcType=INTEGER}" })
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
			+"delete from log_report_monitor where id in "
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
	@Update({ "update log_report_monitor set id= #{id,jdbcType=INTEGER},slave_node= #{slaveNode,jdbcType=VARCHAR},report_state= #{reportState,jdbcType=VARCHAR},report_time= #{reportTime,jdbcType=TIMESTAMP},remark= #{remark,jdbcType=VARCHAR},update_time= #{updateTime,jdbcType=TIMESTAMP} where id = #{id,jdbcType=INTEGER} " })
	@Override
	public void update(LogReportMonitor entity);
	
	

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
			+"update log_report_monitor "
			+"<set > <if test=\"id != null\" > id = #{id,jdbcType=INTEGER}, </if> <if test=\"slaveNode != null\" > slave_node = #{slaveNode,jdbcType=VARCHAR}, </if> <if test=\"reportState != null\" > report_state = #{reportState,jdbcType=VARCHAR}, </if> <if test=\"reportTime != null\" > report_time = #{reportTime,jdbcType=TIMESTAMP}, </if> <if test=\"remark != null\" > remark = #{remark,jdbcType=VARCHAR}, </if> <if test=\"updateTime != null\" > update_time = #{updateTime,jdbcType=TIMESTAMP}, </if>  </set> "
			+"where id = #{id,jdbcType=INTEGER}"
			+"</script>" 
			})
	@Override
	public void updateSelective(LogReportMonitor entity);

	
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
	@Select({ "select * from log_report_monitor" })
	@Results({@Result(column = "id", property = "id" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "slave_node", property = "slaveNode" , jdbcType = JdbcType.VARCHAR ),@Result(column = "report_state", property = "reportState" , jdbcType = JdbcType.VARCHAR ),@Result(column = "report_time", property = "reportTime" , jdbcType = JdbcType.TIMESTAMP ),@Result(column = "remark", property = "remark" , jdbcType = JdbcType.VARCHAR ),@Result(column = "update_time", property = "updateTime" , jdbcType = JdbcType.TIMESTAMP ) })
	@Override
	public List<LogReportMonitor> findAll();

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
	@Select({ "select count(id) from log_report_monitor" })
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
	@Select({ "select * from log_report_monitor where id = #{id,jdbcType=INTEGER}" })
	@Results({@Result(column = "id", property = "id" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "slave_node", property = "slaveNode" , jdbcType = JdbcType.VARCHAR ),@Result(column = "report_state", property = "reportState" , jdbcType = JdbcType.VARCHAR ),@Result(column = "report_time", property = "reportTime" , jdbcType = JdbcType.TIMESTAMP ),@Result(column = "remark", property = "remark" , jdbcType = JdbcType.VARCHAR ),@Result(column = "update_time", property = "updateTime" , jdbcType = JdbcType.TIMESTAMP ) })
	@Override
	public LogReportMonitor findById(Serializable id);

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
			+"select * from log_report_monitor "
			+"<where> 1 = 1 "
			+"<if test=\"id != null\" > and id = #{id,jdbcType=INTEGER} </if><if test=\"slaveNode != null\" > and slave_node = #{slaveNode,jdbcType=VARCHAR} </if><if test=\"reportState != null\" > and report_state = #{reportState,jdbcType=VARCHAR} </if><if test=\"reportTime != null\" > and report_time = #{reportTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if><if test=\"updateTime != null\" > and update_time = #{updateTime,jdbcType=TIMESTAMP} </if> "
			+"</where> order by id </script>" 
			})
	@Results({@Result(column = "id", property = "id" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "slave_node", property = "slaveNode" , jdbcType = JdbcType.VARCHAR ),@Result(column = "report_state", property = "reportState" , jdbcType = JdbcType.VARCHAR ),@Result(column = "report_time", property = "reportTime" , jdbcType = JdbcType.TIMESTAMP ),@Result(column = "remark", property = "remark" , jdbcType = JdbcType.VARCHAR ),@Result(column = "update_time", property = "updateTime" , jdbcType = JdbcType.TIMESTAMP ) })
	@Override
	public List<LogReportMonitor> findList(QueryInterface query);

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
			+"select count(id) from log_report_monitor "
			+"<where> 1 = 1 "
			+"<if test=\"id != null\" > and id = #{id,jdbcType=INTEGER} </if><if test=\"slaveNode != null\" > and slave_node = #{slaveNode,jdbcType=VARCHAR} </if><if test=\"reportState != null\" > and report_state = #{reportState,jdbcType=VARCHAR} </if><if test=\"reportTime != null\" > and report_time = #{reportTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if><if test=\"updateTime != null\" > and update_time = #{updateTime,jdbcType=TIMESTAMP} </if> "
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
			+"select * from log_report_monitor "
			+"<where> 1 = 1 "
			+"<if test=\"id != null\" > and id = #{id,jdbcType=INTEGER} </if><if test=\"slaveNode != null\" > and slave_node = #{slaveNode,jdbcType=VARCHAR} </if><if test=\"reportState != null\" > and report_state = #{reportState,jdbcType=VARCHAR} </if><if test=\"reportTime != null\" > and report_time = #{reportTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if><if test=\"updateTime != null\" > and update_time = #{updateTime,jdbcType=TIMESTAMP} </if> "
			+"</where> order by id "
			+"<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+"</script>" 
			})
	@Results({@Result(column = "id", property = "id" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "slave_node", property = "slaveNode" , jdbcType = JdbcType.VARCHAR ),@Result(column = "report_state", property = "reportState" , jdbcType = JdbcType.VARCHAR ),@Result(column = "report_time", property = "reportTime" , jdbcType = JdbcType.TIMESTAMP ),@Result(column = "remark", property = "remark" , jdbcType = JdbcType.VARCHAR ),@Result(column = "update_time", property = "updateTime" , jdbcType = JdbcType.TIMESTAMP ) })
	@Override
	public List<LogReportMonitor> findPaginationDataByCondition(QueryInterface query);

	/**
	 * 
	 * 功能描述：clear table data
	 *
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2019年7月26日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Delete(" TRUNCATE log_report_monitor; ")
	public int truncateTable();
}

