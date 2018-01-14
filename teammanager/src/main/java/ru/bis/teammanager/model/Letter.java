package ru.bis.teammanager.model;

import javax.persistence.*;

@Entity
@Table(name = "LETTERS")
public class Letter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "LETTER_ID")
    private long letterId;
    private String to;
    private String subject;
    private String text;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Letter(String to, String subject, String text, Person person) {
        this.to = to;
        this.subject = subject;
        this.text = text;
        this.person = person;
    }

    public Letter() {
    }

    public long getLetterId() {
        return letterId;
    }

    public void setLetterId(long letterId) {
        this.letterId = letterId;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
