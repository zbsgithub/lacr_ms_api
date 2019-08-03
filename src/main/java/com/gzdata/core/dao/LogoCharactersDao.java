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
import com.gzdata.core.model.LogoCharacters;

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
public interface LogoCharactersDao extends BaseDAOInterface<LogoCharacters> {

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
	@Insert({ "insert into logo_characters ( id,cid,chuid,x,y,w,h,mask,temp,best,match,award,pixes,checked,created_at,updated_at,tv_info_id,std_channel_id,std_ch_id,std_ch_name,machine)  values (#{id,jdbcType=INTEGER},#{cid,jdbcType=INTEGER},#{chuid,jdbcType=VARCHAR},#{x,jdbcType=DOUBLE},#{y,jdbcType=DOUBLE},#{w,jdbcType=DOUBLE},#{h,jdbcType=DOUBLE},#{mask,jdbcType=VARCHAR},#{temp,jdbcType=VARCHAR},#{best,jdbcType=VARCHAR},#{match,jdbcType=DOUBLE},#{award,jdbcType=INTEGER},#{pixes,jdbcType=INTEGER},#{checked,jdbcType=TINYINT},#{createdAt,jdbcType=TIMESTAMP},#{updatedAt,jdbcType=TIMESTAMP},#{tvInfoId,jdbcType=INTEGER},#{stdChannelId,jdbcType=INTEGER},#{stdChId,jdbcType=VARCHAR},#{stdChName,jdbcType=VARCHAR},#{machine,jdbcType=VARCHAR})" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(LogoCharacters entity);

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
			+ "insert into logo_characters "
			+ "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"cid != null\" > cid, </if> <if test=\"chuid != null\" > chuid, </if> <if test=\"x != null\" > x, </if> <if test=\"y != null\" > y, </if> <if test=\"w != null\" > w, </if> <if test=\"h != null\" > h, </if> <if test=\"mask != null\" > mask, </if> <if test=\"temp != null\" > temp, </if> <if test=\"best != null\" > best, </if> <if test=\"match != null\" > match, </if> <if test=\"award != null\" > award, </if> <if test=\"pixes != null\" > pixes, </if> <if test=\"checked != null\" > checked, </if> <if test=\"createdAt != null\" > created_at, </if> <if test=\"updatedAt != null\" > updated_at, </if> <if test=\"tvInfoId != null\" > tv_info_id, </if> <if test=\"stdChannelId != null\" > std_channel_id, </if> <if test=\"stdChId != null\" > std_ch_id, </if> <if test=\"stdChName != null\" > std_ch_name, </if> <if test=\"machine != null\" > machine, </if>  </trim> "
			+ " <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=INTEGER}, </if> <if test=\"cid != null\" > #{cid,jdbcType=INTEGER}, </if> <if test=\"chuid != null\" > #{chuid,jdbcType=VARCHAR}, </if> <if test=\"x != null\" > #{x,jdbcType=DOUBLE}, </if> <if test=\"y != null\" > #{y,jdbcType=DOUBLE}, </if> <if test=\"w != null\" > #{w,jdbcType=DOUBLE}, </if> <if test=\"h != null\" > #{h,jdbcType=DOUBLE}, </if> <if test=\"mask != null\" > #{mask,jdbcType=VARCHAR}, </if> <if test=\"temp != null\" > #{temp,jdbcType=VARCHAR}, </if> <if test=\"best != null\" > #{best,jdbcType=VARCHAR}, </if> <if test=\"match != null\" > #{match,jdbcType=DOUBLE}, </if> <if test=\"award != null\" > #{award,jdbcType=INTEGER}, </if> <if test=\"pixes != null\" > #{pixes,jdbcType=INTEGER}, </if> <if test=\"checked != null\" > #{checked,jdbcType=TINYINT}, </if> <if test=\"createdAt != null\" > #{createdAt,jdbcType=TIMESTAMP}, </if> <if test=\"updatedAt != null\" > #{updatedAt,jdbcType=TIMESTAMP}, </if> <if test=\"tvInfoId != null\" > #{tvInfoId,jdbcType=INTEGER}, </if> <if test=\"stdChannelId != null\" > #{stdChannelId,jdbcType=INTEGER}, </if> <if test=\"stdChId != null\" > #{stdChId,jdbcType=VARCHAR}, </if> <if test=\"stdChName != null\" > #{stdChName,jdbcType=VARCHAR}, </if> <if test=\"machine != null\" > #{machine,jdbcType=VARCHAR}, </if> </trim>"
			+ "</script>" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertSelective(LogoCharacters entity);

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
	@Delete({ "delete from logo_characters where id = #{id,jdbcType=INTEGER}" })
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
			+ "delete from logo_characters where id in "
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
	@Update({ "update logo_characters set id= #{id,jdbcType=INTEGER},cid= #{cid,jdbcType=INTEGER},chuid= #{chuid,jdbcType=VARCHAR},x= #{x,jdbcType=DOUBLE},y= #{y,jdbcType=DOUBLE},w= #{w,jdbcType=DOUBLE},h= #{h,jdbcType=DOUBLE},mask= #{mask,jdbcType=VARCHAR},temp= #{temp,jdbcType=VARCHAR},best= #{best,jdbcType=VARCHAR},match= #{match,jdbcType=DOUBLE},award= #{award,jdbcType=INTEGER},pixes= #{pixes,jdbcType=INTEGER},checked= #{checked,jdbcType=TINYINT},created_at= #{createdAt,jdbcType=TIMESTAMP},updated_at= #{updatedAt,jdbcType=TIMESTAMP},tv_info_id= #{tvInfoId,jdbcType=INTEGER},std_channel_id= #{stdChannelId,jdbcType=INTEGER},std_ch_id= #{stdChId,jdbcType=VARCHAR},std_ch_name= #{stdChName,jdbcType=VARCHAR},machine= #{machine,jdbcType=VARCHAR} where id = #{id,jdbcType=INTEGER} " })
	@Override
	public void update(LogoCharacters entity);

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
			+ "update logo_characters "
			+ "<set > <if test=\"id != null\" > id = #{id,jdbcType=INTEGER}, </if> <if test=\"cid != null\" > cid = #{cid,jdbcType=INTEGER}, </if> <if test=\"chuid != null\" > chuid = #{chuid,jdbcType=VARCHAR}, </if> <if test=\"x != null\" > x = #{x,jdbcType=DOUBLE}, </if> <if test=\"y != null\" > y = #{y,jdbcType=DOUBLE}, </if> <if test=\"w != null\" > w = #{w,jdbcType=DOUBLE}, </if> <if test=\"h != null\" > h = #{h,jdbcType=DOUBLE}, </if> <if test=\"mask != null\" > mask = #{mask,jdbcType=VARCHAR}, </if> <if test=\"temp != null\" > temp = #{temp,jdbcType=VARCHAR}, </if> <if test=\"best != null\" > best = #{best,jdbcType=VARCHAR}, </if> <if test=\"match != null\" > match = #{match,jdbcType=DOUBLE}, </if> <if test=\"award != null\" > award = #{award,jdbcType=INTEGER}, </if> <if test=\"pixes != null\" > pixes = #{pixes,jdbcType=INTEGER}, </if> <if test=\"checked != null\" > checked = #{checked,jdbcType=TINYINT}, </if> <if test=\"createdAt != null\" > created_at = #{createdAt,jdbcType=TIMESTAMP}, </if> <if test=\"updatedAt != null\" > updated_at = #{updatedAt,jdbcType=TIMESTAMP}, </if> <if test=\"tvInfoId != null\" > tv_info_id = #{tvInfoId,jdbcType=INTEGER}, </if> <if test=\"stdChannelId != null\" > std_channel_id = #{stdChannelId,jdbcType=INTEGER}, </if> <if test=\"stdChId != null\" > std_ch_id = #{stdChId,jdbcType=VARCHAR}, </if> <if test=\"stdChName != null\" > std_ch_name = #{stdChName,jdbcType=VARCHAR}, </if> <if test=\"machine != null\" > machine = #{machine,jdbcType=VARCHAR}, </if>  </set> "
			+ "where id = #{id,jdbcType=INTEGER}" + "</script>" })
	@Override
	public void updateSelective(LogoCharacters entity);

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
	@Select({ "select * from logo_characters" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "cid", property = "cid", jdbcType = JdbcType.INTEGER),
			@Result(column = "chuid", property = "chuid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "x", property = "x", jdbcType = JdbcType.DOUBLE),
			@Result(column = "y", property = "y", jdbcType = JdbcType.DOUBLE),
			@Result(column = "w", property = "w", jdbcType = JdbcType.DOUBLE),
			@Result(column = "h", property = "h", jdbcType = JdbcType.DOUBLE),
			@Result(column = "mask", property = "mask", jdbcType = JdbcType.VARCHAR),
			@Result(column = "temp", property = "temp", jdbcType = JdbcType.VARCHAR),
			@Result(column = "best", property = "best", jdbcType = JdbcType.VARCHAR),
			@Result(column = "match", property = "match", jdbcType = JdbcType.DOUBLE),
			@Result(column = "award", property = "award", jdbcType = JdbcType.INTEGER),
			@Result(column = "pixes", property = "pixes", jdbcType = JdbcType.INTEGER),
			@Result(column = "checked", property = "checked", jdbcType = JdbcType.TINYINT),
			@Result(column = "created_at", property = "createdAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "updated_at", property = "updatedAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "tv_info_id", property = "tvInfoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "std_channel_id", property = "stdChannelId", jdbcType = JdbcType.INTEGER),
			@Result(column = "std_ch_id", property = "stdChId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "std_ch_name", property = "stdChName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "machine", property = "machine", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<LogoCharacters> findAll();

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
	@Select({ "select count(id) from logo_characters" })
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
	@Select({ "select * from logo_characters where id = #{id,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "cid", property = "cid", jdbcType = JdbcType.INTEGER),
			@Result(column = "chuid", property = "chuid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "x", property = "x", jdbcType = JdbcType.DOUBLE),
			@Result(column = "y", property = "y", jdbcType = JdbcType.DOUBLE),
			@Result(column = "w", property = "w", jdbcType = JdbcType.DOUBLE),
			@Result(column = "h", property = "h", jdbcType = JdbcType.DOUBLE),
			@Result(column = "mask", property = "mask", jdbcType = JdbcType.VARCHAR),
			@Result(column = "temp", property = "temp", jdbcType = JdbcType.VARCHAR),
			@Result(column = "best", property = "best", jdbcType = JdbcType.VARCHAR),
			@Result(column = "match", property = "match", jdbcType = JdbcType.DOUBLE),
			@Result(column = "award", property = "award", jdbcType = JdbcType.INTEGER),
			@Result(column = "pixes", property = "pixes", jdbcType = JdbcType.INTEGER),
			@Result(column = "checked", property = "checked", jdbcType = JdbcType.TINYINT),
			@Result(column = "created_at", property = "createdAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "updated_at", property = "updatedAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "tv_info_id", property = "tvInfoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "std_channel_id", property = "stdChannelId", jdbcType = JdbcType.INTEGER),
			@Result(column = "std_ch_id", property = "stdChId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "std_ch_name", property = "stdChName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "machine", property = "machine", jdbcType = JdbcType.VARCHAR) })
	@Override
	public LogoCharacters findById(Serializable id);

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
			+ "select * from logo_characters "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=INTEGER} </if><if test=\"cid != null\" > and cid = #{cid,jdbcType=INTEGER} </if><if test=\"chuid != null\" > and chuid = #{chuid,jdbcType=VARCHAR} </if><if test=\"x != null\" > and x = #{x,jdbcType=DOUBLE} </if><if test=\"y != null\" > and y = #{y,jdbcType=DOUBLE} </if><if test=\"w != null\" > and w = #{w,jdbcType=DOUBLE} </if><if test=\"h != null\" > and h = #{h,jdbcType=DOUBLE} </if><if test=\"mask != null\" > and mask = #{mask,jdbcType=VARCHAR} </if><if test=\"temp != null\" > and temp = #{temp,jdbcType=VARCHAR} </if><if test=\"best != null\" > and best = #{best,jdbcType=VARCHAR} </if><if test=\"match != null\" > and match = #{match,jdbcType=DOUBLE} </if><if test=\"award != null\" > and award = #{award,jdbcType=INTEGER} </if><if test=\"pixes != null\" > and pixes = #{pixes,jdbcType=INTEGER} </if><if test=\"checked != null\" > and checked = #{checked,jdbcType=TINYINT} </if><if test=\"createdAt != null\" > and created_at = #{createdAt,jdbcType=TIMESTAMP} </if><if test=\"updatedAt != null\" > and updated_at = #{updatedAt,jdbcType=TIMESTAMP} </if><if test=\"tvInfoId != null\" > and tv_info_id = #{tvInfoId,jdbcType=INTEGER} </if><if test=\"stdChannelId != null\" > and std_channel_id = #{stdChannelId,jdbcType=INTEGER} </if><if test=\"stdChId != null\" > and std_ch_id = #{stdChId,jdbcType=VARCHAR} </if><if test=\"stdChName != null\" > and std_ch_name = #{stdChName,jdbcType=VARCHAR} </if><if test=\"machine != null\" > and machine = #{machine,jdbcType=VARCHAR} </if> "
			+ "</where> order by id </script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "cid", property = "cid", jdbcType = JdbcType.INTEGER),
			@Result(column = "chuid", property = "chuid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "x", property = "x", jdbcType = JdbcType.DOUBLE),
			@Result(column = "y", property = "y", jdbcType = JdbcType.DOUBLE),
			@Result(column = "w", property = "w", jdbcType = JdbcType.DOUBLE),
			@Result(column = "h", property = "h", jdbcType = JdbcType.DOUBLE),
			@Result(column = "mask", property = "mask", jdbcType = JdbcType.VARCHAR),
			@Result(column = "temp", property = "temp", jdbcType = JdbcType.VARCHAR),
			@Result(column = "best", property = "best", jdbcType = JdbcType.VARCHAR),
			@Result(column = "match", property = "match", jdbcType = JdbcType.DOUBLE),
			@Result(column = "award", property = "award", jdbcType = JdbcType.INTEGER),
			@Result(column = "pixes", property = "pixes", jdbcType = JdbcType.INTEGER),
			@Result(column = "checked", property = "checked", jdbcType = JdbcType.TINYINT),
			@Result(column = "created_at", property = "createdAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "updated_at", property = "updatedAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "tv_info_id", property = "tvInfoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "std_channel_id", property = "stdChannelId", jdbcType = JdbcType.INTEGER),
			@Result(column = "std_ch_id", property = "stdChId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "std_ch_name", property = "stdChName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "machine", property = "machine", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<LogoCharacters> findList(QueryInterface query);

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
			+ "select count(id) from logo_characters "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=INTEGER} </if><if test=\"cid != null\" > and cid = #{cid,jdbcType=INTEGER} </if><if test=\"chuid != null\" > and chuid = #{chuid,jdbcType=VARCHAR} </if><if test=\"x != null\" > and x = #{x,jdbcType=DOUBLE} </if><if test=\"y != null\" > and y = #{y,jdbcType=DOUBLE} </if><if test=\"w != null\" > and w = #{w,jdbcType=DOUBLE} </if><if test=\"h != null\" > and h = #{h,jdbcType=DOUBLE} </if><if test=\"mask != null\" > and mask = #{mask,jdbcType=VARCHAR} </if><if test=\"temp != null\" > and temp = #{temp,jdbcType=VARCHAR} </if><if test=\"best != null\" > and best = #{best,jdbcType=VARCHAR} </if><if test=\"match != null\" > and match = #{match,jdbcType=DOUBLE} </if><if test=\"award != null\" > and award = #{award,jdbcType=INTEGER} </if><if test=\"pixes != null\" > and pixes = #{pixes,jdbcType=INTEGER} </if><if test=\"checked != null\" > and checked = #{checked,jdbcType=TINYINT} </if><if test=\"createdAt != null\" > and created_at = #{createdAt,jdbcType=TIMESTAMP} </if><if test=\"updatedAt != null\" > and updated_at = #{updatedAt,jdbcType=TIMESTAMP} </if><if test=\"tvInfoId != null\" > and tv_info_id = #{tvInfoId,jdbcType=INTEGER} </if><if test=\"stdChannelId != null\" > and std_channel_id = #{stdChannelId,jdbcType=INTEGER} </if><if test=\"stdChId != null\" > and std_ch_id = #{stdChId,jdbcType=VARCHAR} </if><if test=\"stdChName != null\" > and std_ch_name = #{stdChName,jdbcType=VARCHAR} </if><if test=\"machine != null\" > and machine = #{machine,jdbcType=VARCHAR} </if> "
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
			+ "select * from logo_characters "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=INTEGER} </if><if test=\"cid != null\" > and cid = #{cid,jdbcType=INTEGER} </if><if test=\"chuid != null\" > and chuid = #{chuid,jdbcType=VARCHAR} </if><if test=\"x != null\" > and x = #{x,jdbcType=DOUBLE} </if><if test=\"y != null\" > and y = #{y,jdbcType=DOUBLE} </if><if test=\"w != null\" > and w = #{w,jdbcType=DOUBLE} </if><if test=\"h != null\" > and h = #{h,jdbcType=DOUBLE} </if><if test=\"mask != null\" > and mask = #{mask,jdbcType=VARCHAR} </if><if test=\"temp != null\" > and temp = #{temp,jdbcType=VARCHAR} </if><if test=\"best != null\" > and best = #{best,jdbcType=VARCHAR} </if><if test=\"match != null\" > and match = #{match,jdbcType=DOUBLE} </if><if test=\"award != null\" > and award = #{award,jdbcType=INTEGER} </if><if test=\"pixes != null\" > and pixes = #{pixes,jdbcType=INTEGER} </if><if test=\"checked != null\" > and checked = #{checked,jdbcType=TINYINT} </if><if test=\"createdAt != null\" > and created_at = #{createdAt,jdbcType=TIMESTAMP} </if><if test=\"updatedAt != null\" > and updated_at = #{updatedAt,jdbcType=TIMESTAMP} </if><if test=\"tvInfoId != null\" > and tv_info_id = #{tvInfoId,jdbcType=INTEGER} </if><if test=\"stdChannelId != null\" > and std_channel_id = #{stdChannelId,jdbcType=INTEGER} </if><if test=\"stdChId != null\" > and std_ch_id = #{stdChId,jdbcType=VARCHAR} </if><if test=\"stdChName != null\" > and std_ch_name = #{stdChName,jdbcType=VARCHAR} </if><if test=\"machine != null\" > and machine = #{machine,jdbcType=VARCHAR} </if> "
			+ "</where> order by id "
			+ "<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+ "</script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "cid", property = "cid", jdbcType = JdbcType.INTEGER),
			@Result(column = "chuid", property = "chuid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "x", property = "x", jdbcType = JdbcType.DOUBLE),
			@Result(column = "y", property = "y", jdbcType = JdbcType.DOUBLE),
			@Result(column = "w", property = "w", jdbcType = JdbcType.DOUBLE),
			@Result(column = "h", property = "h", jdbcType = JdbcType.DOUBLE),
			@Result(column = "mask", property = "mask", jdbcType = JdbcType.VARCHAR),
			@Result(column = "temp", property = "temp", jdbcType = JdbcType.VARCHAR),
			@Result(column = "best", property = "best", jdbcType = JdbcType.VARCHAR),
			@Result(column = "match", property = "match", jdbcType = JdbcType.DOUBLE),
			@Result(column = "award", property = "award", jdbcType = JdbcType.INTEGER),
			@Result(column = "pixes", property = "pixes", jdbcType = JdbcType.INTEGER),
			@Result(column = "checked", property = "checked", jdbcType = JdbcType.TINYINT),
			@Result(column = "created_at", property = "createdAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "updated_at", property = "updatedAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "tv_info_id", property = "tvInfoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "std_channel_id", property = "stdChannelId", jdbcType = JdbcType.INTEGER),
			@Result(column = "std_ch_id", property = "stdChId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "std_ch_name", property = "stdChName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "machine", property = "machine", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<LogoCharacters> findPaginationDataByCondition(
			QueryInterface query);

}
