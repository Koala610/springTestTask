import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginFormComponent } from './login-form/login-form.component';
import { StudentListComponent } from './student-list/student-list.component';

const routes: Routes = [
  {path: 'login', component: LoginFormComponent},
  {path: '', component: StudentListComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
