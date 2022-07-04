package com.project.WebApp.controller;

import com.project.WebApp.model.ResultSalaryPayment;
import com.project.WebApp.model.Salary;
import com.project.WebApp.model.SalaryPayment;
import com.project.WebApp.model.Timesheets;
import com.project.WebApp.repository.SalaryPayRepository;
import com.project.WebApp.repository.SalaryRepository;
import com.project.WebApp.repository.TimesheetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.sql.Date;
import java.util.Calendar;
import java.util.Optional;
@Controller
@RequestMapping(path = "salaryPayment")
public class SalaryPaymentController {
    @Autowired
    private TimesheetsRepository timesheetsRepository;
    @Autowired
    private SalaryRepository salaryRepository;
    @Autowired
    private SalaryPayRepository salaryPayRepository;

    //get detail salary payment
    //localhost:8080/salaryPayment/getSalaryByStaffID/
    @RequestMapping(value = "/getSalaryByStaffID/{staffID}",method = RequestMethod.GET)
    public String getSalaryByStaffID(ModelMap modelMap,
                                     @PathVariable String staffID) {
        Optional<SalaryPayment> foundSalaryPayment = salaryPayRepository.findByStaffIDAndMon(staffID,Calendar.getInstance().get(Calendar.MONTH)+1);
        if(!foundSalaryPayment.isPresent()){
            Optional<Timesheets> timesheet = timesheetsRepository.findByStaffIDAndMon(staffID, (Calendar.getInstance().get(Calendar.MONTH))+1);
            if(timesheet.isPresent()){
                String date = timesheet.get().getYea()+"-"+timesheet.get().getMon()+"-01";
                Optional<Salary> salary = salaryRepository.findByStaffIDAndYear(staffID, Date.valueOf(date));
//            modelMap.addAttribute("salary",salary);
                if (salary.isPresent()){
                    SalaryPayment newSalaryPayment =  SalaryPayment.calSalaryPayment(timesheet.get(), salary.get());
                    salaryPayRepository.save(newSalaryPayment);
                    modelMap.addAttribute("salaryPayment",newSalaryPayment);
                    return "detailSalaryPayment";
                }
            }
//        modelMap.addAttribute("error","Don't have any data !!");
            return "notFoundData";
        }
        modelMap.addAttribute("salaryPayment",foundSalaryPayment.get());
        modelMap.addAttribute("timesheet",timesheetsRepository.findByStaffIDAndMon(staffID,
                (Calendar.getInstance().get(Calendar.MONTH))+1).get());
        return "detailSalaryPayment";
    }

    //get all salary payments
    //localhost:8080/salaryPayment/getAllSalaryPayments
    @RequestMapping(value = "/getAllSalaryPayments", method = RequestMethod.GET)
    public String getAllSalaryPayments(ModelMap modelMap){
        Iterable <Timesheets> timesheets = timesheetsRepository.findAllByMon(Calendar.getInstance().get(Calendar.MONTH)+1);
//        List<SalaryPayment> salaryPaymentList = new ArrayList<SalaryPayment>();
        for(Timesheets timesheet : timesheets){
            String date = timesheet.getYea()+"-"+ timesheet.getMon()+"-01";
            Optional<Salary> salary = salaryRepository.findByStaffIDAndYear(timesheet.getStaffID(), Date.valueOf(date));
            if (salary.isPresent()){
                salaryPayRepository.save(SalaryPayment.calSalaryPayment(timesheet, salary.get()));
            }
            else {
                salaryPayRepository.save(new SalaryPayment(timesheet.getStaffID(),
                        null,
                        timesheet.getTimeshID(),
                        timesheet.getMon(),
                        timesheet.getYea(),
                        null,null,null));
            }
        }
        Iterable <ResultSalaryPayment> resultSalaryPayments = salaryPayRepository.resultSalaryPayment();
        Double sumActReceived = salaryPayRepository.sumActReceived();
        modelMap.addAttribute("results", resultSalaryPayments);
        modelMap.addAttribute("sumActReceived",sumActReceived);
        return "listSalaryPayments";
    }

    //get all salary payments
    //localhost:8080/salaryPayment/getAllSalaryPayments
    @RequestMapping(value = "/getSalaryPaymentsByRoomID/{roomID}", method = RequestMethod.GET)
    public String getSalaryPaymentsByRoomID(ModelMap modelMap,
                                            @PathVariable String roomID){
        Iterable <Timesheets> timesheets = timesheetsRepository.findByRoomIDAndMon(roomID,Calendar.getInstance().get(Calendar.MONTH)+1,
                                                                                   Calendar.getInstance().get(Calendar.YEAR));
//        List<SalaryPayment> salaryPaymentList = new ArrayList<SalaryPayment>();
        for(Timesheets timesheet : timesheets){
            String date = timesheet.getYea()+"-"+ timesheet.getMon()+"-01";
            Optional<Salary> salary = salaryRepository.findByStaffIDAndYear(timesheet.getStaffID(), Date.valueOf(date));
            if (salary.isPresent()){
                salaryPayRepository.save(SalaryPayment.calSalaryPayment(timesheet, salary.get()));
            }
            else {
                salaryPayRepository.save(new SalaryPayment(timesheet.getStaffID(),
                        null,
                        timesheet.getTimeshID(),
                        timesheet.getMon(),
                        timesheet.getYea(),
                        null,null,null));
            }
        }
        Iterable <ResultSalaryPayment> resultSalaryPayments = salaryPayRepository.resultSalaryPaymentByRoomID(roomID);
        Double sumActReceived = salaryPayRepository.sumActReceivedByRoomID(roomID);
        modelMap.addAttribute("results", resultSalaryPayments);
        modelMap.addAttribute("sumActReceived",sumActReceived);
        return "listSalaryPayments";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll(ModelMap modelMap){
        modelMap.addAttribute(modelMap.addAttribute("results", salaryPayRepository.findAll()));
        return"allSalaryPay";
    }

}
