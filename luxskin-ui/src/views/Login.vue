<template>
  <div class="login">
    <div class = "container">
      <div class = "row">
        <div class="col-6">
          <form>
            <div class="form-group">
              <label for="exampleInputName">Име</label>
              <input type="text" class="form-control" id="exampleInputName" required v-model="login.name" placeholder="Въведи име">
            </div>
            <div class="form-group">
              <label for="exampleInputPassword">Парола</label>
              <input type="password" class="form-control" id="exampleInputPassword" required v-model="login.password" placeholder="Въведи парола">
            </div>
            <button type="submit" class="btn btn-primary" v-on:click="saveLogin">Вход</button>
          </form>
        </div>
        <div class="col-6">
          <div class="signup"> <img src="../assets/sign-up.gif" alt="Sign up sign"> </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import LoginService from '../services/login-service'

export default {
  name: 'Login',
  data () {
    return {
      message: '',
      login: {
        name: '',
        password: ''
      }
    }
  },
  methods: {
    setData (response) {
      this.login = response.data()
    },
    saveLogin () {
      LoginService.saveLoginDB(this.login).then(
        response => {
          console.log(response)
          this.login = response.data
        },
        error => {
          this.content =
            (error.response && error.response.data) ||
            error.message ||
            error.data.message.toString()
        }
        /* function validate () {
          var name = this.login.getElementById('name').value
          var password = this.login.getElementById('password').value
          if (this.login.name === 'Силвия' && this.login.password === '1234') {
            window.location.href = 'https://www.google.com/'
            return false
          }
        } */)
    }
  }
}
</script>

<style scoped>
.form-group
{
  font-weight: bold;
  text-align: center;
  width: 500px;
  margin-left: 30px;
  padding-bottom: 10px;
}
label
{
  color: #ff0066;
  font-weight: bold;
}

.order input
{
  border: 1px solid #ccc;
  font-weight: bold;
  height: 33px;
  text-align: center;
  width: 30px;
  margin-top: 10px;
}
form .btn-primary
{
  background: #ff0066;
  color: white;
  font-size: 15px;
  margin-top: 10px;
  margin-left: 20px;
  border: 2px solid purple;
}
form
{
  padding-bottom: 100px;
  padding-top: 120px;
}
</style>
