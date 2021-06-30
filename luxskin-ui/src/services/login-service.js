import axios from 'axios'
const API_URL = 'http://localhost:8080/login'

class LoginService {
  getAllLogins () {
    return axios.get(API_URL + '/allLogins')
  }

  saveLogin (fd, form) {
    return axios.post(API_URL + '/addLogin', fd,
      {
        params: {
          name: form.name,
          password: form.password
        }
      })
  }

  saveLoginDB (form) {
    return axios.post(API_URL + '/addLogin/save',
      {
        name: form.name,
        password: form.password
      })
  }
}
export default new LoginService()
