package com.gzdata.core.dao.slave;

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
import com.gzdata.core.model.StdChannels;

/**
 * 
 * 说明：对象的数据访问类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2019年07月30日
 */
public interface StdChannelsDao extends BaseDAOInterface<StdChannels> {

	/**
	 * 
	 * 功能描述：保存
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月30日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Insert({ "insert into std_channels ( id,cid,name,station,image,checked,created_at,updated_at,source,area,operator,launcher)  values (#{id,jdbcType=INTEGER},#{cid,jdbcType=VARCHAR},#{name,jdbcType=VARCHAR},#{station,jdbcType=VARCHAR},#{image,jdbcType=VARCHAR},#{checked,jdbcType=TINYINT},#{createdAt,jdbcType=TIMESTAMP},#{updatedAt,jdbcType=TIMESTAMP},#{source,jdbcType=VARCHAR},#{area,jdbcType=VARCHAR},#{operator,jdbcType=VARCHAR},#{launcher,jdbcType=VARCHAR})" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(StdChannels entity);

	/**
	 * 
	 * 功能描述：选择字段保存
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月30日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Insert({ "<script>"
			+ "insert into std_channels "
			+ "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"cid != null\" > cid, </if> <if test=\"name != null\" > name, </if> <if test=\"station != null\" > station, </if> <if test=\"image != null\" > image, </if> <if test=\"checked != null\" > checked, </if> <if test=\"createdAt != null\" > created_at, </if> <if test=\"updatedAt != null\" > updated_at, </if> <if test=\"source != null\" > source, </if> <if test=\"area != null\" > area, </if> <if test=\"operator != null\" > operator, </if> <if test=\"launcher != null\" > launcher, </if>  </trim> "
			+ " <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=INTEGER}, </if> <if test=\"cid != null\" > #{cid,jdbcType=VARCHAR}, </if> <if test=\"name != null\" > #{name,jdbcType=VARCHAR}, </if> <if test=\"station != null\" > #{station,jdbcType=VARCHAR}, </if> <if test=\"image != null\" > #{image,jdbcType=VARCHAR}, </if> <if test=\"checked != null\" > #{checked,jdbcType=TINYINT}, </if> <if test=\"createdAt != null\" > #{createdAt,jdbcType=TIMESTAMP}, </if> <if test=\"updatedAt != null\" > #{updatedAt,jdbcType=TIMESTAMP}, </if> <if test=\"source != null\" > #{source,jdbcType=VARCHAR}, </if> <if test=\"area != null\" > #{area,jdbcType=VARCHAR}, </if> <if test=\"operator != null\" > #{operator,jdbcType=VARCHAR}, </if> <if test=\"launcher != null\" > #{launcher,jdbcType=VARCHAR}, </if> </trim>"
			+ "</script>" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertSelective(StdChannels entity);

	/**
	 * 
	 * 功能描述：根据ID删除
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月30日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Delete({ "delete from std_channels where id = #{id,jdbcType=INTEGER}" })
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
	 * @since 2019年07月30日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Delete({ "<script>"
			+ "delete from std_channels where id in "
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
	 * @since 2019年07月30日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Update({ "update std_channels set id= #{id,jdbcType=INTEGER},cid= #{cid,jdbcType=VARCHAR},name= #{name,jdbcType=VARCHAR},station= #{station,jdbcType=VARCHAR},image= #{image,jdbcType=VARCHAR},checked= #{checked,jdbcType=TINYINT},created_at= #{createdAt,jdbcType=TIMESTAMP},updated_at= #{updatedAt,jdbcType=TIMESTAMP},source= #{source,jdbcType=VARCHAR},area= #{area,jdbcType=VARCHAR},operator= #{operator,jdbcType=VARCHAR},launcher= #{launcher,jdbcType=VARCHAR} where id = #{id,jdbcType=INTEGER} " })
	@Override
	public void update(StdChannels entity);

	/**
	 * 
	 * 功能描述：选择字段更新
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月30日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Update({ "<script>"
			+ "update std_channels "
			+ "<set > <if test=\"id != null\" > id = #{id,jdbcType=INTEGER}, </if> <if test=\"cid != null\" > cid = #{cid,jdbcType=VARCHAR}, </if> <if test=\"name != null\" > name = #{name,jdbcType=VARCHAR}, </if> <if test=\"station != null\" > station = #{station,jdbcType=VARCHAR}, </if> <if test=\"image != null\" > image = #{image,jdbcType=VARCHAR}, </if> <if test=\"checked != null\" > checked = #{checked,jdbcType=TINYINT}, </if> <if test=\"createdAt != null\" > created_at = #{createdAt,jdbcType=TIMESTAMP}, </if> <if test=\"updatedAt != null\" > updated_at = #{updatedAt,jdbcType=TIMESTAMP}, </if> <if test=\"source != null\" > source = #{source,jdbcType=VARCHAR}, </if> <if test=\"area != null\" > area = #{area,jdbcType=VARCHAR}, </if> <if test=\"operator != null\" > operator = #{operator,jdbcType=VARCHAR}, </if> <if test=\"launcher != null\" > launcher = #{launcher,jdbcType=VARCHAR}, </if>  </set> "
			+ "where id = #{id,jdbcType=INTEGER}" + "</script>" })
	@Override
	public void updateSelective(StdChannels entity);

	/**
	 * 
	 * 功能描述：查询所有
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月30日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({ "select * from std_channels" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "cid", property = "cid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "station", property = "station", jdbcType = JdbcType.VARCHAR),
			@Result(column = "image", property = "image", jdbcType = JdbcType.VARCHAR),
			@Result(column = "checked", property = "checked", jdbcType = JdbcType.TINYINT),
			@Result(column = "created_at", property = "createdAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "updated_at", property = "updatedAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "source", property = "source", jdbcType = JdbcType.VARCHAR),
			@Result(column = "area", property = "area", jdbcType = JdbcType.VARCHAR),
			@Result(column = "operator", property = "operator", jdbcType = JdbcType.VARCHAR),
			@Result(column = "launcher", property = "launcher", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<StdChannels> findAll();

	/**
	 * 
	 * 功能描述：查询总数
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月30日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({ "select count(id) from std_channels" })
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
	 * @since 2019年07月30日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({ "select * from std_channels where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "cid", property = "cid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "station", property = "station", jdbcType = JdbcType.VARCHAR),
			@Result(column = "image", property = "image", jdbcType = JdbcType.VARCHAR),
			@Result(column = "checked", property = "checked", jdbcType = JdbcType.TINYINT),
			@Result(column = "created_at", property = "createdAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "updated_at", property = "updatedAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "source", property = "source", jdbcType = JdbcType.VARCHAR),
			@Result(column = "area", property = "area", jdbcType = JdbcType.VARCHAR),
			@Result(column = "operator", property = "operator", jdbcType = JdbcType.VARCHAR),
			@Result(column = "launcher", property = "launcher", jdbcType = JdbcType.VARCHAR) })
	@Override
	public StdChannels findById(Serializable id);

	/**
	 * 
	 * 功能描述：根据查询对象查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月30日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({ "<script>"
			+ "select * from std_channels "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=INTEGER} </if><if test=\"cid != null\" > and cid = #{cid,jdbcType=VARCHAR} </if><if test=\"name != null\" > and name = #{name,jdbcType=VARCHAR} </if><if test=\"station != null\" > and station = #{station,jdbcType=VARCHAR} </if><if test=\"image != null\" > and image = #{image,jdbcType=VARCHAR} </if><if test=\"checked != null\" > and checked = #{checked,jdbcType=TINYINT} </if><if test=\"createdAt != null\" > and created_at = #{createdAt,jdbcType=TIMESTAMP} </if><if test=\"updatedAt != null\" > and updated_at = #{updatedAt,jdbcType=TIMESTAMP} </if><if test=\"source != null\" > and source = #{source,jdbcType=VARCHAR} </if><if test=\"area != null\" > and area = #{area,jdbcType=VARCHAR} </if><if test=\"operator != null\" > and operator = #{operator,jdbcType=VARCHAR} </if><if test=\"launcher != null\" > and launcher = #{launcher,jdbcType=VARCHAR} </if> "
			+ "</where> order by id </script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "cid", property = "cid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "station", property = "station", jdbcType = JdbcType.VARCHAR),
			@Result(column = "image", property = "image", jdbcType = JdbcType.VARCHAR),
			@Result(column = "checked", property = "checked", jdbcType = JdbcType.TINYINT),
			@Result(column = "created_at", property = "createdAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "updated_at", property = "updatedAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "source", property = "source", jdbcType = JdbcType.VARCHAR),
			@Result(column = "area", property = "area", jdbcType = JdbcType.VARCHAR),
			@Result(column = "operator", property = "operator", jdbcType = JdbcType.VARCHAR),
			@Result(column = "launcher", property = "launcher", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<StdChannels> findList(QueryInterface query);

	/**
	 * 
	 * 功能描述：根据查询对象查询记录数
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2019年07月30日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({ "<script>"
			+ "select count(id) from std_channels "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=INTEGER} </if><if test=\"cid != null\" > and cid = #{cid,jdbcType=VARCHAR} </if><if test=\"name != null and name!= '' \" > and name like CONCAT('%',#{name,jdbcType=VARCHAR},'%')  </if><if test=\"station != null\" > and station = #{station,jdbcType=VARCHAR} </if><if test=\"image != null\" > and image = #{image,jdbcType=VARCHAR} </if><if test=\"checked != null\" > and checked = #{checked,jdbcType=TINYINT} </if><if test=\"createdAt != null\" > and created_at = #{createdAt,jdbcType=TIMESTAMP} </if><if test=\"updatedAt != null\" > and updated_at = #{updatedAt,jdbcType=TIMESTAMP} </if><if test=\"source != null\" > and source = #{source,jdbcType=VARCHAR} </if><if test=\"area != null\" > and area = #{area,jdbcType=VARCHAR} </if><if test=\"operator != null\" > and operator = #{operator,jdbcType=VARCHAR} </if><if test=\"launcher != null\" > and launcher = #{launcher,jdbcType=VARCHAR} </if> "
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
	 * @since 2019年07月30日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({ "<script>"
			+ "select * from std_channels "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=INTEGER} </if><if test=\"cid != null\" > and cid = #{cid,jdbcType=VARCHAR} </if><if test=\"name != null and name !='' \" > and name like CONCAT('%',#{name,jdbcType=VARCHAR},'%') </if><if test=\"station != null\" > and station = #{station,jdbcType=VARCHAR} </if><if test=\"image != null\" > and image = #{image,jdbcType=VARCHAR} </if><if test=\"checked != null\" > and checked = #{checked,jdbcType=TINYINT} </if><if test=\"createdAt != null\" > and created_at = #{createdAt,jdbcType=TIMESTAMP} </if><if test=\"updatedAt != null\" > and updated_at = #{updatedAt,jdbcType=TIMESTAMP} </if><if test=\"source != null\" > and source = #{source,jdbcType=VARCHAR} </if><if test=\"area != null\" > and area = #{area,jdbcType=VARCHAR} </if><if test=\"operator != null\" > and operator = #{operator,jdbcType=VARCHAR} </if><if test=\"launcher != null\" > and launcher = #{launcher,jdbcType=VARCHAR} </if> "
			+ "</where> order by id "
			+ "<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+ "</script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "cid", property = "cid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
			@Result(column = "station", property = "station", jdbcType = JdbcType.VARCHAR),
			@Result(column = "image", property = "image", jdbcType = JdbcType.VARCHAR),
			@Result(column = "checked", property = "checked", jdbcType = JdbcType.TINYINT),
			@Result(column = "created_at", property = "createdAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "updated_at", property = "updatedAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "source", property = "source", jdbcType = JdbcType.VARCHAR),
			@Result(column = "area", property = "area", jdbcType = JdbcType.VARCHAR),
			@Result(column = "operator", property = "operator", jdbcType = JdbcType.VARCHAR),
			@Result(column = "launcher", property = "launcher", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<StdChannels> findPaginationDataByCondition(QueryInterface query);
	
	
	/*--一下接口未老接口遗留的-----------*/

