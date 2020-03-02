
package com.jafrul.sms.service;

import com.jafrul.sms.model.Classname;
import org.springframework.stereotype.Service;


@Service
public interface ClassnameService {

    public String insertClassname(Classname sub);

    public String updateClassname(Classname sub);

    public Integer deleteClassname(int id);

    public String viewClassname();

    public Classname viewOneClassname(int id);

}
