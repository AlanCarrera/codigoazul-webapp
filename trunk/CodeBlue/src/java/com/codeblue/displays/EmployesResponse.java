/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.codeblue.displays;

import com.bluecode.businessObjects.Employe;
import java.util.List;

/**
 *
 * @author Laser Marker
 */
public class EmployesResponse {
    private List<Employe> employeList;

    public EmployesResponse(List<Employe> employeList) {
        this.employeList = employeList;
    }

    public List<Employe> getEmployeList() {
        return employeList;
    }

    public void setEmployeList(List<Employe> employeList) {
        this.employeList = employeList;
    }
    
}
