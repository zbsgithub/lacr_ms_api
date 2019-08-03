
                                                                                                                

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
import com.gzdata.core.model.TvInfos;

/**
 * 
 *  说明：对象的数据访问类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2019年07月30日
 */

public interface TvInfosDao extends BaseDAOInterface<TvInfos> {

	 	
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
	@Insert({ "insert into tv_infos ( id,on,dn,dm,did,gzid,area,machine,packed,packed_at,created_at,updated_at)  values (#{id,jdbcType=INTEGER},#{on,jdbcType=VARCHAR},#{dn,jdbcType=VARCHAR},#{dm,jdbcType=VARCHAR},#{did,jdbcType=VARCHAR},#{gzid,jdbcType=VARCHAR},#{area,jdbcType=VARCHAR},#{machine,jdbcType=VARCHAR},#{packed,jdbcType=TINYINT},#{packedAt,jdbcType=TIMESTAMP},#{createdAt,jdbcType=TIMESTAMP},#{updatedAt,jdbcType=TIMESTAMP})" })
	@Override
	 	@Options(useGeneratedKeys = true, keyProperty = "id")
		public void insert(TvInfos entity);

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
	@Insert({
			"<script>"
			+"insert into tv_infos "
		    +"<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"on != null\" > on, </if> <if test=\"dn != null\" > dn, </if> <if test=\"dm != null\" > dm, </if> <if test=\"did != null\" > did, </if> <if test=\"gzid != null\" > gzid, </if> <if test=\"area != null\" > area, </if> <if test=\"machine != null\" > machine, </if> <if test=\"packed != null\" > packed, </if> <if test=\"packedAt != null\" > packed_at, </if> <if test=\"createdAt != null\" > created_at, </if> <if test=\"updatedAt != null\" > updated_at, </if>  </trim> "
		    +" <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=INTEGER}, </if> <if test=\"on != null\" > #{on,jdbcType=VARCHAR}, </if> <if test=\"dn != null\" > #{dn,jdbcType=VARCHAR}, </if> <if test=\"dm != null\" > #{dm,jdbcType=VARCHAR}, </if> <if test=\"did != null\" > #{did,jdbcType=VARCHAR}, </if> <if test=\"gzid != null\" > #{gzid,jdbcType=VARCHAR}, </if> <if test=\"area != null\" > #{area,jdbcType=VARCHAR}, </if> <if test=\"machine != null\" > #{machine,jdbcType=VARCHAR}, </if> <if test=\"packed != null\" > #{packed,jdbcType=TINYINT}, </if> <if test=\"packedAt != null\" > #{packedAt,jdbcType=TIMESTAMP}, </if> <if test=\"createdAt != null\" > #{createdAt,jdbcType=TIMESTAMP}, </if> <if test=\"updatedAt != null\" > #{updatedAt,jdbcType=TIMESTAMP}, </if> </trim>"
		    +"</script>" 
			})
	@Override
	 	@Options(useGeneratedKeys = true, keyProperty = "id")
		public void insertSelective(TvInfos entity);
	
	

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
	@Delete({ "delete from tv_infos where id = #{id,jdbcType=INTEGER}" })
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
	@Delete({
			"<script>"
			+"delete from tv_infos where id in "
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
	 * @since 2019年07月30日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Update({ "update tv_infos set id= #{id,jdbcType=INTEGER},on= #{on,jdbcType=VARCHAR},dn= #{dn,jdbcType=VARCHAR},dm= #{dm,jdbcType=VARCHAR},did= #{did,jdbcType=VARCHAR},gzid= #{gzid,jdbcType=VARCHAR},area= #{area,jdbcType=VARCHAR},machine= #{machine,jdbcType=VARCHAR},packed= #{packed,jdbcType=TINYINT},packed_at= #{packedAt,jdbcType=TIMESTAMP},created_at= #{createdAt,jdbcType=TIMESTAMP},updated_at= #{updatedAt,jdbcType=TIMESTAMP} where id = #{id,jdbcType=INTEGER} " })
	@Override
	public void update(TvInfos entity);
	
	

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
	@Update({
			"<script>"
			+"update tv_infos "
			+"<set > <if test=\"id != null\" > id = #{id,jdbcType=INTEGER}, </if> <if test=\"on != null\" > on = #{on,jdbcType=VARCHAR}, </if> <if test=\"dn != null\" > dn = #{dn,jdbcType=VARCHAR}, </if> <if test=\"dm != null\" > dm = #{dm,jdbcType=VARCHAR}, </if> <if test=\"did != null\" > did = #{did,jdbcType=VARCHAR}, </if> <if test=\"gzid != null\" > gzid = #{gzid,jdbcType=VARCHAR}, </if> <if test=\"area != null\" > area = #{area,jdbcType=VARCHAR}, </if> <if test=\"machine != null\" > machine = #{machine,jdbcType=VARCHAR}, </if> <if test=\"packed != null\" > packed = #{packed,jdbcType=TINYINT}, </if> <if test=\"packedAt != null\" > packed_at = #{packedAt,jdbcType=TIMESTAMP}, </if> <if test=\"createdAt != null\" > created_at = #{createdAt,jdbcType=TIMESTAMP}, </if> <if test=\"updatedAt != null\" > updated_at = #{updatedAt,jdbcType=TIMESTAMP}, </if>  </set> "
			+"where id = #{id,jdbcType=INTEGER}"
			+"</script>" 
			})
	@Override
	public void updateSelective(TvInfos entity);

	
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
	@Select({ "select * from tv_infos" })
	@Results({@Result(column = "id", property = "id" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "on", property = "on" , jdbcType = JdbcType.VARCHAR ),@Result(column = "dn", property = "dn" , jdbcType = JdbcType.VARCHAR ),@Result(column = "dm", property = "dm" , jdbcType = JdbcType.VARCHAR ),@Result(column = "did", property = "did" , jdbcType = JdbcType.VARCHAR ),@Result(column = "gzid", property = "gzid" , jdbcType = JdbcType.VARCHAR ),@Result(column = "area", property = "area" , jdbcType = JdbcType.VARCHAR ),@Result(column = "machine", property = "machine" , jdbcType = JdbcType.VARCHAR ),@Result(column = "packed", property = "packed" , jdbcType = JdbcType.TINYINT ),@Result(column = "packed_at", property = "packedAt" , jdbcType = JdbcType.TIMESTAMP ),@Result(column = "created_at", property = "createdAt" , jdbcType = JdbcType.TIMESTAMP ),@Result(column = "updated_at", property = "updatedAt" , jdbcType = JdbcType.TIMESTAMP ) })
	@Override
	public List<TvInfos> findAll();

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
	@Select({ "select count(id) from tv_infos" })
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
	@Select({ "select * from tv_infos where id = #{id,jdbcType=INTEGER}" })
	@Results({@Result(column = "id", property = "id" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "on", property = "on" , jdbcType = JdbcType.VARCHAR ),@Result(column = "dn", property = "dn" , jdbcType = JdbcType.VARCHAR ),@Result(column = "dm", property = "dm" , jdbcType = JdbcType.VARCHAR ),@Result(column = "did", property = "did" , jdbcType = JdbcType.VARCHAR ),@Result(column = "gzid", property = "gzid" , jdbcType = JdbcType.VARCHAR ),@Result(column = "area", property = "area" , jdbcType = JdbcType.VARCHAR ),@Result(column = "machine", property = "machine" , jdbcType = JdbcType.VARCHAR ),@Result(column = "packed", property = "packed" , jdbcType = JdbcType.TINYINT ),@Result(column = "packed_at", property = "packedAt" , jdbcType = JdbcType.TIMESTAMP ),@Result(column = "created_at", property = "createdAt" , jdbcType = JdbcType.TIMESTAMP ),@Result(column = "updated_at", property = "updatedAt" , jdbcType = JdbcType.TIMESTAMP ) })
	@Override
	public TvInfos findById(Serializable id);

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
	@Select({
			"<script>"
			+"select * from tv_infos "
			+"<where> 1 = 1 "
			+"<if test=\"id != null\" > and id = #{id,jdbcType=INTEGER} </if><if test=\"on != null\" > and on = #{on,jdbcType=VARCHAR} </if><if test=\"dn != null\" > and dn = #{dn,jdbcType=VARCHAR} </if><if test=\"dm != null\" > and dm = #{dm,jdbcType=VARCHAR} </if><if test=\"did != null\" > and did = #{did,jdbcType=VARCHAR} </if><if test=\"gzid != null\" > and gzid = #{gzid,jdbcType=VARCHAR} </if><if test=\"area != null\" > and area = #{area,jdbcType=VARCHAR} </if><if test=\"machine != null\" > and machine = #{machine,jdbcType=VARCHAR} </if><if test=\"packed != null\" > and packed = #{packed,jdbcType=TINYINT} </if><if test=\"packedAt != null\" > and packed_at = #{packedAt,jdbcType=TIMESTAMP} </if><if test=\"createdAt != null\" > and created_at = #{createdAt,jdbcType=TIMESTAMP} </if><if test=\"updatedAt != null\" > and updated_at = #{updatedAt,jdbcType=TIMESTAMP} </if> "
			+"</where> order by id </script>" 
			})
	@Results({@Result(column = "id", property = "id" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "on", property = "on" , jdbcType = JdbcType.VARCHAR ),@Result(column = "dn", property = "dn" , jdbcType = JdbcType.VARCHAR ),@Result(column = "dm", property = "dm" , jdbcType = JdbcType.VARCHAR ),@Result(column = "did", property = "did" , jdbcType = JdbcType.VARCHAR ),@Result(column = "gzid", property = "gzid" , jdbcType = JdbcType.VARCHAR ),@Result(column = "area", property = "area" , jdbcType = JdbcType.VARCHAR ),@Result(column = "machine", property = "machine" , jdbcType = JdbcType.VARCHAR ),@Result(column = "packed", property = "packed" , jdbcType = JdbcType.TINYINT ),@Result(column = "packed_at", property = "packedAt" , jdbcType = JdbcType.TIMESTAMP ),@Result(column = "created_at", property = "createdAt" , jdbcType = JdbcType.TIMESTAMP ),@Result(column = "updated_at", property = "updatedAt" , jdbcType = JdbcType.TIMESTAMP ) })
	@Override
	public List<TvInfos> findList(QueryInterface query);

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
	@Select({
			"<script>"
			+"select count(id) from tv_infos "
			+"<where> 1 = 1 "
			+"<if test=\"id != null\" > and id = #{id,jdbcType=INTEGER} </if><if test=\"on != null\" > and on = #{on,jdbcType=VARCHAR} </if><if test=\"dn != null\" > and dn = #{dn,jdbcType=VARCHAR} </if><if test=\"dm != null\" > and dm = #{dm,jdbcType=VARCHAR} </if><if test=\"did != null\" > and did = #{did,jdbcType=VARCHAR} </if><if test=\"gzid != null\" > and gzid = #{gzid,jdbcType=VARCHAR} </if><if test=\"area != null\" > and area = #{area,jdbcType=VARCHAR} </if><if test=\"machine != null\" > and machine = #{machine,jdbcType=VARCHAR} </if><if test=\"packed != null\" > and packed = #{packed,jdbcType=TINYINT} </if><if test=\"packedAt != null\" > and packed_at = #{packedAt,jdbcType=TIMESTAMP} </if><if test=\"createdAt != null\" > and created_at = #{createdAt,jdbcType=TIMESTAMP} </if><if test=\"updatedAt != null\" > and updated_at = #{updatedAt,jdbcType=TIMESTAMP} </if> "
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
	 * @since 2019年07月30日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({
			"<script>"
			+"select * from tv_infos "
			+"<where> 1 = 1 "
			+"<if test=\"id != null\" > and id = #{id,jdbcType=INTEGER} </if><if test=\"on != null\" > and on = #{on,jdbcType=VARCHAR} </if><if test=\"dn != null\" > and dn = #{dn,jdbcType=VARCHAR} </if><if test=\"dm != null\" > and dm = #{dm,jdbcType=VARCHAR} </if><if test=\"did != null\" > and did = #{did,jdbcType=VARCHAR} </if><if test=\"gzid != null\" > and gzid = #{gzid,jdbcType=VARCHAR} </if><if test=\"area != null\" > and area = #{area,jdbcType=VARCHAR} </if><if test=\"machine != null\" > and machine = #{machine,jdbcType=VARCHAR} </if><if test=\"packed != null\" > and packed = #{packed,jdbcType=TINYINT} </if><if test=\"packedAt != null\" > and packed_at = #{packedAt,jdbcType=TIMESTAMP} </if><if test=\"createdAt != null\" > and created_at = #{createdAt,jdbcType=TIMESTAMP} </if><if test=\"updatedAt != null\" > and updated_at = #{updatedAt,jdbcType=TIMESTAMP} </if> "
			+"</where> order by id "
			+"<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+"</script>" 
			})
	@Results({@Result(column = "id", property = "id" , jdbcType = JdbcType.INTEGER ,id = true  ),@Result(column = "on", property = "on" , jdbcType = JdbcType.VARCHAR ),@Result(column = "dn", property = "dn" , jdbcType = JdbcType.VARCHAR ),@Result(column = "dm", property = "dm" , jdbcType = JdbcType.VARCHAR ),@Result(column = "did", property = "did" , jdbcType = JdbcType.VARCHAR ),@Result(column = "gzid", property = "gzid" , jdbcType = JdbcType.VARCHAR ),@Result(column = "area", property = "area" , jdbcType = JdbcType.VARCHAR ),@Result(column = "machine", property = "machine" , jdbcType = JdbcType.VARCHAR ),@Result(column = "packed", property = "packed" , jdbcType = JdbcType.TINYINT ),@Result(column = "packed_at", property = "packedAt" , jdbcType = JdbcType.TIMESTAMP ),@Result(column = "created_at", property = "createdAt" , jdbcType = JdbcType.TIMESTAMP ),@Result(column = "updated_at", property = "updatedAt" , jdbcType = JdbcType.TIMESTAMP ) })
	@Override
	public List<TvInfos> findPaginationDataByCondition(QueryInterface query);

}

