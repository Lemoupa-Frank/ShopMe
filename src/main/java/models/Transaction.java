package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * $table.getTableComment()
 */
@Data
@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "transaction_id", nullable = false)
    private String transactionId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "status")
    private String status;

    @Column(name = "date", nullable = false)
    private Date date;

}
