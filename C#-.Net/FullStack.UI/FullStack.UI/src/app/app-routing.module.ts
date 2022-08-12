import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddEmployeeComponent } from './components/components/add-employee/add-employee.component';
import { EditEmployeeComponent } from './components/components/edit-employee/edit-employee.component';
import { EmployessListComponent } from './components/employess-list/employess-list.component';

const routes: Routes = [
  {
    path: '',
    component: EmployessListComponent
  },
  {
    path: 'employees',
    component: EmployessListComponent
  },
  {
    path: 'employees/add',
    component: AddEmployeeComponent
  },
  {
    path: 'employees/edit/:id',
    component: EditEmployeeComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
