import {Component, OnInit} from '@angular/core';
import {Student, StudentService} from 'src/app/service/student.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styles: ['']
})
export class AppComponent implements OnInit {
  title = 'Student Info';
  student: Student = new Student();
  students: Student[] = [];

  constructor(private service: StudentService) {
  }

  // tslint:disable-next-line:typedef
  ngOnInit() {
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
