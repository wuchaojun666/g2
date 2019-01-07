package g2.mapper.java;

import g2.model.Unit;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UnitMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Unit
     *
     * @mbg.generated
     */
    @Delete({
        "delete from Unit",
        "where id = #{id,jdbcType=NUMERIC}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Unit
     *
     * @mbg.generated
     */
    @Insert({
        "insert into Unit (id, type, ",
        "account, password, ",
        "pnum)",
        "values (#{id,jdbcType=NUMERIC}, #{type,jdbcType=VARCHAR}, ",
        "#{account,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{pnum,jdbcType=VARCHAR})"
    })
    int insert(Unit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Unit
     *
     * @mbg.generated
     */
    int insertSelective(Unit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Unit
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, type, account, password, pnum",
        "from Unit",
        "where id = #{id,jdbcType=NUMERIC}"
    })
    @ResultMap("g2.mapper.java.UnitMapper.BaseResultMap")
    Unit selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Unit
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Unit record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Unit
     *
     * @mbg.generated
     */
    @Update({
        "update Unit",
        "set type = #{type,jdbcType=VARCHAR},",
          "account = #{account,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "pnum = #{pnum,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=NUMERIC}"
    })
    int updateByPrimaryKey(Unit record);
}