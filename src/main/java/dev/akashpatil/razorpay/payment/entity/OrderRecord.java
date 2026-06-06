package dev.akashpatil.razorpay.payment.entity;

import dev.akashpatil.razorpay.shared.entity.Money;
import dev.akashpatil.razorpay.shared.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * Entity class representing an Order Record in the system.
 * This class is mapped to the "order_records" table in the database.
 *   ORDER_RECORD {
 *         uuid id PK
 *         uuid merchant_id FK
 *         uuid customer_id FK
 *         long amount - stored in the smallest currency unit (e.g.,paisa for INR)
 *         string status
 *         int attempts
 *         jsonb notes
 *         datetime expires_at
 *     }
 */

@Entity
@Table(name = "order_records")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID orderId;
    // no FK - cross service reference to avoid tight coupling between services
    @Column(name = "merchant_id", nullable = false)
    private UUID merchantId;

    @Embedded
    private Money amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private OrderStatus orderStatus = OrderStatus.CREATED;

    @Column(nullable = false)
    private Integer attempts = 0 ;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String , Object> notes;

    @Column(nullable = false)
    private LocalDateTime expiresAt;


}
