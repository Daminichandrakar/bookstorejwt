package com.bookstore.bookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

    @Entity
    @Data
    @AllArgsConstructor
    @Table(name = "users",
            uniqueConstraints = {
                    @UniqueConstraint(columnNames = "username"),
                    @UniqueConstraint(columnNames = "email"),
            })
    public class User implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank
        @Size(max = 20)
        @Column(name = "username", unique = true)
        private String username;

        @NotBlank
        @Size(max = 50)
        @Email
        private String email;

        @NotBlank(message = "Password shouldn't be blank")
        @Size(max = 120)
        private String password;

        @NotBlank
//    @Pattern(regexp="(^$|[0-9]{10})")
        private String phoneNumber;

        private boolean isVerified;

        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(name = "user_roles",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
        private Set<Role> roles = new HashSet<>();

//        @OneToMany
//        @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
//        private List<Cart> cartList;

//        @OneToMany
//        @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
//        private List<Wishlist> wishlistList;

        public User() {
        }

        public User(String username, String email, String password, String phoneNumber) {
            this.username = username;
            this.email = email;
            this.password = password;
            this.phoneNumber = phoneNumber;
        }

    }

