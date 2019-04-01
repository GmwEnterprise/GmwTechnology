import { Component, OnInit } from '@angular/core';
import { LocalStorageService } from 'src/app/services/local-storage.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  userMsg: any = null;

  constructor(private ls: LocalStorageService) { }

  ngOnInit() {
    this.userMsg = this.ls.get('currentUser');
  }

}