	/**
	 * 
	 * 功能描述：根据频道名称查询对象
	 *
	 * @param name
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2019年4月15日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select(" SELECT * FROM std_channels s WHERE s.`name` = #{name} ; ")
	@Results({
		@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
		@Result(column = "cid", property = "cid", jdbcType = JdbcType.VARCHAR),
		@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
		@Result(column = "station", property = "station", jdbcType = JdbcType.VARCHAR),
		@Result(column = "image", property = "image", jdbcType = JdbcType.VARCHAR),
		@Result(column = "checked", property = "checked", jdbcType = JdbcType.TINYINT),
		@Result(column = "created_at", property = "createdAt", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "updated_at", property = "updatedAt", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "source", property = "source", jdbcType = JdbcType.VARCHAR),
		@Result(column = "area", property = "area", jdbcType = JdbcType.VARCHAR),
		@Result(column = "operator", property = "operator", jdbcType = JdbcType.VARCHAR),
		@Result(column = "launcher", property = "launcher", jdbcType = JdbcType.VARCHAR) })
	public List<StdChannels> findStdNameByName(@Param("name") String name);
	
	/**
	 * 
	 * 功能描述：根据标准频道ID查询对象
	 *
	 * @param name
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2019年4月15日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select(" SELECT * FROM std_channels s WHERE s.`cid` = #{chId} ; ")
	@Results({
		@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
		@Result(column = "cid", property = "cid", jdbcType = JdbcType.VARCHAR),
		@Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
		@Result(column = "station", property = "station", jdbcType = JdbcType.VARCHAR),
		@Result(column = "image", property = "image", jdbcType = JdbcType.VARCHAR),
		@Result(column = "checked", property = "checked", jdbcType = JdbcType.TINYINT),
		@Result(column = "created_at", property = "createdAt", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "updated_at", property = "updatedAt", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "source", property = "source", jdbcType = JdbcType.VARCHAR),
		@Result(column = "area", property = "area", jdbcType = JdbcType.VARCHAR),
		@Result(column = "operator", property = "operator", jdbcType = JdbcType.VARCHAR),
		@Result(column = "launcher", property = "launcher", jdbcType = JdbcType.VARCHAR) })
	public StdChannels findStdInfoByChId(@Param("chId") String chId);

}
