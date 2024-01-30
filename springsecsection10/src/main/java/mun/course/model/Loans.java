package mun.course.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@Table(name = "loans")
@NoArgsConstructor
@AllArgsConstructor
public class Loans {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loans_seq")
    @SequenceGenerator(name = "loans_seq", allocationSize = 1, sequenceName = "loans_seq")
    @Column(name = "loan_number")
    private Long loanNumber;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name="start_dt")
    private Date startDt;

    @Column(name = "loan_type")
    private String loanType;

    @Column(name = "total_loan")
    private int totalLoan;

    @Column(name = "amount_paid")
    private int amountPaid;

    @Column(name = "outstanding_amount")
    private int outstandingAmount;

    @Column(name = "create_dt")
    private String createDt;
}
