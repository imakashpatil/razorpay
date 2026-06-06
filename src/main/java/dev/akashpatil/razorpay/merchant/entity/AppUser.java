package dev.akashpatil.razorpay.merchant.entity;

import dev.akashpatil.razorpay.shared.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

/**
 * Entity class representing an application user associated with a merchant.
 * This class is mapped to the "app_users" table in the database.
 *   APP_USER {
 *         uuid id PK
 *         uuid merchant_id FK -> MERCHANT.merchant_id
 *         string email
 *         string password_hash
 *         enum role
 *     };
 */

@Entity
@Table(name = "app_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUser{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID appUserId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merchant_id", nullable = false, foreignKey = @ForeignKey(name = "fk_app_user_merchant"))
    private Merchant merchant;

    @Column(nullable = false, length = 100)
    String email;

    @Column(nullable = false)
    String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private UserRole role;
}
