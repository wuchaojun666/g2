package g2.mapper.Extension;

import g2.model.User;
import g2.model.UserKey;
import org.apache.ibatis.annotations.Select;

public interface User {
    @Select({
            "select * from Users where "+
            "name = #{name,jdbcType=VARCHAR} and password = #{password,jdbcType=VARCHAR}"+
                    "and type = #{type,jdbcType=INTEGER}"
    })
    g2.model.User selectByUserKey(UserKey userKey);
}
