import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';
import { UpdateService } from 'src/app/services/update.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  splitCache = sessionStorage.getItem('cache').split(' ');
  name = this.splitCache[2] + ' ' + this.splitCache[3];
  UserId = this.splitCache[0];
  role_id = this.splitCache[4];

  status = 0;
  author = 0;
  reimbIds = 0;

  UpdateResponse: Subscription;
  lastStatus = 200;

  constructor(private router: Router, private updateService: UpdateService) { }

  ngOnInit() {
    this.UpdateResponse = this.updateService.$UpdateStatus.subscribe(status => {
      if (status === 200) {
        this.router.navigateByUrl('employee');
      } else {
        this.lastStatus = status;
      }
    })}

  submit(){
    console.log('submitted');
    this.updateService.Update(this.status, this.author, this.reimbIds);
    this.router.navigateByUrl('employee');
  }

}
