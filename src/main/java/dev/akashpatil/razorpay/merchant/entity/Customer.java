package dev.akashpatil.razorpay.merchant.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

/**
 * Entity class representing a Customer in the system.
 * This class is mapped to the "customers" table in the database.
 *   CUSTOMER {
 *         uuid id PK
 *         uuid merchantId FK
 *         string name
 *         string email
 *         string contactNumber
 *     };
 */
@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID customerId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "merchant_id", nullable = false, foreignKey = @ForeignKey(name = "fk_customer_merchant"))
    private Merchant merchant;

    @Column(length = 200)
    private String name;

    @Column(length = 200)
    private String email;

    @Column(length = 15)
    private String contactNumber;

}
