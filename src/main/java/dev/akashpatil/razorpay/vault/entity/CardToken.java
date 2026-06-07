package dev.akashpatil.razorpay.vault.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        name = "card_token",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_token", columnNames = "token")
        }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardToken {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID cardTokenId;

    @Column(nullable = false,  length = 50)
    private String token;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn( name = "card_vault_id")
    private CardVault cardVault;

    @Column(nullable = false)
    private UUID customer;

    @Column(nullable = false)
    private UUID merchant;

    private LocalDateTime revokedAt;


}
