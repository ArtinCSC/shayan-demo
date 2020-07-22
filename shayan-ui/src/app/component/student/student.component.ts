import { Component, OnInit } from '@angular/core';
import {Student, StudentService} from 'src/app/service/student.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styles: ['']
})
export class StudentComponent implements OnInit {
  title = 'Student Info';
  student: Student = new Student();
  students: Student[] = [];

  constructor(private service: StudentService) {
   }

  ngOnInit(): void {
    this.student.firstName = 'Shayan';
    this.student.lastName = 'Malekian';
    this.student.number = 1234;
  }

  // tslint:disable-next-line:typedef
  save() {
    this.service.post('student', this.student)
      .subscribe(
        r => this.student = r
      );
  }

  // tslint:disable-next-line:typedef
  getStudents() {
    this.service.get('student')
      .subscribe(
        r => this.students = r
      );
  }
}
