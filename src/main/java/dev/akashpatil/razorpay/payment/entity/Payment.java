package dev.akashpatil.razorpay.payment.entity;

import dev.akashpatil.razorpay.shared.entity.Money;
import dev.akashpatil.razorpay.shared.enums.PaymentMethod;
import dev.akashpatil.razorpay.shared.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

/**
 * Entity class representing a Payment in the system.
 * This class is mapped to the "payments" table in the database.
 *   PAYMENT {
 *         uuid payment_id PK
 *         uuid order_id FK
 *         uuid merchant_id FK
 *         long amount - stored in the smallest currency unit (e.g.,paisa for INR)
 *         string idempotency_key
 *         string status
 *         string method
 *         jsonb method_details
 *         string bank_reference
 *         string error_code
 *         string error_description
 *         datetime authorized_at
 *         datetime captured_at
 *         datetime failed_at
 *         datetime cancelled_at
 *         datetime refunded_at
 *         datetime settled_at
 *     };
 */

@Entity
@Table(name = "payments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID paymentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private OrderRecord orderRecord;

    @Column(name = "merchant_id", nullable = false)
    private UUID merchantId;

    @Embedded
    private Money amount;

    @Column(nullable = false, length = 100)
    private String idempotencyKey;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private PaymentStatus status = PaymentStatus.CREATED;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private PaymentMethod method;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "method_details", columnDefinition = "jsonb")
    private Map<String, Object> methodDetails;

    @Column(length = 100)
    private String bankReference;

    @Column(length = 100)
    private String errorCode;

    @Column(length = 255)

    private String errorDescription;

    private LocalDateTime authorizedAt;

    private LocalDateTime capturedAt;

    private LocalDateTime failedAt;

    private LocalDateTime cancelledAt;

    private LocalDateTime refundedAt;

    private LocalDateTime settledAt;


}
