package com.ulianaafonina.spring.hibernate_tests.hibernate_many_to_many.entity;

import javax.management.monitor.GaugeMonitor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private List<Section> sections;

    public void addSectionToChild(Section section) {
        if (sections == null) {
            sections = new ArrayList<>();
        }
        sections.add(section);
    }

    public Child(int age, String firstName) {
        this.age = age;
        this.firstName = firstName;
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

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
