package com.example.demo.Jl.personMapper;

import com.example.demo.Jl.personDao.diaryDao;
import com.example.demo.Jl.util.utilDao.pageDao;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface diaryMapper {
    /**
     * 限制查询 时间逆序 diary（日记）；
     * @return
     */
    @Select("select * from diary where userId=#{id} order by createTime desc limit #{page.startRecord},#{page.maxRecordCount} ")
    List<diaryDao> findLimit(pageDao page,String id);

    /**
     * 查询diary记录数
     * @return
     */
    @Select("select count(*) from diary")
    int countDiary();

    /**
     * 按userId 时间逆序 查询diary
     * @param Id
     * @return
     */
    @Select("select * from diary where userId = #{id} order by createTime desc")
    List<diaryDao> findAllByUserId(String Id);

    @Delete("delete from diary where id = #{id}")
    int deleteById(int id);

    @Insert("insert into diary(userId,title,content,notes,img,createTime) values(#{userId},#{title},#{content},#{notes},#{img},#{createTime})")
    int insertDaily(diaryDao dao);
}
