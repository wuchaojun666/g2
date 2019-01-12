package g2.mapper.Extra;

import g2.model.Card;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CardExt {
    @Select({
            "select ",
            "distinct",
            "type from",
            "Card"
    })
    List<String> selectType();

    @Select({"<script>",
            "select ",
            "id, type, state, amount, limit",
            "from Card",
            "where 1=1",
            "<when test=\"id!=null and id!=''\">",
            "AND id= #{id,jdbcType=NUMERIC}",
            "</when>",
            "<when test=\"type!=null and type!=''\">",
            "AND type= #{type,jdbcType=VARCHAR}",
            "</when>",
            "</script>"})
    List<Card> selectByIT(@Param("id") Long id, @Param("type") String type);

    @Update({"<script>",
            "update Card",
            "set",
            "amount =",
            " amount + #{money,jdbcType=DOUBLE}",
            "where ",
            "type= #{type,jdbcType=VARCHAR}",
            "AND state= '正常'",
            "</script>"})
    int addMoney(@Param("type") String type, @Param("money") Double money);

    @Update({
            "update Card",
            "set",
            "state= #{state,jdbcType=VARCHAR}",
            "where ",
            "id= #{id,jdbcType=NUMERIC}"})
    int updateByType(@Param("id") Long id, @Param("state") String state);

    @Update({
            "<script>",
            "update Card",
            "set",
            "amount =",
            " amount + #{money,jdbcType=DOUBLE}",
            "where ",
            "id= #{id,jdbcType=NUMERIC}",
            "AND state= '正常'",
            "</script>"})
    int recharge(@Param("id") Long id, @Param("money") Double money);


}