import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LoginDataService } from 'src/login-data.service';
import Student from 'src/models/Student';
import { StudentService } from './student.service';
@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  students: Array<Student> = [];
  userId!: Number;
  header:string = "Students of "
  isShown:boolean=false;

  constructor(private loginDataService: LoginDataService, private studentService: StudentService,
    private cdr: ChangeDetectorRef) { }

  ngOnInit(): void {
    this.loginDataService.currentUser.subscribe(user=>{
      this.header += user.username;
      this.userId = user.id;
      this.students = JSON.parse(JSON.stringify(user.students));
    })
  }

  showAddForm():void{
    this.isShown = !this.isShown;
  }

  addStudent(form: NgForm){
    form.value.curatorId = this.userId;
    this.studentService.addStudent(form.value).subscribe({
      next: (value:any) =>{
        
        this.showAddForm();
        this.students.push(value);
      },
      error:(err) => {
        
      },
    })
    

  }
  
  deleteStudent(id:Number){
    this.studentService.deleteStudent(id).subscribe({
      next: (val) => {
        this.students = this.students.filter(value=>value.id!=id);
        this.cdr.detectChanges();
      },
      error: (err) => console.log(err),
      complete: () => console.log('Done')
      
      
      
    })
  }


}
