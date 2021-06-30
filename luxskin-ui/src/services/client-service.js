import axios from 'axios'
const API_URL = 'http://localhost:8080/client'

class ClientService {
  getAllClients () {
    return axios.get(API_URL + '/allClients')
  }

  saveClient (fd, form) {
    return axios.post(API_URL + '/addClient', fd,
      {
        params: {
          name: form.name,
          email: form.email,
          product_name: form.product_name,
          count_client: form.count_client,
          price: form.price
        }
      })
  }

  saveClientDB (form) {
    return axios.post(API_URL + '/addClient/save',
      {
        name: form.name,
        email: form.email,
        product_name: form.product_name,
        count_client: form.count_client,
        price: form.price
      })
  }
}
export default new ClientService()
