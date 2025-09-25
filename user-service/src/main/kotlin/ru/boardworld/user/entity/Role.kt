package ru.boardworld.user.entity

import jakarta.persistence.*
import org.hibernate.Hibernate

@Entity
@Table(name="roles")
class Role (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    @Column(unique = true, nullable = false)
    var name: String? = null,

    var description: String? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null) return false
        Hibernate.getClass(this)
        if (Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Role

        return id != null && id == other.id
    }

    override fun hashCode(): Int =
        Hibernate.getClass(this).hashCode()

}