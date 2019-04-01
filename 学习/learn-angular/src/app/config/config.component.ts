import { Component, OnInit } from '@angular/core';
import { ConfigService } from '../config.service';
import { Config } from '../api/config';

@Component({
  selector: 'app-config',
  templateUrl: './config.component.html',
  styleUrls: ['./config.component.css']
})
export class ConfigComponent implements OnInit {
  config: Config = null;
  headers: string[];
  error: any;

  constructor(private configService: ConfigService) { }

  ngOnInit() {
  }

  showConfig() {
    this.configService.getConfig()
      .subscribe(data => this.config = { ...data }, error => {
        console.error(`error -> ${error}`);
        this.error = error;
      });
  }

  showConfigResponse() {
    this.configService.getConfigResponse()
      .subscribe(response => {
        console.log(response);
        const keys = response.headers.keys();
        this.headers = keys.map(key => `${key}: ${response.headers.get(key)}`);
        this.config = { ...response.body };
      }, error => {
        console.error(typeof error);
        this.error = error;
      }, () => console.log('the end.'));
  }
}
