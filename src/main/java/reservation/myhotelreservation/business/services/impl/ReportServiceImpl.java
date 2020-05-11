/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.business.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reservation.myhotelreservation.build.BuilderReport;
import reservation.myhotelreservation.business.service.ReportService;
import reservation.myhotelreservation.dto.Report;


/**
 *
 * @author simonecipullo
 */
@Service
@Transactional
public class ReportServiceImpl implements ReportService {
    
    @Autowired
    private BuilderReport buildReport;
    
    @Override
    public Report showReportCustomer(String number, Integer page, Integer size) {
        
        return buildReport.build(number, page, size);
        
    }
    
}
