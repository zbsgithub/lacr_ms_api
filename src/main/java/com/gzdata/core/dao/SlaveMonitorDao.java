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
import com.gzdata.core.model.SlaveMonitor;

/**
 * 
 * 说明：对象的数据访问类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2019年07月24日
 * 
 */
public interface SlaveMonitorDao extends BaseDAOInterface<SlaveMonitor> {

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
	@Insert({ "insert into slave_monitor ( id,slave_name,program_name,monitor_time,run_state,remark)  values (#{id,jdbcType=INTEGER},#{slaveName,jdbcType=VARCHAR},#{programName,jdbcType=VARCHAR},#{monitorTime,jdbcType=TIMESTAMP},#{runState,jdbcType=VARCHAR},#{remark,jdbcType=VARCHAR})" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(SlaveMonitor entity);

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
	@Insert({ "<script>"
			+ "insert into slave_monitor "
			+ "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"slaveName != null\" > slave_name, </if> <if test=\"programName != null\" > program_name, </if> <if test=\"monitorTime != null\" > monitor_time, </if> <if test=\"runState != null\" > run_state, </if> <if test=\"remark != null\" > remark, </if>  </trim> "
			+ " <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=INTEGER}, </if> <if test=\"slaveName != null\" > #{slaveName,jdbcType=VARCHAR}, </if> <if test=\"programName != null\" > #{programName,jdbcType=VARCHAR}, </if> <if test=\"monitorTime != null\" > #{monitorTime,jdbcType=TIMESTAMP}, </if> <if test=\"runState != null\" > #{runState,jdbcType=VARCHAR}, </if> <if test=\"remark != null\" > #{remark,jdbcType=VARCHAR}, </if> </trim>"
			+ "</script>" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertSelective(SlaveMonitor entity);

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
	@Delete({ "delete from slave_monitor where id = #{id,jdbcType=INTEGER}" })
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
	@Delete({ "<script>"
			+ "delete from slave_monitor where id in "
			+ "<foreach  item=\"id\"  collection=\"array\" open=\"(\" separator=\",\" close=\")\" > #{id} </foreach>"
			+ "</script>" })
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
	@Update({ "update slave_monitor set id= #{id,jdbcType=INTEGER},slave_name= #{slaveName,jdbcType=VARCHAR},program_name= #{programName,jdbcType=VARCHAR},monitor_time= #{monitorTime,jdbcType=TIMESTAMP},run_state= #{runState,jdbcType=VARCHAR},remark= #{remark,jdbcType=VARCHAR} where id = #{id,jdbcType=INTEGER} " })
	@Override
	public void update(SlaveMonitor entity);

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
	@Update({ "<script>"
			+ "update slave_monitor "
			+ "<set > <if test=\"id != null\" > id = #{id,jdbcType=INTEGER}, </if> <if test=\"slaveName != null\" > slave_name = #{slaveName,jdbcType=VARCHAR}, </if> <if test=\"programName != null\" > program_name = #{programName,jdbcType=VARCHAR}, </if> <if test=\"monitorTime != null\" > monitor_time = #{monitorTime,jdbcType=TIMESTAMP}, </if> <if test=\"runState != null\" > run_state = #{runState,jdbcType=VARCHAR}, </if> <if test=\"remark != null\" > remark = #{remark,jdbcType=VARCHAR}, </if>  </set> "
			+ "where id = #{id,jdbcType=INTEGER}" + "</script>" })
	@Override
	public void updateSelective(SlaveMonitor entity);

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
	@Select({ "select * from slave_monitor" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "slave_name", property = "slaveName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "program_name", property = "programName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "monitor_time", property = "monitorTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "run_state", property = "runState", jdbcType = JdbcType.VARCHAR),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<SlaveMonitor> findAll();

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
	@Select({ "select count(id) from slave_monitor" })
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
	@Select({ "select * from slave_monitor where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "slave_name", property = "slaveName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "program_name", property = "programName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "monitor_time", property = "monitorTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "run_state", property = "runState", jdbcType = JdbcType.VARCHAR),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public SlaveMonitor findById(Serializable id);

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
	@Select({ "<script>"
			+ "select * from slave_monitor "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=INTEGER} </if><if test=\"slaveName != null\" > and slave_name = #{slaveName,jdbcType=VARCHAR} </if><if test=\"programName != null\" > and program_name = #{programName,jdbcType=VARCHAR} </if><if test=\"monitorTime != null\" > and monitor_time = #{monitorTime,jdbcType=TIMESTAMP} </if><if test=\"runState != null\" > and run_state = #{runState,jdbcType=VARCHAR} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
			+ "</where> order by id </script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "slave_name", property = "slaveName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "program_name", property = "programName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "monitor_time", property = "monitorTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "run_state", property = "runState", jdbcType = JdbcType.VARCHAR),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<SlaveMonitor> findList(QueryInterface query);

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
	@Select({ "<script>"
			+ "select count(id) from slave_monitor "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=INTEGER} </if><if test=\"slaveName != null\" > and slave_name = #{slaveName,jdbcType=VARCHAR} </if><if test=\"programName != null\" > and program_name = #{programName,jdbcType=VARCHAR} </if><if test=\"monitorTime != null\" > and monitor_time = #{monitorTime,jdbcType=TIMESTAMP} </if><if test=\"runState != null\" > and run_state = #{runState,jdbcType=VARCHAR} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
			+ "</where></script>" })
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
	@Select({ "<script>"
			+ "select * from slave_monitor "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=INTEGER} </if><if test=\"slaveName != null\" > and slave_name = #{slaveName,jdbcType=VARCHAR} </if><if test=\"programName != null\" > and program_name = #{programName,jdbcType=VARCHAR} </if><if test=\"monitorTime != null\" > and monitor_time = #{monitorTime,jdbcType=TIMESTAMP} </if><if test=\"runState != null\" > and run_state = #{runState,jdbcType=VARCHAR} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
			+ "</where> order by id "
			+ "<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+ "</script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "slave_name", property = "slaveName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "program_name", property = "programName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "monitor_time", property = "monitorTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "run_state", property = "runState", jdbcType = JdbcType.VARCHAR),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<SlaveMonitor> findPaginationDataByCondition(QueryInterface query);

	/**
	 * 
	 * 功能描述：清空表数据
	 *
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2019年7月26日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Delete(" TRUNCATE slave_monitor; ")
	public int clearTable();
}
