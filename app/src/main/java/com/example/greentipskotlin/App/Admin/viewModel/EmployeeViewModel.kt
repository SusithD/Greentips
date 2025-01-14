package com.example.greentipskotlin.App.Admin.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.greentipskotlin.App.Model.Employee
import com.example.greentipskotlin.App.Model.EmployeeDataProvider
import com.example.greentipskotlin.App.Model.EmployeePosition
import com.example.greentipskotlin.App.Model.EmployeePositionDataProvider

class EmployeeViewModel (application: Application) : AndroidViewModel(application)  {

    private val employeePostionData = MutableLiveData<EmployeePosition>()
    private val employeeDataProvider = EmployeeDataProvider(application.applicationContext)
    private val employees = employeeDataProvider.getAllEmployees()
    private val employeePositionDataProvider = EmployeePositionDataProvider(application.applicationContext)


    fun getAllEmployees(): List<Employee> {
        Log.d("EmployeeRepository", "Number of employees: ${employees.size}")
        return employees
    }

    fun insertEmployeePosition(employeePosition: EmployeePosition) {
        employeePositionDataProvider.insertEmployeePosition(employeePosition)
    }

    fun insertEmployee(employee: Employee){
        employeeDataProvider.insetEmployee(employee)
    }
}