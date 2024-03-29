package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

/**
 * $table.getTableComment()
 */
@Data
@Entity
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "prouduct_id", nullable = false)
    private String prouductId;

    @Column(name = "ordered")
    private Long ordered;

    @Column(name = "price")
    private Long price;

    @Column(name = "available")
    private Long available;

}
