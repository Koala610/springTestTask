import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import Student from 'src/models/Student';
import { AppComponent } from '../app.component';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  BASE_URL = AppComponent.BASE_URL;

  constructor(private client : HttpClient) { }

  deleteStudent(id:Number):Observable<object>{
    return this.client.delete<object>(this.BASE_URL+'/students/'+id.toString());
  }

  addStudent(student:Student):Observable<object>{
    return this.client.post<object>(this.BASE_URL+'/students/', student);
  }
}
