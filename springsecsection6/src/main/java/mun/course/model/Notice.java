package mun.course.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@Table(name = "notice_details")
@NoArgsConstructor
@AllArgsConstructor
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notice_details_seq")
    @SequenceGenerator(name = "notice_details_seq", allocationSize = 1, sequenceName = "notice_details_seq")
    @Column(name = "notice_id")
    private Long noticeId;

    @Column(name = "notice_summary")
    private String noticeSummary;

    @Column(name = "notice_details")
    private String noticeDetails;

    @Column(name = "notice_begin_dt")
    private Date noticeBeginDt;

    @Column(name = "notice_end_dt")
    private Date noticeEndDt;

    @Column(name = "create_dt")
    private Date createDt;

    @Column(name = "update_dt")
    private Date updateDt;
}
