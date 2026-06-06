package dev.akashpatil.razorpay.merchant.entity;

import dev.akashpatil.razorpay.shared.enums.BusinessType;
import dev.akashpatil.razorpay.shared.enums.MerchantStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

/**
 * Entity class representing a Merchant in the system.
 * This class is mapped to the "merchants" table in the database.
 *   MERCHANT {
 *         uuid id PK
 *         string name
 *         string business_name
 *         string email
 *         string contactNumber
 *         enum business_type
 *         enum status
 *         string gstNumber
 *         string panNumber
 *         string settlement_bank_account
 *         string settlement_account_holder_name
 *     };
 */
@Entity
@Table(
        name = "merchants",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email", name = "uk_merchant_email")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID merchantId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 100)
    private String businessName;

    @Column(nullable = false)
    private String email;

    @Column(length = 15)
    private String contactNumber;

    @Column(length = 30)
    @Enumerated(EnumType.STRING)
    private BusinessType businessType;

    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private MerchantStatus status = MerchantStatus.PENDING_KYC;

    @Column(length = 15)
    private String gstNumber;

    @Column(length = 10)
    private String panNumber;

}
