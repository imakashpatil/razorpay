package dev.akashpatil.razorpay.merchant.entity;

import dev.akashpatil.razorpay.shared.enums.Environment;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Entity class representing an API key associated with a merchant.
 * This class is mapped to the "api_keys" table in the database.
 *   API_KEY {
 *         uuid id PK
 *         uuid merchant_id FK
 *         string key_id
 *         string key_secret_hash
 *         string environment
 *         boolean enabled
 *         datetime created_at
 *         datetime rotated_at
 *         datetime grace_period_expired_at
 *     }
 */

@Entity
@Table(
        name = "api_keys",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"key_id"}, name = "uk_api_key_id")
        }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiKey {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID apiKeyId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "merchant_id", nullable = false, foreignKey = @ForeignKey(name = "fk_api_key_merchant"))
    private Merchant merchant;

    @Column(nullable = false, length = 100)
    private String keyId;

    @Column(nullable = false, length = 200)
    private String keySecretHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Environment environment;

    @Column(nullable = false)
    private boolean enabled = true;

    LocalDateTime createdAt;
    LocalDateTime rotatedAt;
    LocalDateTime gracePeriodExpiredAt;

}
