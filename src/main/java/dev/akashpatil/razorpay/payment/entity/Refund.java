package dev.akashpatil.razorpay.payment.entity;

import dev.akashpatil.razorpay.shared.entity.Money;
import dev.akashpatil.razorpay.shared.enums.RefundStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "refunds")
@Getter
@Setter
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID refundId;

    @ManyToOne
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @Column(nullable = false)
    private UUID merchantId;

    @Embedded
    private Money money;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RefundStatus status =  RefundStatus.PENDING;

    @Column(nullable = false)
    private String bankReference;

    @Column(length = 100)
    private String errorCode;

    @Column(length = 500)
    private String errorDescription;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> notes;

    private LocalDateTime processedAt;




}
