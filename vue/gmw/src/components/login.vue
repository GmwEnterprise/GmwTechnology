<template>
  <div class="login">
    <form class="login-form">
      <div class="form-input">
        <label for="">登录名：</label>
        <input type="text" v-model="inputName" />
      </div>
      <div class="form-input">
        <label for="">密码：</label>
        <input type="password" v-model="password" />
      </div>
      <div class="form-submit">
        <button class="btn-submit" type="button" @click="submit">提交</button>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      inputName: "",
      password: ""
    };
  },
  computed: {}
};
</script>

<style>
.login {
  width: 300px;
}
.login-form {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}
.form-input {
  display: flex;
  justify-content: space-between;
}
.form-input > label {
  width: 35%;
  box-sizing: border-box;
  padding-left: 30px;
}
.form-input > input {
  width: 55%;
}
</style>
