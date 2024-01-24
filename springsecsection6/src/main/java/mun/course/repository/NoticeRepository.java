package mun.course.repository;

import mun.course.model.Notice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoticeRepository extends CrudRepository<Notice, Long> {

    @Query(value = "from Notice n where current date between n.noticBegDt and n.noticEndDt")
    List<Notice> findAllActiveNotices();

}
