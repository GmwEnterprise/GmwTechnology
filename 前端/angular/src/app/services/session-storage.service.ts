import { Injectable } from '@angular/core';

const store = sessionStorage;

@Injectable({
  providedIn: 'root'
})
export class SessionStorageService {

  constructor() { }

  public get<E>(key: string) {
    const val = store.getItem(key);
    return val ? JSON.parse(val) as E : null;
  }

  public getList<T>(key: string): T[] {
    const before = store.getItem(key);
    return before ? (JSON.parse(before) as T[]) : [];
  }

  public set(key: string, value: any): void {
    if (!value || value === undefined) {
      return;
    }
    const arr = JSON.stringify(value);
    store.setItem(key, arr);
  }
}
