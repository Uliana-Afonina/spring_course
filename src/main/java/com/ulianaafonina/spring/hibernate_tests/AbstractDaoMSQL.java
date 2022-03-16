package com.ulianaafonina.spring.hibernate_tests;

import com.ulianaafonina.spring.hibernate_tests.hibernate_one_to_one.entity.Detail;
import com.ulianaafonina.spring.hibernate_tests.hibernate_one_to_one.entity.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class AbstractDaoMSQL implements GeneralDaoSQL{
    @Override
    public abstract SessionFactory getFactory();
}
