import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { URL_USER } from '../constant';
import { LocalStorageService } from './local-storage.service';
import { SessionStorageService } from './session-storage.service';

export enum StoreType {
  SESSION, LOCAL
}

export const CURRENT_USER_KEY = 'current';

@Injectable({
  providedIn: 'root'
})
export class UserMessageService {

  constructor(
    private http: HttpClient,
    private local: LocalStorageService,
    private session: SessionStorageService
  ) { }

  public login(userMsg: any): Observable<any> {
    return this.http.get<any>(URL_USER + '/login', {
      params: {
        phone: userMsg.phone,
        password: userMsg.password
      }
    });
  }

  public saveCurrentUser(storeType: StoreType, data: any): void {
    switch (storeType) {
      case StoreType.LOCAL:
        this.local.set(CURRENT_USER_KEY, data);
        break;
      case StoreType.SESSION:
        this.session.set(CURRENT_USER_KEY, data);
        break;
      default:
        this.session.set(CURRENT_USER_KEY, data);
    }
  }
}
