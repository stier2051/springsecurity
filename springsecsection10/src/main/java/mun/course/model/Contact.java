package mun.course.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@Table(name = "contact_messages")
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @Column(name = "contact_id")
    private String contactId;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "contact_email")
    private String contactEmail;

    private String subject;

    private String message;

    @Column(name = "create_dt")
    private Date createDt;
}
