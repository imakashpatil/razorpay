package dev.akashpatil.razorpay.merchant.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

/**
 * Entity class representing a Merchant's Bank Account in the system.
 * This class is mapped to the "merchant_bank_account" table in the database.
 * It contains details about the bank account associated with a merchant for settlement purposes.
 *  MERCHANT_BANK_ACCOUNT {
 *         uuid id PK
 *         uuid merchant_id FK
 *         string bank_name
 *         string account_number
 *         string ifsc_code
 *         string account_holder_name
 *         boolean is_primary
 *     };
 */

@Entity
@Table(name = "merchant_bank_accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MerchantBankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID bankAccountId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merchant_id", nullable = false , foreignKey = @ForeignKey(name = "fk_bank_account_merchant"))
    private Merchant merchant;

    @Column(nullable = false, length = 100)
    private String bankName;

    @Column(nullable = false, length = 30)
    private String accountNumber;

    @Column(nullable = false, length = 20)
    private String ifscCode;

    @Column(nullable = false, length = 100)
    private String accountHolderName;

    @Column(nullable = false)
    private boolean isPrimary = false;
}
