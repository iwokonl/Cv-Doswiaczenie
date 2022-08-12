import { Component, OnInit } from '@angular/core';
import { EmployeesService } from 'src/app/services/employees.service';
import {Employee} from '../../models/employee.model'

@Component({
  selector: 'app-employess-list',
  templateUrl: './employess-list.component.html',
  styleUrls: ['./employess-list.component.css']
})
export class EmployessListComponent implements OnInit {
  employess: Employee[] = [];
  constructor(private employeesService: EmployeesService) { }

  ngOnInit(): void {
    this.employeesService.getAllEmployees()
    .subscribe({
      next: (employess) => {
        this.employess = employess;
        console.log(this.employess);
      },
      error(response){
        console.log(response);
      }
    })

  }

}
