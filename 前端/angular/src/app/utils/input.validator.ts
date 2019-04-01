import { ValidatorFn, AbstractControl, ValidationErrors } from '@angular/forms';

/**
 * 自定义验证器，表单项需匹配作为参数的表达式
 * @param reg 正则表达式
 */
export function regExpMatchesValidator(reg: RegExp): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => reg.test(control.value) ? null : {
    message: 'the value does not match the exp'
  };
}
