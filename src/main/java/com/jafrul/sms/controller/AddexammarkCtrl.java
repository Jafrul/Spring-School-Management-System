/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jafrul.sms.controller;

import com.jafrul.sms.model.Academicyear;
import com.jafrul.sms.model.Classname;
import com.jafrul.sms.model.Classsection;
import com.jafrul.sms.model.Studentinfo;
import com.jafrul.sms.model.Studentregistration;
import com.jafrul.sms.service.AcademicyearService;
import com.jafrul.sms.service.ClassnameService;
import com.jafrul.sms.service.ClasssectionService;
import com.jafrul.sms.service.ExaminfoService;
import com.jafrul.sms.service.StgroupService;
import com.jafrul.sms.service.StudentinfoService;
import com.jafrul.sms.service.StudentregistrationService;
import com.jafrul.sms.service.SubjectService;
import com.jafrul.sms.model.Stgroup;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HP
 */
@Controller
public class AddexammarkCtrl {

    @Autowired
    StudentregistrationService streg;

    @Autowired
    StudentinfoService stinfo;

    @Autowired
    StgroupService stgroup;

    @Autowired
    AcademicyearService year;

    @Autowired
    SubjectService sub;

    @Autowired
    ClassnameService classser;

    @Autowired
    ClasssectionService classsec;

    @Autowired
    StudentregistrationService sts;
    @Autowired
    ExaminfoService exms;
    
    
    @RequestMapping("/studentmarksaddpage")
    public ModelAndView showteacherpage() {
        String studentlist = stinfo.viewstudent();

        ModelAndView mv = new ModelAndView("admin/addexammark", "ExamMarkObject", new Studentinfo());
        mv.addObject("StList", studentlist);

        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping("/marksaddbutton")
    public String showmarkpage(@RequestParam("getregid") int regid, HttpSession marksession) {       
        Studentregistration sr = sts.viewOneStudentregistration(regid);
        int studentid = sr.getStid();
        Studentinfo sinfo = stinfo.viewOnestudent(studentid);
        
        int classid = sr.getClassid();
        Classname clsname = classser.viewOneClassname(classid);
        
        int yid = sr.getYearid();
        Academicyear accy = year.viewOneAcademicyear(yid);
        
        int seid = sr.getSecid();
        Classsection section = classsec.viewOneClasssection(seid);
        
        int gid = sr.getGroupid();
        Stgroup group = stgroup.viewOneStgroup(gid);
               
        
        
        marksession.setAttribute("regstudentlist", sr);
        marksession.setAttribute("studentinfo", sinfo);
        marksession.setAttribute("classnm", clsname);
        marksession.setAttribute("academic", accy);
        marksession.setAttribute("section", section);
        marksession.setAttribute("group", group);
        //marksession.setAttribute("markcart", new ArrayList<MarksCart>());
        //marksession.setAttribute("mcarempty", "true");
        
        //String subjectlist = sub.viewSubject();
        //String examlist = exms.viewExaminfo();
        
        //ModelAndView mv = new ModelAndView("admin/marksadd", "MarkObject", new Exammark());

        //mv.addObject("subList",subjectlist);
        //mv.addObject("examList",examlist);
//        mv.addObject("check", "true");
//        Gson g = new Gson();
//        
//        ArrayList<MarksCart> cd = (ArrayList<MarksCart>) marksession.getAttribute("markCart");
//        if (cd.isEmpty()) {
//            marksession.setAttribute("cartsempty", "true");
//            mv.addObject("markCart", "null");
//            return mv;
//
//        } else {
//            String cartgson = g.toJson(cd);
//            mv.addObject("markCart", cartgson);
//            System.out.println(cartgson);
//            marksession.setAttribute("cartsempty", "false");
//            return mv;
//
//        }

            return "redirect:/showaddmarkpage";
        
    }
    
    
    

    
    
    

}
