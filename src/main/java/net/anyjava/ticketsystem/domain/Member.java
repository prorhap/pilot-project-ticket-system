package net.anyjava.ticketsystem.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String passWord;

    @OneToOne(mappedBy = "member")
    private Ticket ticket;

}
