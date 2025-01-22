package com.xiacong.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiacong.model.domain.Book;
//import io.sapl.spring.method.metadata.PostEnforce;
import org.apache.ibatis.annotations.Param;
//import org.springframework.security.access.prepost.PostAuthorize;
//import org.springframework.security.access.prepost.PostFilter;

import java.util.List;

/**
 * @author 您好
 * @description 针对表【book】的数据库操作Mapper
 * @createDate 2024-05-09 14:50:00
 * @Entity com.xiacong.model.domain.Book
 */
public interface BookMapper extends BaseMapper<Book> {

    //@PreEnforce
    //@PostFilter("T(java.time.LocalDate).now().minusYears(filterObject.ageRating).isAfter(authentication.principal.user.birthday)")
    //@PostFilter("@bvp.filte(filterObject)")
    List<Book> findAll();

    //SAPL
    //@PostEnforce(subject = "authentication.getPrincipal()",
    //        action = "'find book by id'",
    //        resource = "returnObject")
    //原生spring Security SPEL
    //@PostAuthorize("T(java.time.LocalDate).now().minusYears(returnObject.ageRating).isAfter(authentication.principal.user.birthday)")
    //原生spring Security自定义校验器
    //@PostAuthorize("@bvp.validate(returnObject)")
    Book findAllByIdBook(@Param("id") Long id);
}




