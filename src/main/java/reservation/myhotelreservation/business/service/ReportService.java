/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.business.service;

import reservation.myhotelreservation.dto.Report;

/**
 *
 * @author simonecipullo
 */
public interface ReportService {

    Report showReportCustomer(String number, Integer page, Integer size);

}
