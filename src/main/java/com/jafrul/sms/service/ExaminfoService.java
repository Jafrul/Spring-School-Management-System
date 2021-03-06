
package com.jafrul.sms.service;

import com.jafrul.sms.model.Examinfo;
import org.springframework.stereotype.Service;


@Service
public interface ExaminfoService {

    public String insertExaminfo(Examinfo sub);

    public String updateExaminfo(Examinfo sub);

    public Integer deleteExaminfo(int id);

    public String viewExaminfo();

    public Examinfo viewOneExaminfo(int id);
    
    public Examinfo viewOneExamtitle(String extitle);

}
