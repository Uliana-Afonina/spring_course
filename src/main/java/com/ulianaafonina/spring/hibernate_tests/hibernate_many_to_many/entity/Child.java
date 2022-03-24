package com.ulianaafonina.spring.hibernate_tests.hibernate_many_to_many.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "children")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Override
    public String toString() {
        return "Child {" +
                "\nid = " + id +
                ", \nage = " + age +
                ", \nfirstName = '" + firstName + "\n " +
                '}';
    }

    @Column(name = "age")
    private int age;

    @Column(name = "name")
    private String firstName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "child_section"
            , joinColumns = @JoinColumn(name = "child_id")
            , inverseJoinColumns = @JoinColumn(name = "section_id")
    )
    private Set<Section> sections;

    public void addSectionToChild(Section section) {
        if (sections == null) {
            sections = new LinkedHashSet<>();
        }
        sections.add(section);
    }

    public Child(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    public Child() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Set<Section> getSections() {
        return sections;
    }

    public void setSections(Set<Section> sections) {
        this.sections = sections;
    }
}
