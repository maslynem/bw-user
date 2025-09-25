package ru.boardworld.user.entity

import jakarta.persistence.*
import org.hibernate.annotations.UpdateTimestamp
import java.time.OffsetDateTime
import java.util.*

@Entity
@Table(name="users")
class User (

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,

    var displayedName: String? = null,

    @Column(unique = true, nullable = false)
    var username: String? = null,

    @Column(unique = true, nullable = false)
    var email: String? = null,

    @Column(name = "password_hash")
    var passwordHash: String? = null,

    @Column(name = "created_at", nullable = false, updatable = false)
//    @CreationTimestamp
    var createdAt: OffsetDateTime? = null,

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    var  updatedAt: OffsetDateTime? = null,

    @Column(name = "last_login")
    var lastLogin: OffsetDateTime? = null,

    @ManyToMany
    @JoinTable(
        name = "user_roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    var roles: MutableSet<Role> = hashSetOf()
)