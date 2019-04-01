import { PipeTransform, Pipe } from '@angular/core';

@Pipe({
  name: 'tostring'
})
export class ToString implements PipeTransform {
  transform(value: any, ...args: any[]): string {
    return JSON.stringify(value);
  }
}